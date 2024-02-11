package com.example.quizz

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import com.example.quizz.ui.theme.ManyTheme
import com.example.quizz.ui.theme.TopBarTitle
import com.example.quizz.ui.theme.QuestionScreen
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.*
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
class ComposableTests {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testTopBarTitle() {
        var numQuizz = 0

        composeTestRule.setContent {
            TopBarTitle(numQuizz = numQuizz)
        }

        composeTestRule.onNodeWithText("QCM").assertExists()

    }

    @Test
    fun testTopBarTitle1() {
        var numQuizz = 1

        composeTestRule.setContent {
            TopBarTitle(numQuizz = numQuizz)
        }

        composeTestRule.onNodeWithText("QCM sur Solo leveling").assertExists()

    }

    @Test
    fun testTopBarTitle2() {
        var numQuizz = 2

        composeTestRule.setContent {
            TopBarTitle(numQuizz = numQuizz)
        }

        composeTestRule.onNodeWithText("QCM sur Tokyo revengers").assertExists()

    }

    @Test
    fun testTopBarTitle3() {
        var numQuizz = 3

        composeTestRule.setContent {
            TopBarTitle(numQuizz = numQuizz)
        }

        composeTestRule.onNodeWithText("QCM sur SNK").assertExists()

    }


    @Test
    fun testAfficheThemes() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            ManyTheme(navController = navController)
        }

        composeTestRule.onNodeWithText("Solo leveling").assertExists()
        composeTestRule.onNodeWithText("Tokyo revengers").assertExists()
        composeTestRule.onNodeWithText("Attack on titan").assertExists()
    }

    @Test
    fun testAfficheQuestionTheme1() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            QuestionScreen(numQuizz = 1, navController = navController)
        }

        // Vérifier que le titre est présent
        composeTestRule.onNodeWithText("Quel est le personnage principal ?").assertExists()

        composeTestRule.onNodeWithText("Baek Yoonho").assertExists()
        composeTestRule.onNodeWithText("Chahae In").assertExists()
        composeTestRule.onNodeWithText("Sung Jinwoo").assertExists()
        composeTestRule.onNodeWithText("Choi Jongin").assertExists()

        //composeTestRule.onNodeWithTag("myTextTag", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage1-Baek Yoonho", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage1-Chahae In", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage1-Sung Jinwoo", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage1-Choi Jongin", true).assertExists()
    }

    @Test
    fun testAfficheQuestionTheme2() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            QuestionScreen(numQuizz = 2, navController = navController)
        }

        // Vérifier que le titre est présent
        composeTestRule.onNodeWithText("De qui est amoureux Takemichi ?").assertExists()

        composeTestRule.onNodeWithText("Hanita Tashiba").assertExists()
        composeTestRule.onNodeWithText("Emma Sano").assertExists()
        composeTestRule.onNodeWithText("Yuzuha Shiba").assertExists()
        composeTestRule.onNodeWithText("Mickey Sano").assertExists()

        //composeTestRule.onNodeWithTag("myTextTag", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage2-Hanita Tashiba", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage2-Emma Sano", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage2-Yuzuha Shiba", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage2-Mickey Sano", true).assertExists()
    }


    @Test
    fun testAfficheQuestionTheme3() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val navController = NavController(context)

        composeTestRule.setContent {
            QuestionScreen(numQuizz = 3, navController = navController)
        }

        // Vérifier que le titre est présent
        composeTestRule.onNodeWithText("Qui possède le titan originel ?").assertExists()

        composeTestRule.onNodeWithText("Armin Arlet").assertExists()
        composeTestRule.onNodeWithText("Annie Leonhart").assertExists()
        composeTestRule.onNodeWithText("Livai Ackerman").assertExists()
        composeTestRule.onNodeWithText("Eren Jager").assertExists()

        //composeTestRule.onNodeWithTag("myTextTag", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage3-Armin Arlet", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage3-Annie Leonhart", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage3-Livai Ackerman", true).assertExists()
        composeTestRule.onNodeWithTag("ChoiceImage3-Eren Jager", true).assertExists()
    }


    //@Test
    //fun testClickValidResponseNavigation() {
        //val context = ApplicationProvider.getApplicationContext<Context>()
        //val navController2 = TestNavHostController(context)

        //composeTestRule.setContent {
            //QuestionScreen(numQuizz = 1, navController = navController2)
        //}

        //composeTestRule.onNodeWithTag("Sung Jinwoo", true).performClick()

        //assert(navController2.currentDestination?.route == Screen.ValidResponse.itineraire)
    //}










    //@Test
    //fun testManyTheme() {
    //    composeTestRule.setContent {
    //        val navController = rememberNavController()
    //        ManyTheme(navController = navController)
    //    }
    //    composeTestRule.onNodeWithText("Theme 1").assertExists()
    //    composeTestRule.onNodeWithText("Theme 2").assertExists()
    //    composeTestRule.onNodeWithText("Theme 3").assertExists()
    //}

    //@Test
    //fun testQuizzStep() {
    //    composeTestRule.setContent {
    //        val navController = rememberNavController()
    //        QuizzStep(navController = navController)
    //    }
    //    composeTestRule.onNodeWithText("Title for Quiz 1").assertExists()
    //    composeTestRule.onNodeWithText("Theme 1").assertExists()
    //    composeTestRule.onNodeWithText("Theme 2").assertExists()
    //    composeTestRule.onNodeWithText("Theme 3").assertExists()
    //}
}