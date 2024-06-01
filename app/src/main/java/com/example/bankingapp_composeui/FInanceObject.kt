package com.example.bankingapp_composeui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import com.ahmedapps.bankningappui.ui.theme.BlueStart
import com.ahmedapps.bankningappui.ui.theme.GreenStart
import com.ahmedapps.bankningappui.ui.theme.OrangeStart
import com.ahmedapps.bankningappui.ui.theme.PurpleStart

object FInanceObject {

    val financedata:List<FInanceData> = listOf(
        FInanceData(
            fiananceImage = Icons.Rounded.StarHalf,
            financeType = "Business",
            financecolor = GreenStart
        ),

        FInanceData(
            financecolor = BlueStart,
            financeType = "School",
            fiananceImage = Icons.Rounded.Wallet
        ),
        FInanceData(
            financecolor = PurpleStart,
            financeType = "Work",
            fiananceImage = Icons.Rounded.StarHalf
        ),
        FInanceData(
            financecolor = OrangeStart,
            financeType = "Personal",
            fiananceImage = Icons.Rounded.MonetizationOn
        )

    )

}