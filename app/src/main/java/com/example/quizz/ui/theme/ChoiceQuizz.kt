package com.example.quizz.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizz.R
import com.example.quizz.Screen


@Composable
fun TopBarTitle(modifier: Modifier = Modifier, numQuizz : Int = 0) {
    val titre = when(numQuizz){
        1 -> R.string.titre1
        2 -> R.string.titre2
        3 -> R.string.titre3
        else ->
            R.string.titreDefault
    }
    Text(
        text = stringResource(id = titre),
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 15.dp)


    )
}

@Composable
fun ManyTheme(modifier: Modifier = Modifier, navController: NavController) {
    var step by remember { mutableIntStateOf(0) }
    val theme1 = stringResource(id = R.string.theme1)
    val theme2 = stringResource(id = R.string.theme2)
    val theme3 = stringResource(id = R.string.theme3)

    var listeTheme by remember { mutableStateOf(mutableMapOf(1 to theme1, 2 to theme2, 3 to theme3)) }
    val colorTheme : Map<Int, Long>  = mutableMapOf(1 to 0xFF1515AD, 2 to 0xFFF0F005, 3 to 0xFF3C9E03)
    when(step){
        1 -> listeTheme.remove(1)
        2 -> listeTheme.remove(2)
        3 -> listeTheme.remove(3)
        else -> listeTheme
    }

    Column(
        modifier = modifier.fillMaxSize()
            .padding(top = 150.dp, bottom = 250.dp, start = 50.dp, end = 50.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        listeTheme.forEach { (number, theme) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {

                Button(
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorTheme[number]?.toLong()?.let { Color(it) } ?: Color.Gray),
                    onClick = { navController.navigate(Screen.QuestionScreen.itineraire + "/" + number.toString()) },

                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                ){
                    Text(
                        text = listeTheme[number].toString(),
                        textAlign = TextAlign.Left,

                        modifier = modifier
                            .fillMaxWidth()
                            .background(colorTheme[number]?.toLong()?.let { Color(it) } ?: Color.Gray)

                            .padding(2.dp)
                            ,
                        color = Color.White,
                        fontSize = 20.sp
                    )

                }
                Button(
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    onClick = { listeTheme = listeTheme.filterNot { it.key == number }.toMutableMap() },//step = number
                    modifier = Modifier
                        .weight(0.25f)
                        .background(Color.White)
                ) {
                    Text(
                        text = "X",
                        fontSize = 32.sp,
                        color = Color.Black,
                        modifier = modifier.background(Color.White)
                    )
                }

            }
        }
    }

}

@Composable
fun QuizzStep(modifier: Modifier = Modifier, navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ){

        TopBarTitle()
        ManyTheme(navController = navController)
    }
}



//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun GreetingPreview() {
//    QuizzTheme {
//        QuizzStep()
//    }
//}