package com.adl.uicomposeradl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.adl.uicomposeradl.ui.theme.UIComposerADLTheme

class ImageActivity : ComponentActivity() {

    private val data by viewModels<DataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier.fillMaxSize()) {
                Row() {
                    ImageCard(data=data,painterResource(id = R.drawable.android),
                        "Android Image","Ini gambar android")
                    ImageCard(data=data,painterResource(id = R.drawable.android),
                        "Android Image2","Ini gambar android2 text panjang")
                }
                
                Column() {
                    TextFieldInput(data = data,label = "Masukan Text :",isi = {data.onChangeValue(it)})
                }
            }
            

        }
    }
}

@Composable
fun ImageCard(data:DataViewModel,painter: Painter, contentDescription:String,
              title:String, modifier: Modifier=Modifier){
   //
    Card(modifier = modifier.padding(15.dp), shape = RoundedCornerShape(15.dp), elevation = 5.dp) {
        Box(modifier = Modifier
            .height(180.dp)
            .width(180.dp)){
            Image(painter = painter,
                 contentDescription = contentDescription,
                 contentScale = ContentScale.Crop )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.BottomStart){
                Text(data.isiText, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun TextFieldInput (data:DataViewModel, label:String ,isi : (String)->Unit){


    var isiDummy:String =""

    Column() {
        TextField(value = data.isiText ,label = {Text(label)}, onValueChange = isi )
        Text(text = data.isiText)
        Button(onClick = { data.isiText =" Ini button ditekan" },content= { Text(text=data.isiText) })
    }

}

class DataViewModel : ViewModel(){
    var isiText by mutableStateOf("")

    fun onChangeValue(newString:String){
        isiText = newString
    }

}