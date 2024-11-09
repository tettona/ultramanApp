package com.example.ultramenapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ultramenapp.R
import com.example.ultramenapp.model.ultramen

@Composable
fun ultramanRow(
    ultramen: ultramen,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = Modifier.clickable { onItemClicked(ultramen.id) },
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = ultramen.photo),
                contentDescription = ultramen.ultraName,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
                    .clip(CircleShape)
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = ultramen.ultraName,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                letterSpacing = 2.sp
            )
        }
    }
}

@Preview
@Composable
private fun prevultramanRow() {
    ultramanRow(
        ultramen = ultramen(1, "zero", R.drawable.zero, R.drawable.zerologo, R.drawable.zerofull),
        onItemClicked = { ultramenId -> println("Mentor Id : $ultramenId") })
}