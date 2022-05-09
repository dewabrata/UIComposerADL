package com.adl.uicomposeradl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adl.uicomposeradl.ui.theme.UIComposerADLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier
                    .background(Color.Red).weight(1f,true).fillMaxSize(),

                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    Greeting(name = "ADL")
                    Informasi()
                }
                Column(modifier = Modifier.background(Color.Green).weight(3f,true).border(5.dp,
                    Color.Yellow).padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround) {
                    Greeting(name = "ADL")
                    Informasi()
                }
            }




        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello ADL!")
}

@Composable
fun Informasi(){
    Text(text = "Selamat datang di Tutorial Jetpack", modifier = Modifier.background(Color.White))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UIComposerADLTheme {
        Greeting("Android")
    }
}