package com.playlab.bussolaagil.screens.home

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import com.playlab.bussolaagil.DefaultNavHost
import com.playlab.bussolaagil.R
import com.playlab.bussolaagil.ui.theme.BussolaAgilTheme
import org.junit.Rule
import org.junit.Test

class TestHomeScreen {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Test
    fun showErrorMessageDialog_whenMagneticSensorFieldIsNotPresent(){

        composeTestRule.setContent {
            BussolaAgilTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())

                HomeScreen(
                    degrees = 0,
                    isMagneticFieldSensorPresent = false,
                    navController = navController) {}
            }
        }

        val expectedText = appContext.getString(R.string.missing_sensor_error)

        composeTestRule.onNode(hasText(expectedText)).assertExists()
    }

    @Test
    fun clickOptionsMenu_navigateToWidgetScreen(){

        composeTestRule.setContent {
            BussolaAgilTheme (){
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())

               DefaultNavHost(degrees = 0, isMagneticFieldSensorPresent = true)

            }
        }

        composeTestRule.onNodeWithContentDescription("Menu").performClick()
        composeTestRule.onNodeWithContentDescription("Back").assertExists()
    }
}