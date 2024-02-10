package com.example.quizz

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizz.ui.theme.ErrorResponseStep
import com.example.quizz.ui.theme.QuestionScreen
import com.example.quizz.ui.theme.QuestionStep
import com.example.quizz.ui.theme.QuizzStep
import com.example.quizz.ui.theme.ValidResponseStep

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ChoiceQuizz.itineraire){
        composable(route = Screen.ChoiceQuizz.itineraire){
            QuizzStep(navController = navController)
        }
        composable(
            route = Screen.QuestionScreen.itineraire + "/{numQuizz}",
            arguments = listOf(
                navArgument("numQuizz"){
                    type = NavType.StringType
                }
            )
        ){
            QuestionStep(numQuizz = it.arguments?.getString("numQuizz")!!, navController = navController)
        }
        composable(
            route = Screen.ValidResponse.itineraire + "/{numQuizz}/{imageId}/{imageAlt}",
            arguments = listOf(
                navArgument("numQuizz"){
                    type = NavType.StringType
                },
                navArgument("imageId"){
                    type = NavType.IntType
                },
                navArgument("imageAlt"){
                    type = NavType.StringType
                }
            )
        ){
            ValidResponseStep(numQuizz = it.arguments?.getString("numQuizz")!!, imageId = it.arguments?.getInt("imageId")!!, imageAlt = it.arguments?.getString("imageAlt")!!, navController = navController)
        }
        composable(
            route = Screen.ErrorResponse.itineraire + "/{numQuizz}/{imageId}/{imageAlt}",
            arguments = listOf(
                navArgument("numQuizz"){
                    type = NavType.StringType
                },
                navArgument("imageId"){
                    type = NavType.IntType
                },
                navArgument("imageAlt"){
                    type = NavType.StringType
                }
            )
        ){
            ErrorResponseStep(numQuizz = it.arguments?.getString("numQuizz")!!, imageId = it.arguments?.getInt("imageId")!!, imageAlt = it.arguments?.getString("imageAlt")!!, navController = navController)
        }
    }
}