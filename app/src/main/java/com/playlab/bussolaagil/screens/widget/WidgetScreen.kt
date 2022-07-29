package com.playlab.bussolaagil.screens.widget

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.playlab.bussolaagil.BuildConfig
import com.playlab.bussolaagil.R
import com.playlab.bussolaagil.components.MinimalCompass
import com.playlab.bussolaagil.components.StyledCompass
import com.playlab.bussolaagil.components.Widgets
import com.playlab.bussolaagil.data.preferences.PreferencesDataStore
import com.playlab.bussolaagil.screens.ScreenRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WidgetScreen(navController: NavController?) {
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface),
            ) {
                Icon(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController?.popBackStack()
                        },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    ) {
        Surface() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        state = rememberScrollState(),
                    ),
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
                    MinimalCompass()
                }

                Spacer(Modifier.padding(5.dp))

                CompassWidget(
                    name = Widgets.StyledCompass.name,
                    navController = navController,
                ) {
                    StyledCompass(size = 250.dp)
                }
                
                Spacer(Modifier.padding(top = 50.dp, end = 4.dp))

                val context = LocalContext.current

                Text(
                    modifier = Modifier
                        .clickable {
                            val appPackageName = BuildConfig.APPLICATION_ID
                            val playstoreIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=${appPackageName}"))
                            val browserIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=${appPackageName}"))

                            try {
                                context.startActivity(playstoreIntent)
                            }catch (e: ActivityNotFoundException){
                                context.startActivity(browserIntent)
                            }
                        }
                        .fillMaxWidth(0.5f)
                        .clip(RoundedCornerShape(3.dp))
                        .background(MaterialTheme.colors.primary.copy(0.1f))
                        .padding(top = 5.dp, bottom = 5.dp),
                    text = stringResource(R.string.rate),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSurface.copy(0.7f)
                )
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
                navController?.popBackStack()
            }
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