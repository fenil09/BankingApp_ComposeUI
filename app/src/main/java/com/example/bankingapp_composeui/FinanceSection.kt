package com.example.bankingapp_composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FiananceSection(financedata:FInanceData){

    Card (
        modifier = Modifier.width(130.dp).height(130.dp)
            .padding(8.dp),
        RoundedCornerShape(10.dp)
    ){
        Box (modifier = Modifier.background(Color.Black).padding(16.dp).fillMaxSize()){
            Column {
                Icon(
                    imageVector = financedata.fiananceImage,
                    contentDescription = null,
                    tint = financedata.financecolor,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = financedata.financeType,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Composable
fun FinanceSectionInvocation(financedata:List<FInanceData>){
    LazyRow {
        items(financedata.size){
            FiananceSection(financedata = financedata[it])
        }
    }
}