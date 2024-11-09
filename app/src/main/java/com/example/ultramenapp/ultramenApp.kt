package com.example.ultramenapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ultramenapp.Screen.profileScreen
import com.example.ultramenapp.Screen.ultraDetail
import com.example.ultramenapp.Screen.ultraHome
import com.example.ultramenapp.Screen.villScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ultramenApp(
    navController: NavHostController = rememberNavController()
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = when (currentDestination) {
                            "ultramenApp" -> "Ultraman"
                            "villainScreen" -> "Villains"
                            "ultraDetail/{ultramenId}" -> "Ultraman Detail"
                            else -> "Profile"
                        },
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
            )
        },
        bottomBar = { navBottomUltramen(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "ultramenApp"
                ) {
                    composable("ultramenApp") { ultraHome(navController) }
                    composable("villainScreen") { villScreen() }
                    composable("profileScreen") { profileScreen() }
                    composable(
                        "ultraDetail/{ultramenId}",
                        arguments = listOf(navArgument("ultramenId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val ultramenId = backStackEntry.arguments?.getInt("ultramenId") ?: 0
                        ultraDetail(ultramenId = ultramenId, navController = navController)
                    }
                }
            }
        }
    )
}

@Composable
fun navBottomUltramen(
    navController: NavHostController,
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            selected = currentDestination == "ultramenApp",
            onClick = {
                selectedItem = 0
                navController.navigate("ultramenApp") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            },
            label = { Text("Ultraman") },
            icon = {
                Image(
                    painter = painterResource(R.drawable.ultraicon),
                    contentDescription = ""
                )
            }
        )
        NavigationBarItem(
            selected = currentDestination == "villainScreen",
            onClick = {
                selectedItem = 1
                navController.navigate("villainScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            },
            label = { Text("Villain") },
            icon = {
                Image(
                    painter = painterResource(R.drawable.villainicon),
                    contentDescription = ""
                )
            }
        )
        NavigationBarItem(
            selected = currentDestination == "profileScreen",
            onClick = {
                selectedItem = 2
                navController.navigate("profileScreen") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            },
            label = { Text("Profile") },
            icon = {  Image(
                painter = painterResource(R.drawable.profileicon),
                contentDescription = ""
            ) }
        )
    }
}
