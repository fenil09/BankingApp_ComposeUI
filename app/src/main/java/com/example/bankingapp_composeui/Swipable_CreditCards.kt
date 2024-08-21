package com.example.bankingapp_composeui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.roundToInt


@Composable
fun SwipableCard(
    card:card,
    modifier: Modifier=Modifier,
    onswiped:()-> Unit
){
    var offsetx by remember{ mutableStateOf(0f) }
    val swipethreshold = 300f
    val animatedoffset by animateFloatAsState(
        targetValue = offsetx,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier=Modifier
            .offset { IntOffset(animatedoffset.roundToInt(), 0) }
            .background(card.backgroundcolor)
            .fillMaxWidth()
            .aspectRatio(1.6f)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .pointerInput(Unit){
                detectDragGestures { change, dragAmount ->
                    offsetx += dragAmount.x
                    if(offsetx > swipethreshold){
                        onswiped()
                        offsetx = 0f
                    }
                }
            }
    ){
        Text(
            text = card.nameofcard,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 24.sp
        )
    }


}

@Composable
fun CardStack(cards:List<card>){
    var cardlist by remember { mutableStateOf(cards) }
    Box(
        modifier = Modifier.width(300.dp)
            .height(400.dp),
        contentAlignment = Alignment.Center
    ){
        cardlist.asReversed().forEachIndexed{index ,card ->
            if(index < cardlist.size){
                SwipableCard(
                    card = card,
                    modifier = Modifier.padding(top =(index*20).dp)
                        .zIndex(index.toFloat()),
                    onswiped = {
                        cardlist = cardlist.drop(1)
                    }
                )
            }
        }
    }

}
