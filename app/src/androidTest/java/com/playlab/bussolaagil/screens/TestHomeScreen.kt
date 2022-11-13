package com.playlab.bussolaagil.screens

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.playlab.bussolaagil.DefaultNavHost
import com.playlab.bussolaagil.ui.theme.BussolaAgilTheme
import org.junit.Rule
import org.junit.Test

class TestHomeScreen {

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

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