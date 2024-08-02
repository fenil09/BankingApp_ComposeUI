package com.example.bankingapp_composeui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun BottomNavigationMenu(){
    var selectedicon by rememberSaveable{
        mutableStateOf(0)
    }
    val controllernav= rememberNavController()

    val bottomitem = listOf(
        BottomNavigationItems(
            title = "Home",
            selectedicon = Icons.Filled.Home,
            unselectedicon = Icons.Outlined.Home,
            route = Screen.Home.route
        ),
        BottomNavigationItems(
            title = "Account",
            selectedicon = Icons.Filled.AccountBox,
            unselectedicon = Icons.Outlined.AccountBox,
            route = Screen.Account.route
        ),
        BottomNavigationItems(
            title = "pay",
            selectedicon = Icons.Filled.Bed,
            unselectedicon = Icons.Outlined.Bed,
            route = Screen.pay.route
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomitem.forEachIndexed { index, bottomNavigationItems ->
                        NavigationBarItem(
                            selected =selectedicon==index,
                            onClick = {
                                selectedicon = index
                                controllernav.navigate(bottomNavigationItems.route){
                                    popUpTo(controllernav.graph.startDestinationId){
                                        saveState= true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if(index==selectedicon){
                                        bottomNavigationItems.selectedicon
                                    }
                                    else{
                                        bottomNavigationItems.unselectedicon
                                    },
                                    contentDescription = bottomNavigationItems.title
                                )
                            },
                            label = {
                                Text(text=bottomNavigationItems.title)
                            }
                        )
                    }
                }
            }
        ){
            NavHost(
                navController = controllernav,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(it)
            ){
                composable(Screen.Home.route){ newhomescreen() }
                composable(Screen.Account.route){ AccountScreen() }
                composable(Screen.pay.route){ PayScreen() }
            }
        }
    }
    }




