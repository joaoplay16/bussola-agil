package com.playlab.bussolaagil.screens.home

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.playlab.bussolaagil.R
import com.playlab.bussolaagil.components.DialogAlert
import com.playlab.bussolaagil.util.getDirectionsLabel

@Composable
fun HomeScreen(
    degrees: Int,
    sensorManager: SensorManager,
    compassComposable: @Composable () -> Unit
    ) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = getDirectionsLabel(LocalContext.current, degrees),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )

            compassComposable()

            if(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null) {
                DialogAlert(stringResource(R.string.missing_sensor_error))
            }
        }
    }
}