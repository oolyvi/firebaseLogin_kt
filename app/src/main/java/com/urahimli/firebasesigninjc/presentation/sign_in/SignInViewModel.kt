package com.urahimli.firebasesigninjc.presentation.sign_in

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()    //viewmodel bu state'ler sayesinde ekrani update edir gelen dataya gore

    fun onSignInResult(result: SignInResult) {  //viewmodel oz isini gorub update edir data ve ui qismini
        _state.update { it.copy(
            isSignInSuccessful = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignInState() }
    }
}