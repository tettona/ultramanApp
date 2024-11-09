package com.example.ultramenapp.Screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ultramenapp.component.ultramanColumn

import com.example.ultramenapp.component.ultramanRow
import com.example.ultramenapp.data.dummyData
import com.example.ultramenapp.model.ultramen

@Composable
fun ultraHome(
    navController: NavController,
    modifier: Modifier = Modifier,
    ultramens: List<ultramen> = dummyData.ultramenList

) {
    LazyColumn {
        item {
            LazyRow { items( ultramens, key = { it.id} ){
                ultramanRow(ultramen = it) { }
            } }

        }
    items(ultramens, key = { it.id}){
        ultramanColumn(ultramen = it){ultramenId ->
            navController.navigate("ultraDetail/$ultramenId")}
    }}
}