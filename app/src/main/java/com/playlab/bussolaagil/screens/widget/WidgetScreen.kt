package com.playlab.bussolaagil.screens.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.playlab.bussolaagil.CompassAnimation
import com.playlab.bussolaagil.CompassAnimationStyled
import com.playlab.bussolaagil.R
import com.playlab.bussolaagil.components.Widgets
import com.playlab.bussolaagil.data.preferences.PreferencesDataStore
import com.playlab.bussolaagil.screens.ScreenRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WidgetScreen(navController: NavController?) {
    Surface() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.widget),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSurface.copy(0.7f)
            )

            CompassWidget(
                name = Widgets.MinimalCompass.name,
                navController = navController,
            ) {
                CompassAnimation()
            }

            CompassWidget(
                name = Widgets.StyledCompass.name,
                navController = navController,
            ) {
                CompassAnimationStyled()
            }
        }
    }
}

@Composable
fun CompassWidget(
    name: String,
    navController: NavController?,
    composable: @Composable () -> Unit
) {
    val dataStore = PreferencesDataStore(LocalContext.current)
    Box (
        Modifier
            .clickable {
                CoroutineScope(Dispatchers.IO).launch {
                    dataStore.saveWidgetName(name)
                }
                navController?.navigate(ScreenRoutes.Home.name)
            }
            .padding(16.dp)
    ){
        composable()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWidgetScreen() {
    Surface() {
        WidgetScreen(null)
    }
}