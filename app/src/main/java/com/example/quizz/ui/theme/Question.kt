package com.example.quizz.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizz.R
import com.example.quizz.Screen


@Composable
fun QuestionScreen(
   modifier: Modifier = Modifier,
   numQuizz: Int,
   navController: NavController
) {
    val choix1 = when(numQuizz){
        1 -> R.drawable.baekyoonho
        2 -> R.drawable.hanitatachibana
        3 -> R.drawable.armin_arlelt
        else ->
            R.drawable.baekyoonho
    }
    val choix2 = when(numQuizz){
        1 -> R.drawable.chahaein
        2 -> R.drawable.emmasano
        3 -> R.drawable.annie_leonhart
        else ->
            R.drawable.chahaein
    }

    val choix3 = when(numQuizz){
        1 -> R.drawable.sung_jin_woo
        2 -> R.drawable.yuzuhashiba
        3 -> R.drawable.livai_ackerman
        else ->
            R.drawable.sung_jin_woo
    }
    val choix4 = when(numQuizz){
        1 -> R.drawable.choijongin
        2 -> R.drawable.mickeysano
        3 -> R.drawable.eren_jaeger
        else ->
            R.drawable.choijongin
    }

    val question = when(numQuizz){
        1 -> R.string.question1
        2 -> R.string.question2
        3 -> R.string.question3
        else ->
            R.string.question1
    }

    val nomChoix1 = when(numQuizz){
        1 -> R.string.description1image1
        2 -> R.string.description2image1
        3 -> R.string.description3image1
        else ->
            R.string.description1image1
    }

    val nomChoix2 = when(numQuizz){
        1 -> R.string.description1image2
        2 -> R.string.description2image2
        3 -> R.string.description3image2
        else ->
            R.string.description1image2
    }

    val nomChoix3 = when(numQuizz){
        1 -> R.string.description1image3
        2 -> R.string.description2image3
        3 -> R.string.description3image3
        else ->
            R.string.description1image3
    }

    val nomChoix4 = when(numQuizz){
        1 -> R.string.description1image4
        2 -> R.string.description2image4
        3 -> R.string.description3image4
        else ->
            R.string.description1image4
    }


    Column (
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,

    ){

        Text(
            text = stringResource(id = question),
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = modifier
                .height(150.dp),
            //horizontalArrangement = Arrangement.spacedBy(8.dp),

        )
        {
            OptionStep(modifier.fillMaxSize().weight(1f), numQuizz, choix1, nomChoix1, navController)
            OptionStep(modifier.fillMaxSize().weight(1f), numQuizz, choix2, nomChoix2, navController)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = modifier.height(150.dp),
        ) {
            OptionStep(modifier.fillMaxSize().weight(1f), numQuizz, choix3, nomChoix3, navController)
            OptionStep(modifier.fillMaxSize().weight(1f), numQuizz, choix4, nomChoix4, navController)
        }
        Spacer(modifier = Modifier.height(100.dp))
    }

}


@Composable
fun OptionStep(modifier : Modifier = Modifier, numQuizz : Int = 1, choix : Int = 1, nomChoix : Int = 1, navController: NavController){
    val response = stringResource(id = nomChoix)
    val response1 = stringResource(id = R.string.response1)
    val response2 = stringResource(id = R.string.response2)
    val response3 = stringResource(id = R.string.response3)
    Button(
        shape = RoundedCornerShape(1.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = { if (numQuizz == 1 && response == response1 || numQuizz == 2 && response == response2 || numQuizz == 3 && response == response3) navController.navigate(Screen.ValidResponse.itineraire + "/" + numQuizz.toString()+ "/" + choix + "/" + nomChoix) else navController.navigate(Screen.ErrorResponse.itineraire + "/" + numQuizz.toString() + "/" + choix + "/" + nomChoix)},
        modifier = modifier
            .testTag("$response")
    )
    {
        Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .weight(1f)
    ){
        Image(
            painter = painterResource(id = choix),
            contentDescription = stringResource(id = nomChoix),

            modifier = modifier.fillMaxSize()
                .weight(1f)
                .testTag("ChoiceImage$numQuizz-$response")

        )
        Text(text = stringResource(id = nomChoix), color = Color.Black)

    }

    }
}


@Composable
fun QuestionStep(modifier: Modifier = Modifier, numQuizz : String = "0", navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ){

        TopBarTitle(numQuizz = numQuizz.toInt())
        QuestionScreen(numQuizz = numQuizz.toInt(), navController = navController)
    }
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun QuestionPreview(){
    //QuestionStep()
}
