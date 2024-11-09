package com.example.ultramenapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ultramenapp.data.dummyData

@Composable
fun ultraDetail(
    ultramenId: Int,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val ultramen = dummyData.ultramenList.find { it.id == ultramenId }

    Column(
        modifier = Modifier.padding(start = 10.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentWidth()
                .clickable { navController.popBackStack() }
        ) {
            IconButton(
                onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_revert),
                    contentDescription = "Back"
                )
            }
            Text("Back to Ultra List ", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(20.dp))
        }
        ultramen?.let {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                ) {
                    Image(
                        painter = painterResource(id = it.logo),
                        contentDescription = it.ultraName,
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = it.ultraName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Ultraman ${it.ultraName}",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                Image(
                    painter = painterResource(it.fullBody),
                    contentDescription = it.ultraName,
                    modifier = Modifier.fillMaxSize()
                )
            }
        } ?: run {
            Text(
                text = "Ultraman not found",
                fontSize = 16.sp,
                color = Color.Red
            )
        }
    }
}