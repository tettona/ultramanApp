package com.example.ultramenapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ultramenapp.R
import com.example.ultramenapp.model.villain

@Composable
fun villainGrid(
    modifier: Modifier = Modifier,
    villain: villain
) {
    Column(
        modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = villain.photo),
            contentDescription = villain.villName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()

        )
    }
}

@Preview
@Composable
private fun previllainGrid() {
    villainGrid(villain = villain(1, "Dark Zagi", R.drawable.darkzagi, ""))
}