package com.playlab.bussolaagil.screens.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.playlab.bussolaagil.CompassAnimation
import com.playlab.bussolaagil.CompassAnimationStyled
import com.playlab.bussolaagil.components.Widgets
import com.playlab.bussolaagil.data.preferences.PreferencesDataStore
import com.playlab.bussolaagil.screens.ScreenRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WidgetScreen(navController: NavController?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val dataStore = PreferencesDataStore(LocalContext.current)

        CompassWidget(
            name = Widgets.MinimalCompass.name,
            navController = navController,
            dataStore = dataStore
            ) {
            CompassAnimation()
        }

        CompassWidget(
            name = Widgets.StyledCompass.name,
            navController = navController,
            dataStore = dataStore
        ) {
            CompassAnimationStyled()
        }
    }
}

@Composable
fun CompassWidget(
    name: String,
    navController: NavController?,
    dataStore: PreferencesDataStore,
    composable: @Composable () -> Unit
) {
    Box (Modifier.clickable {
        CoroutineScope(Dispatchers.IO).launch{
            dataStore.saveWidgetName(name)
        }
        navController?.navigate(ScreenRoutes.Home.name)
    }){
        composable()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWidgetScreen() {
    WidgetScreen(null)
}