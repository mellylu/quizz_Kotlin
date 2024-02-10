package com.example.quizz.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizz.R
import com.example.quizz.Screen

@Composable
fun ErrorResponseScreen(modifier: Modifier = Modifier, numQuizz: Int = 1, imageId : Int = R.drawable.eren_jaeger, imageAlt : String = "0", navController: NavController){
    val question = when(numQuizz){
        1 -> R.string.question1
        2 -> R.string.question2
        3 -> R.string.question3
        else ->
            R.string.question1
    }

        Column (
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = stringResource(id = question),
                    textAlign = TextAlign.Center,
                )



            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(40.dp)
                    .height(0.dp)
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = imageAlt,
                    modifier = modifier
                        .width(600.dp)
                        .fillMaxHeight()
                        .align(Alignment.Center)
                )
            }
            Text(
                text= "Mauvaise réponse",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(50.dp)
                    .background(Color(0xFFFF0000))
                    .padding(10.dp)
                    .fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(100.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                onClick = { navController.navigate(Screen.QuestionScreen.itineraire + "/" + numQuizz.toString())},
                modifier = modifier
            ){
                Text(
                    text = "Recommencer le quizz",
                    color = Color.White,
                    modifier = modifier
                        .drawBehind {
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, size.height - 4.dp.toPx()),
                                end = Offset(size.width, size.height - 4.dp.toPx()),
                                strokeWidth = 2.dp.toPx()
                            )
                        }
                )
            }
        }


}

@Composable
fun ErrorResponseStep(modifier: Modifier = Modifier, numQuizz : String = "1", imageId : Int = R.drawable.eren_jaeger, imageAlt : String ="0", navController : NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ){

        TopBarTitle(numQuizz = numQuizz.toInt())
        ErrorResponseScreen(numQuizz = numQuizz.toInt(), imageId = imageId, imageAlt = imageAlt, navController = navController)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ErrorResponsePreview(){
    //ErrorResponseStep()
}