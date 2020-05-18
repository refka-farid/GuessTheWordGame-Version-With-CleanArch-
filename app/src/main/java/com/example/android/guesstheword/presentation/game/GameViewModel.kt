package com.example.android.guesstheword.presentation.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.*
import com.example.android.guesstheword.domain.usecase.GameUseCase

private const val GAME_TOTAL_TIME = 60_000L
private const val COUNTDOWN_TIME_INTERVAL = 1_000L
private const val GAME_OVER_TIME = 0L

class GameViewModel constructor(handle: SavedStateHandle,
                                private val gameUseCase: GameUseCase) : ViewModel() {
    // Countdown time
    private val _currentTime = MutableLiveData<Long>()
    private val currentTimeString = Transformations.map(_currentTime) { elapsedSeconds ->
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

    val finalScore: LiveData<Int> = gameUseCase.finalScore
    val gameUiModel = GameUiModel(gameUseCase.word, gameUseCase.score, currentTimeString)

    init {
        timer.start()
        gameUseCase.resetList()
        gameUseCase.selectNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        gameUseCase.resetGame()
        Log.i("GameViewModel", "GameViewModel destroyed ")
    }

    /**region Methods for buttons presses**/
    fun onSkip() {
        gameUseCase.scoreMissed()
    }

    fun onCorrect() {
        gameUseCase.scoreGoal()
    }

    fun onGameFinish() {
        gameUseCase.endGame()
    }
    /** endregion Methods for buttons presses**/

}
