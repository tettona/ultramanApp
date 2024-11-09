package com.example.ultramenapp.Screen

import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ultramenapp.R

@Composable
fun profileScreen(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(25.dp),
        color = Color.White,
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(213, 198, 255))
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 70.dp, start = 40.dp, end = 40.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(55.dp))
            Box { // Lingkaran biru tua (border luar)
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .background(Color(0xFF001F5B), CircleShape) // Sesuaikan warna biru tua
                )
                // Lingkaran kuning (border dalam)
                Box(
                    modifier = Modifier
                        .size(125.dp) // Sedikit lebih kecil dari lingkaran luar
                        .background(Color(0xFFFFD700), CircleShape) // Sesuaikan warna kuning
                )
                Image(
                    painter = painterResource(R.drawable.sigmamale),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color(38, 35, 92), CircleShape)
                        .size(120.dp)
                )
            }
            Spacer(Modifier.height(15.dp))
            Text(
                text = "Seto Cahyadin",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                color = Color.Gray,
                text = "Mobile Developer",
                fontSize = 14.sp
            )
            Spacer(Modifier.height(20.dp))
            Text(
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                text = "Jurusan Teknik Informatika \n" +
                        " Prodi Teknologi Rekayasa Perangkat Lunak \n" +
                        " Politeknik Negeri Batam"
            )
            Spacer(Modifier.height(20.dp))
            Surface(
                color = Color(38, 35, 92),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    fontSize = 14.sp,
                    color = Color.White,
                    text = "seto.cahyadin2003@gmail.com",
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 10.dp,
                        bottom = 10.dp,
                        end = 20.dp
                    )
                )
            }
            Spacer(Modifier.height(5.dp))
            Image(
                painter = painterResource(R.drawable.sosmedicon),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(15.dp)
            )
        }
    }

}


@Preview
@Composable
private fun preprofilescreen() {
    profileScreen()
}