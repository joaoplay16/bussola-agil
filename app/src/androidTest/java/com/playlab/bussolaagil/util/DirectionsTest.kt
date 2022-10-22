package com.playlab.bussolaagil.util

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import com.playlab.bussolaagil.R

class DirectionsTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun degree_between_0_and_22_should_return_North() {
        with(appContext){
            for (deg in 0..22){
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.north))
            }
        }
    }

    @Test
    fun degree_between_338_and_360_should_return_North() {
        with(appContext){
            for (deg in 338..360) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.north))
            }
        }
    }

    @Test
    fun degree_between_23_and_67_should_return_Northeast() {
        with(appContext){
            for (deg in 23..67) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.northeast))
            }
        }
    }

    @Test
    fun degree_between_68_and_112_should_return_East() {
        with(appContext){
            for (deg in 68..112) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.east))
            }
        }
    }

    @Test
    fun degree_between_113_and_157_should_return_Southeast() {
        with(appContext){
            for (deg in 113..157) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.southeast))
            }
        }
    }

    @Test
    fun degree_between_158_and_202_should_return_South() {
        with(appContext){
            for (deg in 158..202) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.south))
            }
        }
    }

    @Test
    fun degree_between_203_and_247_should_return_Southwest() {
        with(appContext){
            for (deg in 203..247) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.southwest))
            }
        }
    }

    @Test
    fun degree_between_248_and_292_should_return_West() {
        with(appContext){
            for (deg in 248..292) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.west))
            }
        }
    }

    @Test
    fun degree_between_293_and_337_should_return_NorthWest() {
        with(appContext){
            for (deg in 293..337) {
                assertEquals(getDirectionsLabel(this, deg), getString(R.string.northwest))
            }
        }
    }
}