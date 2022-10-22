package com.playlab.bussolaagil.util

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test

class DirectionsTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun degree_between_0_and_22_should_return_North() {
        for (deg in 0..22){
            assertEquals(getDirectionsLabel(appContext, deg), "N")
        }
    }

    @Test
    fun degree_between_338_and_360_should_return_North() {
        for (deg in 338..360) {
            assertEquals(getDirectionsLabel(appContext, deg), "N")
        }
    }

    @Test
    fun degree_between_23_and_67_should_return_Northeast() {
        for (deg in 23..67) {
            assertEquals(getDirectionsLabel(appContext, deg), "NE")
        }
    }

    @Test
    fun degree_between_68_and_112_should_return_East() {
        for (deg in 68..112) {
            assertEquals(getDirectionsLabel(appContext, deg), "L")
        }
    }

    @Test
    fun degree_between_113_and_157_should_return_Southeast() {
        for (deg in 113..157) {
            assertEquals(getDirectionsLabel(appContext, deg), "SE")
        }
    }

    @Test
    fun degree_between_158_and_202_should_return_South() {
        for (deg in 158..202) {
            assertEquals(getDirectionsLabel(appContext, deg), "S")
        }
    }

    @Test
    fun degree_between_203_and_247_should_return_Southwest() {
        for (deg in 203..247) {
            assertEquals(getDirectionsLabel(appContext, deg), "SO")
        }
    }

    @Test
    fun degree_between_248_and_292_should_return_West() {
        for (deg in 248..292) {
            assertEquals(getDirectionsLabel(appContext, deg), "O")
        }
    }

    @Test
    fun degree_between_293_and_337_should_return_NorthWest() {
        for (deg in 293..337) {
            assertEquals(getDirectionsLabel(appContext, deg), "NO")
        }
    }
}