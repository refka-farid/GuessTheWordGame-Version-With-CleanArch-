package com.example.android.guesstheword.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.guesstheword.domain.repository.GameRepository

class GameUseCase(private val gameRepository: GameRepository) {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _hasEventGameFinished = MutableLiveData<Boolean>()

    private val _finalScore = MediatorLiveData<Int>()
    val finalScore: LiveData<Int> = _finalScore

    init {
        _finalScore.addSource(_hasEventGameFinished) { hasFinished ->
            if (hasFinished) {
                _finalScore.value = _score.value ?: 0
            }
        }
        _word.value = ""
        _score.value = 0
    }

    fun scoreGoal() {
        _score.value = score.value?.plus(1)
        selectNextWord()
    }

    fun scoreMissed() {
        _score.value = score.value?.minus(1)
        selectNextWord()
    }

    fun endGame() {
        _hasEventGameFinished.value = true
    }

    fun resetGame() {
        _hasEventGameFinished.value = false
    }

    /**
     * Moves to the next word in the list
     */
    fun selectNextWord() {
        _word.value = gameRepository.getFirstWordOrDo {
            endGame()
        }
    }

    /**
     * Resets the list of words and randomizes the order
     */
    fun resetList() {
        gameRepository.resetWords()
    }
}
