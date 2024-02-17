package com.example.plantshandbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
class MyViewModel: ViewModel() {
    private val _state = MutableLiveData<UiState>()
    val Uistate: LiveData<UiState> = _state
    private val repo = MyAppication.getInstance().repo

    fun getData(){
        viewModelScope.launch {
            val character = async { repo.getHeroesList()}.await()
            if (character.isSuccessful && character.body() != null) {
                let {
                    _state.postValue(UiState.Result(character.body()!!))
                }
            }
        }
    }











sealed class UiState {
    class Result(val character: CharacterResponse): UiState()
}
}