package com.adl.uicomposeradl

import android.view.Display
import com.adl.uicomposeradl.model.ModelData

class BiodataRepository {

    fun getAllData(): List<ModelData> {
        return listOf(

            ModelData(id = 0, firstName = "Joko", lastName = "Pranoto", age = 21),
            ModelData(id = 1, firstName = "Dodo", lastName = "Angkoso", age = 22),
            ModelData(id = 2, firstName = "Dewi", lastName = "Anggini", age = 23),
            ModelData(id = 3, firstName = "Dewa", lastName = "Brata", age = 24),
            ModelData(id = 4, firstName = "Joko", lastName = "Pranoto", age = 21),
            ModelData(id = 5, firstName = "Dodo", lastName = "Angkoso", age = 22),
            ModelData(id = 6, firstName = "Dewi", lastName = "Anggini", age = 23),
            ModelData(id = 7, firstName = "Dewa", lastName = "Brata", age = 24),
        )
    }
}