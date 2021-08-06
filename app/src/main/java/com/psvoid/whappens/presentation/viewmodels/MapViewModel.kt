package com.psvoid.whappens.presentation.viewmodels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.maps.GoogleMap
import com.google.maps.android.clustering.algo.NonHierarchicalViewBasedAlgorithm
import com.psvoid.whappens.data.*
import com.psvoid.whappens.data.Config.today
import com.psvoid.whappens.utils.LoadingStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.collections.set

typealias MarkersMap = MutableMap<String, List<EventItem>>

@RequiresApi(Build.VERSION_CODES.O)
class MapViewModel(application: Application) : AndroidViewModel(application) {
    val algorithm = NonHierarchicalViewBasedAlgorithm<EventItem>(0, 0)

    val selectedEvent = MutableLiveData<EventItem>()
    var isHideUI = MutableLiveData(false)
//    var bottomSheetState = BottomSheetBehavior.STATE_HIDDEN // TODO: save height expanded?

    /** The internal MutableLiveData that stores the status of the most recent request */
    private val _clusterStatus = MutableLiveData<LoadingStatus>()
    val clusterStatus: LiveData<LoadingStatus>
        get() = _clusterStatus

    val gMapAsync = MutableLiveData<GoogleMap>()

    private val markerRepo: EventsRepository
    private val countriesRepo: CountriesRepository

    private val allMarkers: MarkersMap = mutableMapOf()

//    private val markersObserver = { markers: List<ClusterMarker> -> getMarkers(markers) }

    // Events period
    private val _period = MutableLiveData(Config.period)
    val period: LiveData<EventFilter.Period>
        get() = _period

    init {
        val eventsDao = AppDatabase.getInstance(application).eventsDao
        markerRepo = EventsRepository(eventsDao)
        val countriesDao = AppDatabase.getInstance(application).countriesDao
        countriesRepo = CountriesRepository(countriesDao)

        updateMarkers()
    }

    /** Here we set the period of shown cached markers */
    fun setPeriod(value: EventFilter.Period) {
        _period.value = value
        algorithm.clearItems()
        _clusterStatus.value = LoadingStatus.DONE

        allMarkers.forEach {
            // Pass events if they are in the actual date range
            val countryEvents = it.value.filter { event ->
                when (period.value) {
                    EventFilter.Period.FUTURE -> event.startDt.value.nano > System.currentTimeMillis()
                    EventFilter.Period.TODAY -> event.startDt.value.dayOfYear == today.dayOfYear
                    else -> true
                }
            }

            addClusterItems(countryEvents)
        }

    }

    /** Check if Android database have actual markers for current countries. If not, fetch them. */
    private fun updateMarkers() {
        viewModelScope.launch(Dispatchers.IO) {
            for (countryName in Config.countries) {
                val markers = markerRepo.getMarkersByCountry(countryName)
                allMarkers[countryName] = markers
                val countryData = countriesRepo.getByCountry(countryName)
                val timestamp = countryData?.timestamp ?: 0
                // Check if the database data is cleared/broken or outdated
                Timber.i("Getting database data, country: $countryName, timestamp: $timestamp")
                if (markers.isNullOrEmpty() || timestamp < Config.launchTime - Config.cacheRefreshTime) {
                    Timber.d("Fetching markers from Firebase")
                    period.value?.let { fetchMarkers(countryName, it) }
                    //                    markers = markerRepo.fetchFirebase(countryName, period)
                } else {
                    Timber.d("Add markers from cache")
                    addClusterItems(markers)
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    private suspend fun fetchMarkers(countryName: String, period: EventFilter.Period) {
        _clusterStatus.postValue(LoadingStatus.LOADING)

        val markers = markerRepo.fetchFirebase(countryName, period)
        if (markers.isNullOrEmpty()) {
            // Add cached markers if Firebase doesn't work well and returns empty list.
            addClusterItems(allMarkers[countryName])
        } else {
            allMarkers[countryName] = markers
            addClusterItems(markers)
            saveMarkers(countryName, markers)
        }
    }

    /** Add specific settings like event types selected */
    fun fetchEvents(lat: Double, lng: Double, radius: Float) {}

    private fun saveMarkers(countryName: String, markers: List<EventItem>) {
        Timber.i("Saving $countryName markers into DB")
        insertMarkers(markers)
        insertCountry(CountryData(countryName))
    }

    /** Launching a new coroutine to insert the data in a non-blocking way */
    private fun insertMarkers(markers: List<EventItem>) =
        viewModelScope.launch(Dispatchers.IO) { markerRepo.insert(markers) }

    private fun insertCountries(countries: List<CountryData>) =
        viewModelScope.launch(Dispatchers.IO) { countriesRepo.insert(countries) }

    private fun insertCountry(country: CountryData) =
        viewModelScope.launch(Dispatchers.IO) { countriesRepo.insert(country) }

    private fun addClusterItems(items: List<EventItem>?) {
        if (items.isNullOrEmpty()) {
            _clusterStatus.postValue(LoadingStatus.ERROR)
        } else {
            algorithm.addItems(items)
            _clusterStatus.postValue(LoadingStatus.DONE)
        }
    }
}