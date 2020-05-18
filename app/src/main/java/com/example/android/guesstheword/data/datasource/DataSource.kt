package com.example.android.guesstheword.data.datasource

object DataSource {
    private val staticList = listOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble")

    val wordList: MutableList<String> by lazy {
        staticList.toMutableList()
    }

    fun fillTheList() {
        wordList += staticList
    }
}
