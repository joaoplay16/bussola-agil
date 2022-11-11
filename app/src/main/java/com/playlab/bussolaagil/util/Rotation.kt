package com.playlab.bussolaagil.util

fun getRotation(degrees: Int, lastRotation: Int): Int {
    var newRotation = lastRotation // newRotation will be updated in proper way
    // last rotation converted to range [-359; 359]
    val modLast = if (lastRotation > 0) lastRotation % 360 else 360 - (-lastRotation % 360)

    // if modLast isn't equal rotation retrieved as function argument
    // it means that newRotation has to be updated

    if (modLast != degrees) {
        // distance in degrees between modLast and rotation going backward
        val backward = if (degrees > modLast) modLast + 360 - degrees else modLast - degrees
        // distance in degrees between modLast and rotation going forward
        val forward = if (degrees > modLast) degrees - modLast else 360 - modLast + degrees

        // update newRotation so it will change rotation in the shortest way
        newRotation = if (backward < forward) {

            // backward rotation is shorter
            lastRotation - backward
        } else {

            // forward rotation is shorter (or they are equal)
            lastRotation + forward
        }
    }
    return newRotation
}