package com.adl.uicomposeradl.Items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adl.uicomposeradl.model.ModelData
import com.adl.uicomposeradl.ui.theme.Teal200


@Composable
fun CustomItem(model: ModelData){

    Card(modifier = Modifier.padding(15.dp), shape = RoundedCornerShape(15.dp), elevation = 5.dp) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Teal200)
        .padding(24.dp),
    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)){
        Text(text = model.firstName,
        color = Color.Black,
        fontWeight = FontWeight.Normal
        )
        Text(text = model.lastName,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Text(text = "${model.age}",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
    }
}
@Composable
@Preview
fun preview(){
    CustomItem(model = ModelData("","Dewa","12"))
}