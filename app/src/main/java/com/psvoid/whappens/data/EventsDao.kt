package com.psvoid.whappens.data

import androidx.lifecycle.LiveData
import androidx.room.*

/** Defines methods for using the [EventItem] class with [Room]. */
@Dao
interface EventsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: EventItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(events: List<EventItem>)

    /**
     * Update a row with a value already set in a column, replace the old value with the new one.
     * @param events new value to write
     */
    @Update
    suspend fun update(events: List<EventItem>)

    /** Select and returns the row that matches the key. */
    @Query("SELECT * from events_table WHERE id = :key")
    fun get(key: String): LiveData<EventItem>

    /** Delete all values from the table. This does not delete the table. */
    @Query("DELETE FROM events_table")
    suspend fun clear()

    /** Select and returns all rows in the table. */
    @Query("SELECT * FROM events_table")
    suspend fun getAllMarkers(): List<EventItem>

    /** Select and returns all rows in the table. */
    @Query("SELECT * FROM events_table WHERE countryCode = :countryCode")
    suspend fun getMarkersByCountry(countryCode: String): List<EventItem>
}