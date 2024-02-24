package com.example.plantshandbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor( val repo: Repository): ViewModel() {
    private val _state = MutableLiveData<UiState>()
    val Uistate: LiveData<UiState> = _state
    fun getData(){
        viewModelScope.launch {
            val character = async { repo.getHeroesList()}.await()
            if (character.isSuccessful && character.body() != null) {
                    _state.postValue(UiState.Result(character.body()!!))
            }
        }
    }
sealed class UiState {
    class Result(val character: CharacterResponse): UiState()
}
}