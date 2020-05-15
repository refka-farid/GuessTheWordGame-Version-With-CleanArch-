package com.example.android.guesstheword.presentation.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

private const val GAME_TOTAL_TIME = 60_000L
private const val COUNTDOWN_TIME_INTERVAL = 1_000L
private const val GAME_OVER_TIME = 0L

class GameViewModel : ViewModel() {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String> = _word

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _hasEventGameFinished = MutableLiveData<Boolean>()
    val hasEventGameFinished: LiveData<Boolean> = _hasEventGameFinished

    // Countdown time
    private val _currentTime = MutableLiveData<Long>()
    val currentTimeString = Transformations.map(_currentTime) { elapsedSeconds ->
        DateUtils.formatElapsedTime(elapsedSeconds)
    }

    private val timer: CountDownTimer = object : CountDownTimer(GAME_TOTAL_TIME, COUNTDOWN_TIME_INTERVAL) {
        override fun onTick(millisUntilFinished: Long) {
            _currentTime.value = millisUntilFinished / COUNTDOWN_TIME_INTERVAL
        }

        override fun onFinish() {
            _currentTime.value = GAME_OVER_TIME
            onGameFinish()
        }
    }

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created !")
        _word.value = ""
        _score.value = 0
        timer.start()
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Log.i("GameViewModel", "GameViewModel destroyed ")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
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
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            resetList()
            //onGameFinish()
            //Select and remove a word from the list
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    fun finishGame() {
        _hasEventGameFinished.value = false
    }

    fun onGameFinish() {
        _hasEventGameFinished.value = true
    }
}


