package com.example.ultramenapp.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ultramenapp.component.villainGrid
import com.example.ultramenapp.data.dummyData
import com.example.ultramenapp.model.villain

@Composable
fun villScreen(
    modifier: Modifier = Modifier,
    villain: List<villain> = dummyData.villainList
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp),
        verticalItemSpacing = 2.dp,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(villain, key = { it.id }) {
            villainGrid(villain = it)
        }
    }
}

@Preview
@Composable
private fun prevvillain() {
    villScreen()
}