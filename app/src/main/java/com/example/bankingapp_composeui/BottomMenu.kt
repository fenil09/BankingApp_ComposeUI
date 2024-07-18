package com.example.bankingapp_composeui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationMenu(){
    var selectedicon by rememberSaveable{
        mutableStateOf(0)
    }

    val bottomitem = listOf(
        BottomNavigationItems(
            title = "Home",
            selectedicon = Icons.Filled.Home,
            unselectedicon = Icons.Outlined.Home
        ),
        BottomNavigationItems(
            title = "Account",
            selectedicon = Icons.Filled.AccountBox,
            unselectedicon = Icons.Outlined.AccountBox
        ),
        BottomNavigationItems(
            title = "pay",
            selectedicon = Icons.Filled.Bed,
            unselectedicon = Icons.Outlined.Bed
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

        }
    }
    }




