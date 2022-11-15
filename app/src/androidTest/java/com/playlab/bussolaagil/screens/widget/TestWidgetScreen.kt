package com.playlab.bussolaagil.screens.widget

import android.content.Context
import androidx.compose.ui.platform.LocalContext
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

class TestWidgetScreen {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val composeTestRule = createComposeRule()

    lateinit var navController: TestNavHostController

    @Test
    fun clickArrowBack_navigateToHomeScreen(){

        val widgetScreenArrowBackIconDescription = appContext.getString(R.string.back)
        val homeScreenMenuIconDescription = appContext.getString(R.string.menu)

        composeTestRule.setContent {
            BussolaAgilTheme (){
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())

               DefaultNavHost(
                   degrees = 0,
                   isMagneticFieldSensorPresent = true,
                   navController = navController
               )
            }
        }

        composeTestRule.onNodeWithContentDescription(homeScreenMenuIconDescription).performClick()
        composeTestRule.onNodeWithContentDescription(widgetScreenArrowBackIconDescription).assertExists()
        composeTestRule.onNodeWithContentDescription(widgetScreenArrowBackIconDescription).performClick()
        composeTestRule.onNodeWithContentDescription(homeScreenMenuIconDescription).assertExists()
    }
}