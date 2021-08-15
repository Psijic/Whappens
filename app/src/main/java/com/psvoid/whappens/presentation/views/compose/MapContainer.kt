package com.psvoid.whappens.presentation.views.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.MapView
import com.psvoid.whappens.presentation.viewmodels.MapViewModel

internal val gMapAsync = MutableLiveData<GoogleMap>()

@Composable
fun MapViewContainer(
    viewModel: MapViewModel = viewModel()
) {

    val map = rememberMapViewWithLifecycle()
    AndroidView({ map }) { mapView: MapView ->
        mapView.getMapAsync {
            gMapAsync.value = it
        }
    }
}

