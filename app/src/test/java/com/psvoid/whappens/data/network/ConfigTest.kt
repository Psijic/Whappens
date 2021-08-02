package com.psvoid.whappens.data.network

import com.psvoid.whappens.data.Config
import com.psvoid.whappens.data.CountryData
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class ConfigTest {

    @Test
    fun timeTest() {
        val previousDayTimestamp =  Config.launchTime - Config.cacheRefreshTime
        val today = Date(Config.launchTime)
        val previousDay = Date(previousDayTimestamp)
//        assertTrue(previousDay)
        val country = CountryData("USA")
        assertTrue(country.timestamp > System.currentTimeMillis() - 100)
        val countryDate = Date(country.timestamp)
    }
}