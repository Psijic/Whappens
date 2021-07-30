package com.psvoid.whappens.data

import kotlin.test.Test
import kotlin.test.assertEquals

internal class EventItemTest {

    @Test
    fun checkDateTime() {
        val event = EventItem(
            startTime = "2021-08-02T21:00-10:45",
            endTime = "2021-08-03T21:00-10:45"
        )

        assertEquals("2021-08-02T21:00", event.getStartDt().toString())
        assertEquals("2021-08-03T21:00", event.getEndDt().toString())

        assertEquals("21:00", event.getStartDt()?.toLocalTime().toString())

        val event2 = EventItem(startTime = "2021-08-02T21:00+08:00")
        assertEquals("2021-08-02T21:00", event2.getStartDt().toString())


    }
}