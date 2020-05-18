package com.example.android.guesstheword.data.repository

import com.example.android.guesstheword.data.datasource.DataSource
import com.example.android.guesstheword.domain.repository.GameRepository

class GameRepositoryImpl(private val dataSource: DataSource) : GameRepository {

    override fun resetWords() {
        dataSource.wordList.clear()
        dataSource.fillTheList()
        dataSource.wordList.shuffle()
    }

    override fun getFirstWordOrDo(onGameEnded: () -> Unit): String {
        if (dataSource.wordList.isEmpty()) {
            onGameEnded()
            return ""
        }
        return dataSource.wordList.removeAt(0)
    }
}
