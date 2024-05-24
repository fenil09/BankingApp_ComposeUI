package com.example.bankingapp_composeui

import com.ahmedapps.bankningappui.ui.theme.*

object CardObject {
    val cards= listOf(
        CardData(
            "4517 8568 7884 5500",
            cardholdername = "Fenil",
            cardtype = "Visa",
            expirationDate = "25/78",
            startcolor = PurpleStart,
            endColor = PurpleEnd
        ),
        CardData(
            cardnumber = "7788 7415 6589 7396",
            cardholdername = "Cristiano",
            cardtype = "Mastercard",
            expirationDate = "14/24",
            startcolor = BlueStart,
            endColor = BlueEnd
        ),

        CardData(
            cardnumber = "5477 7845 5235 6600",
            cardholdername = "Messi",
            cardtype = "American Express",
            expirationDate = "20/29",
            startcolor = OrangeStart,
            endColor = OrangeEnd
        )
    )
}