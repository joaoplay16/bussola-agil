package com.playlab.bussolaagil

import com.playlab.bussolaagil.util.getDirectionsLabel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CompassDirectionsUnitTest {

    @Test
    fun `degree between 0 and 22 should return North`() {
        for (deg in 0..22){
            assertEquals(getDirectionsLabel(deg), "N")
        }
    }

    @Test
    fun `degree between 338 and 360 should return North`() {
        for (deg in 338..360) {
            assertEquals(getDirectionsLabel(deg), "N")
        }
    }

    @Test
    fun `degree between 23 and 67 should return Northeast`() {
        for (deg in 23..67) {
            assertEquals(getDirectionsLabel(deg), "NE")
        }
    }

    @Test
    fun `degree between 68 and 112 should return East`() {
        for (deg in 68..112) {
            assertEquals(getDirectionsLabel(deg), "L")
        }
    }

    @Test
    fun `degree between 113 and 157 should return Southeast`() {
        for (deg in 113..157) {
            assertEquals(getDirectionsLabel(deg), "SE")
        }
    }

    @Test
    fun `degree between 158 and 202 should return South`() {
        for (deg in 158..202) {
            assertEquals(getDirectionsLabel(deg), "S")
        }
    }

    @Test
    fun `degree between 203 and 247 should return Southwest`() {
        for (deg in 203..247) {
            assertEquals(getDirectionsLabel(deg), "SO")
        }
    }

    @Test
    fun `degree between 203 and 247 should return West`() {
        for (deg in 248..292) {
            assertEquals(getDirectionsLabel(deg), "O")
        }
    }

    @Test
    fun `degree between 293 and 337 should return West`() {
        for (deg in 293..337) {
            assertEquals(getDirectionsLabel(deg), "NO")
        }
    }
}