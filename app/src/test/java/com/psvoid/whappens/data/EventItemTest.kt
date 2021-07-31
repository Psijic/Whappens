package com.psvoid.whappens.data

import kotlin.test.Test
import kotlin.test.assertEquals

internal class EventItemTest {

    @Test
    fun checkDateTime() {
        val event1 = EventItem(
            startTime = "2021-08-02T21:00-10:45", endTime = "2021-08-03T23:00-10:45"
        )

        assertEquals("2021-08-02T21:00", event1.getStartDt().toString())
        assertEquals("2021-08-03T23:00", event1.getEndDt().toString())
        assertEquals("21:00 - 23:00, 02 Aug", event1.getTimePeriod())

        val event2 = EventItem(startTime = "2021-08-02T21:00+08:00")
        assertEquals("2021-08-02T21:00", event2.getStartDt().toString())
        assertEquals("21:00, 02 Aug", event2.getTimePeriod())
    }
}