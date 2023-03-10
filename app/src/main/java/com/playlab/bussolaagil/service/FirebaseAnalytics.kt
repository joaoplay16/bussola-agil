package com.playlab.bussolaagil.service

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.ParametersBuilder
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

object FirebaseAnalytics {

    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun getInstance(): FirebaseAnalytics {
        if (firebaseAnalytics == null) {
            firebaseAnalytics = Firebase.analytics
        }
        return firebaseAnalytics!!
    }

    fun logAnalyticsEvent(eventName: String, pb: ParametersBuilder.() -> Unit) {
        getInstance().logEvent(eventName, pb)
    }
}