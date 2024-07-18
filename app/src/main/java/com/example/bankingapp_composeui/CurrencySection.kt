package com.example.bankingapp_composeui

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedapps.bankningappui.ui.theme.GreenStart


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CurrencySection(){

    var isvisible by remember{
        mutableStateOf(false)
    }
    var iconstate by remember{
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Box(modifier = Modifier.fillMaxSize().padding(bottom = 150.dp), contentAlignment = Alignment.BottomCenter){

        Column (
            modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)).background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ){
            Row(
              modifier = Modifier.padding(16.dp)
                  .fillMaxWidth()
                  .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(modifier = Modifier.clip(CircleShape).background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isvisible=!isvisible
                        if(isvisible){
                            iconstate=Icons.Rounded.KeyboardArrowUp
                        }
                        else{
                            iconstate=Icons.Rounded.KeyboardArrowDown
                        }
                    }
                ){

                    Icon(
                       imageVector =  iconstate,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )



                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Currencies", fontSize = 20.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
            Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(MaterialTheme.colorScheme.secondaryContainer))


            if(isvisible){
                BoxWithConstraints (
                    modifier = Modifier.fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ){
                    val boxwithconstraint=this
                    val width=boxwithconstraint.maxWidth/3
                    Column(modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Row (
                            modifier = Modifier.fillMaxWidth()
                        ){

                            Text(
                                text = "Currency",
                                fontSize = 16.sp,
                                modifier = Modifier.width(width),
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                text = "Buy",
                                fontSize = 16.sp,
                                modifier = Modifier.width(width),
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = "Sell",
                                fontSize = 16.sp,
                                modifier = Modifier.width(width),
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }

                     InvokeBoxContent(CurrencyOnject.currencydata)

                    }

                }

            }
        }
    }

}


@Composable
fun InBoxContent(currencyData: CurrencyData){

    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = currencyData.currencyicon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = GreenStart
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = currencyData.currencyname,
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(45.dp))

        Text(
            text = currencyData.buyamount,
            fontSize = 22.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(35.dp))
        Text(
            text = currencyData.sellamount,
            fontSize = 22.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
fun InvokeBoxContent(CurrencyObject:List<CurrencyData>){
    LazyColumn {
        items(CurrencyObject.size){
            InBoxContent(currencyData = CurrencyObject[it])
        }
    }
}