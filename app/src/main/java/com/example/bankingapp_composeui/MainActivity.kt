package com.example.bankingapp_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingapp_composeui.ui.theme.BankingApp_ComposeUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingApp_ComposeUITheme {

           ChangeStausBarColor(color = Color.Black)
                Column(modifier =Modifier.fillMaxSize()) {
                    TopSection()
                }
            }
        }
    }
}


@Composable
fun ChangeStausBarColor(color: Color){

    val systemUiController= rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}
