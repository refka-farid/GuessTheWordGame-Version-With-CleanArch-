package com.example.android.guesstheword.domain.repository

interface GameRepository {
    fun resetWords()
    fun getFirstWordOrDo(onGameEnded: () -> Unit): String
}
