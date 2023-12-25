package com.saydullin.duplifind.presentation.utils

class GamePriceController {

    companion object {
        fun getPriceAmount(secondsPassed: Int): Int {
            if (secondsPassed < 20) {
                return 100
            }

            val price = 100 - ((secondsPassed - 20) * 5)

            return if (price < 10) {
                10
            } else {
                price
            }
        }
    }

}


