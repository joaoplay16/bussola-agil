package com.playlab.bussolaagil.util.util

import com.google.common.truth.Truth.assertThat
import com.playlab.bussolaagil.util.getRotation
import org.junit.Test

class TestRotation {

    @Test
    fun `given non-zero degree, returns non-zero value` (){

        var lastRotation = 0

        lastRotation = getRotation(degrees = 180, lastRotation = lastRotation)

        assertThat(lastRotation != 0).isTrue()
    }

    @Test
    fun `when there is no rotation, returns unmodified rotation` (){

        var lastRotation = 0

        lastRotation = getRotation(degrees = 0, lastRotation = lastRotation)

        assertThat(lastRotation).isEqualTo(0)
    }
}