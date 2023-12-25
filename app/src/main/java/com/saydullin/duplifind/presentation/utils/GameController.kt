package com.saydullin.duplifind.presentation.utils

import android.annotation.SuppressLint
import com.saydullin.duplifind.R
import com.saydullin.duplifind.domain.model.GameMain
import com.saydullin.duplifind.domain.model.GameObject

class GameController {

    fun createNewGame(): GameMain {
        val newGameObjects = getGameObjects()

        return GameMain(
            expiredSeconds = 0,
            items = newGameObjects,
            coins = 0,
        )
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun getIcons(): Set<Pair<Int, String>> {

        return setOf(
            Pair(R.drawable.division_object, "Division"),
            Pair(R.drawable.pi_pi_object, "Pi"),
            Pair(R.drawable.equal_object, "Equal"),
            Pair(R.drawable.function_object, "Function"),
            Pair(R.drawable.infinity_object, "Infinity"),
            Pair(R.drawable.is_an_element_of_mathematics_object, "Is Element"),
            Pair(R.drawable.is_not_an_element_of_algebra_object, "Is Not Element"),
            Pair(R.drawable.is_approximately_equal_object, "Is Approximately"),
            Pair(R.drawable.is_greater_than_object, "Is Greater Than"),
            Pair(R.drawable.is_less_than_object, "Is Less Than"),
//            Pair(R.drawable.is_not_equal_object, "Is Not Equal"),
//            Pair(R.drawable.minus_object, "Minus"),
//            Pair(R.drawable.multiply_object, "Multiply"),
//            Pair(R.drawable.percentage_object, "Percentage"),
//            Pair(R.drawable.plus_object, "Plus"),
//            Pair(R.drawable.square_object, "Square"),
//            Pair(R.drawable.the_sum_of_sum_object, "The Sum Of Sum"),
        )
    }

    private fun getShuffledIcons(): List<Pair<Int, String>> {
        return getIcons().shuffled()
    }

    fun getGameObjects(amount: Int = 20): List<GameObject> {
        val gameObjects = arrayListOf<GameObject>()
        val shuffledIconsFirst = getShuffledIcons()
        val shuffledIconsSecond = getShuffledIcons()
        val shuffledDoubleIcons = ArrayList<Pair<Int, String>>()

        shuffledDoubleIcons.addAll(shuffledIconsFirst)
        shuffledDoubleIcons.addAll(shuffledIconsSecond)

        for ((index, shuffledIcon) in shuffledDoubleIcons.take(amount).withIndex()) {
            gameObjects.add(
                GameObject(
                    id = index,
                    src = shuffledIcon.first,
                    title = shuffledIcon.second,
                    isHidden = true
                )
            )
        }

        return gameObjects
    }

}


