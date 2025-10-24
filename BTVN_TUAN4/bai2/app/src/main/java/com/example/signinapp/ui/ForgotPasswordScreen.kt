package com.example.signinapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ForgotPasswordViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _code = MutableStateFlow("")
    val code = _code.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun setEmail(value: String) { _email.value = value }
    fun setCode(value: String) { _code.value = value }
    fun setPassword(value: String) { _password.value = value }

    fun clearData() {
        _email.value = ""
        _code.value = ""
        _password.value = ""
    }
}