package com.example.bankingapp_composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CreditCardSection(card:CardData){

    var ishidden by remember { mutableStateOf(true) }
    val displaynumber= if(ishidden){
        card.cardnumber.dropLast(4) + "****"
    }
    else{
        card.cardnumber
    }

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ){

        Box(modifier = Modifier.background(
            brush = Brush.horizontalGradient(
                colors = listOf(card.startcolor,card.endColor),
            )
        ).padding(16.dp)){

             Column {
                 Text(
                     text=card.cardtype,
                     fontWeight = FontWeight.Bold,
                     fontSize = 15.sp,
                     color = Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(
                     text = displaynumber,
                     fontWeight = FontWeight.SemiBold,
                     fontSize = 15.sp,
                     color = Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text(
                     text = card.cardholdername,
                     fontWeight = FontWeight.Bold,
                     fontSize = 15.sp,
                     color=Color.White
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                     Text(
                         text = card.expirationDate,
                         fontWeight = FontWeight.SemiBold,
                         fontSize = 15.sp,
                         color = Color.White
                     )
                     Spacer(modifier = Modifier.width(50.dp))
                     Image(
                         painter= painterResource(card.cardimage),
                         contentDescription = null,
                         modifier = Modifier.size(40.dp)
                     )
                     Spacer(modifier = Modifier.width(30.dp))
                     Icon(
                         painter = painterResource(R.drawable.baseline_remove_red_eye_24),
                         tint = Color.Black,
                         contentDescription =  null,
                         modifier = Modifier.size(30.dp)
                             .padding(top=6.dp)
                             .clickable { ishidden=!ishidden }
                     )
                 }

             }
        }
    }


}


@Composable
fun CreditCardListInvocation(cards:List<CardData>){
    LazyRow {
        items(cards.size){
            CreditCardSection(card = cards[it])
        }
    }
}

