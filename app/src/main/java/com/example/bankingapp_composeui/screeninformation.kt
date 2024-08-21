package com.example.bankingapp_composeui

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.SimCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.InInspectionModeOnly
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun newhomescreen(){
    Box(modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()){
            TopSection()
            Spacer(modifier = Modifier.height(15.dp))
            CreditCardListInvocation(cards = CardObject.cards)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Finances", fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 5.dp))
            Spacer(modifier = Modifier.height(17.dp))
            FinanceSectionInvocation(financedata = FInanceObject.financedata)
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun AccountScreen() {
    var cardnumber by remember{ mutableStateOf("Card Number") }
    var cardholdername by remember { mutableStateOf("HolderName") }
    var cvv by remember { mutableStateOf("cvv") }
    var cardtype by remember{ mutableStateOf("CardType") }
    Box(modifier=Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize().imePadding() .padding(top = 25.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
        ){
                Card(
                    modifier = Modifier.width(350.dp)
                        .height(250.dp)
                        .background(Color.Blue),
                    shape = RoundedCornerShape(8.dp)
                ) {
                     Column(modifier = Modifier.fillMaxSize().background(
                         when(cardtype){
                             "visa" -> Color.Blue
                             "americanexpress" -> Color.Black
                             "mastercard" -> Color.Green
                             "Discover" -> Color.Cyan
                             else -> Color.Magenta
                         }
                     ).clip(RoundedCornerShape(12.dp))
                     ){
                         Row(
                             modifier = Modifier.fillMaxWidth()
                                 .padding(16.dp),
                             horizontalArrangement = Arrangement.SpaceBetween,
                             verticalAlignment = Alignment.CenterVertically
                         ) {
                             Icon(
                                 imageVector = Icons.Default.CreditCard,
                                 contentDescription = "Chip",
                                 tint = Color.White,
                                 modifier = Modifier.size(25.dp)

                             )
                             Text(
                                 text = cardtype,
                                 color = Color.White,
                                 fontSize = 25.sp,
                                 fontStyle = FontStyle.Italic
                             )
                         }
                         Spacer(modifier = Modifier.height(60.dp))
                         Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                             Text(text = cardnumber, fontSize = 18.sp, color = Color.White, fontStyle = FontStyle.Italic)
                         }
                         Spacer(modifier = Modifier.height(25.dp))
                         Row(
                             modifier = Modifier.fillMaxWidth()
                                 .padding(16.dp),
                             horizontalArrangement = Arrangement.SpaceBetween,
                             verticalAlignment = Alignment.CenterVertically
                         ) {
                             Text(
                                 text = cardholdername,
                                 color = Color.White,
                                 fontSize = 18.sp,
                                 fontStyle = FontStyle.Italic
                             )
                             Text(
                                 text = cvv,
                                 color = Color.White,
                                 fontSize = 25.sp,
                                 fontStyle = FontStyle.Italic
                             )
                         }

                     }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column (modifier = Modifier.fillMaxSize().imePadding(),horizontalAlignment = Alignment.CenterHorizontally){
                val viewrequester1= remember{ BringIntoViewRequester() }
                val viewRequester2= remember { BringIntoViewRequester() }
                val coroutinescope = rememberCoroutineScope()
                OutlinedTextField(value=cardnumber, onValueChange = { cardnumber= it}, label = {
                    Text(text="Enter your card number", fontSize = 14.sp, color = Color.Black, fontStyle = FontStyle.Italic,

                    )
                },  leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(12.dp)

                    )
                },modifier = Modifier.weight(1f).padding(8.dp))
                Spacer(modifier = Modifier.height(25.dp))
                OutlinedTextField(value=cardholdername, onValueChange = { cardholdername= it}, label = {
                    Text(text="Cardholder Name", fontSize = 14.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                },  leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(12.dp)
                    )
                },modifier = Modifier.weight(1f).padding(8.dp))
                Spacer(modifier = Modifier.height(25.dp))
                OutlinedTextField(value=cvv, onValueChange = { cvv= it
                coroutinescope.launch {
                    viewrequester1.bringIntoView()
                } }, label = {
                    Text(text="Enter your card number", fontSize = 14.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                },  leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(12.dp)
                    )
                },modifier = Modifier.weight(1f).padding(8.dp).bringIntoViewRequester(viewrequester1))
                Spacer(modifier = Modifier.height(25.dp))
                OutlinedTextField(value=cardtype, onValueChange = { cardtype= it
                    coroutinescope.launch {
                        viewRequester2.bringIntoView()
                    } }, label = {
                    Text(text="Enter your card number", fontSize = 14.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                },  leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CreditCard,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(12.dp)
                    )
                },modifier = Modifier.weight(1f).padding(8.dp).bringIntoViewRequester(viewRequester2))
            }

        }
    }
}

@Composable
fun PayScreen(){
    Box(modifier=Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val cards = remember {
                mutableListOf(
                    card(
                        "Visa",
                        Color.Black
                    ),
                    card(
                        "MasterCard",
                        Color.Red
                    )
                )
            }
            CardStack(cards)
        }
    }
}