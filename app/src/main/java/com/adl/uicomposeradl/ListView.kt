package com.adl.uicomposeradl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adl.uicomposeradl.Items.CustomItem
import com.adl.uicomposeradl.model.ModelData
import com.adl.uicomposeradl.ui.theme.Teal200
import com.adl.uicomposeradl.ui.theme.UIComposerADLTheme
import kotlinx.coroutines.launch

class ListView : ComponentActivity() {
    private val data by viewModels<ViewModelData>()
    override fun onCreate(savedInstanceState: Bundle?) {


       
        super.onCreate(savedInstanceState)
        setContent {
            UIComposerADLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = { TopAppBar(title = {Text("LiveModel")},backgroundColor = Teal200)  }) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row() {
                                Column(modifier = Modifier.padding(12.dp)){
                                    TextField(label = { Text(text = "FirstName")}, value = data.firstNameText, onValueChange = {data.onChangeValueFirstName(it)})
                                    TextField(label = { Text(text = "LastName")},value = data.lastNameText, onValueChange = {data.onChangeValueLastName(it)})
                                    TextField(label = { Text(text = "Age")},value = data.ageText, onValueChange = {data.onChangeValueAge(it)})

                                }

                                Button(onClick = { data.addData(ModelData(data.firstNameText,"",data.ageText)) }, content = { Text(text = "Add")})


                            }
                            LazyColumn(contentPadding = PaddingValues(12.dp)){
                                items(items=data.allData){
                                        data -> CustomItem(model = data)
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}


class ViewModelData : ViewModel(){
    var allData = SnapshotStateList<ModelData>()
    var firstNameText by mutableStateOf("")
    var lastNameText by mutableStateOf("")
    var ageText by mutableStateOf("")
    init {
       // loadAllData()
    }

    fun onChangeValueFirstName(newString:String){
        firstNameText = newString
    }
    fun onChangeValueLastName(newString:String){
        lastNameText = newString
    }
    fun onChangeValueAge(newString:String){
        ageText = newString
    }

    fun loadAllData(){
        viewModelScope.launch {
            allData.clear()
            allData.addAll( BiodataRepository().getAllData())
        }
    }

    fun addData(data:ModelData){
        allData.add(data)
    }
}

