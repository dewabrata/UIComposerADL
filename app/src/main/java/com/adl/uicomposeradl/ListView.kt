package com.adl.uicomposeradl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adl.uicomposeradl.Items.CustomItem
import com.adl.uicomposeradl.ui.theme.Teal200
import com.adl.uicomposeradl.ui.theme.UIComposerADLTheme

class ListView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val allData = BiodataRepository().getAllData()
       
        super.onCreate(savedInstanceState)
        setContent {
            UIComposerADLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = { TopAppBar(title = {Text("LiveModel")},backgroundColor = Teal200)  }) {
                        LazyColumn(contentPadding = PaddingValues(12.dp)){
                            items(items=allData){
                                data -> CustomItem(model = data)
                            }
                        }
                    }
                }
            }
        }
    }
}


