package com.example.crypto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.crypto.controller.BottomSetUpOnGraph
import com.example.crypto.controller.bottomItems
import com.example.crypto.ui.theme.Black
import com.example.crypto.ui.theme.Gray
import com.example.crypto.ui.theme.Pink
import com.example.crypto.ui.theme.Purple


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
//        topBar = {
//        TopAppBar(backgroundColor = Color.White, title = {
//            Column(horizontalAlignment = Alignment.Start) {
//                Text(
//                    "Hello Anna",
//                    textAlign = TextAlign.Start,
//                    fontSize = 24.sp,
//                    color = Pink,
//                )
//                Text(
//                    "Welcome Back!",
//                    textAlign = TextAlign.Start,
//                    fontSize = 32.sp,
//                    color = Black,
//                )
//            }
//        },
//            actions = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.Notifications,
//                        contentDescription = null,
//                        tint = Pink,
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(8.dp))
//                            .background(Color.LightGray)
//                            .size(44.dp),
//                    )
//                }
//            })
//    },
        bottomBar = {
            BottomNavigation(backgroundColor = Purple, contentColor = Pink) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.image),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                screen.label,
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        unselectedContentColor = Gray,


                        )
                }
            }
        }
    ) {
        BottomSetUpOnGraph(navHostController = navController)
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.shape),
                contentDescription = null,
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.Crop,
                modifier = Modifier.align(
                    Alignment.BottomCenter
                ).fillMaxWidth()
            )
            
        }
    }
}