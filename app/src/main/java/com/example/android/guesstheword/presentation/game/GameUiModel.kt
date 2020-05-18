package com.example.android.guesstheword.presentation.game

import androidx.lifecycle.LiveData

data class GameUiModel(val word: LiveData<String>,
                       val score: LiveData<Int>,
                       val currentTimeString: LiveData<String>
)
