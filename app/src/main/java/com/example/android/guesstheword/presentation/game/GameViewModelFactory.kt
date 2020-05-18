package com.example.android.guesstheword.presentation.game

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.android.guesstheword.data.datasource.DataSource
import com.example.android.guesstheword.data.repository.GameRepositoryImpl
import com.example.android.guesstheword.domain.usecase.GameUseCase

//class GameViewModelFactory() : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
//            val gameUseCase = GameUseCase()
//            return GameViewModel(gameUseCase) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}

class GameViewModelFactory(owner: SavedStateRegistryOwner) : AbstractSavedStateViewModelFactory(owner, null) {
    override fun <T : ViewModel?> create(key: String,
                                         modelClass: Class<T>,
                                         handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            val gameRepository = GameRepositoryImpl(DataSource)
            val gameUseCase = GameUseCase(gameRepository)
            return GameViewModel(handle, gameUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

