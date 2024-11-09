package com.example.ultramenapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ultramenapp.R
import com.example.ultramenapp.model.ultramen

@Composable
fun ultramanColumn(
    ultramen: ultramen,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(ultramen.id) }
    ) {
        Image(
            painter = painterResource(id = ultramen.logo),
            contentDescription = ultramen.ultraName,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(20.dp)

        )
        Column {
            Text(
                text = ultramen.ultraName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "touch to detail",
                fontSize = 12.sp, color = Color.Gray
            )
        }

    }
}

@Preview
@Composable
private fun preultramanColumn() {
    ultramanColumn(
        ultramen = ultramen(
            2,
            "Mebius",
            R.drawable.zero,
            R.drawable.zerologo,
            R.drawable.zerofull
        ), onItemClicked = { ultramenId -> println("Mentor Id : $ultramenId") }
    )
}