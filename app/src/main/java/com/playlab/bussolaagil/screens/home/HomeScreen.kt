package com.playlab.bussolaagil.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
    modifier: Modifier = Modifier,
    degrees: Int,
    isMagneticFieldSensorPresent: Boolean,
    onMenuClick: () -> Unit = {},
    compassComposable: @Composable () -> Unit
    ) {
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    modifier = Modifier.padding(16.dp)
                        .clickable {
                            onMenuClick()
                        },
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        }
    ) { padding ->
        Surface {
            Column(
                modifier = modifier.fillMaxSize().padding(padding),
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

                if (!isMagneticFieldSensorPresent) {
                    DialogAlert(
                        text = stringResource(R.string.missing_sensor_error)
                    )
                }
            }
        }
    }
}