package com.example.reviewtraval.ui.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reviewtraval.data.api.ApiService
import com.example.reviewtraval.data.api.response.LoginResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel : ViewModel(){
    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }
    val _authenticationState = MutableLiveData<AuthenticationState>()

    val authenticationState: LiveData<AuthenticationState>
        get() = _authenticationState

    var username= ""

    var password = ""


    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        _authenticationState.value = AuthenticationState.UNAUTHENTICATED
        this.username =""
        this.password=""
    }
    fun refuseAuthentication() {
        _authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String, password: String) {
        if (passwordIsValidForUsername(username, password)) {
            Log.d("authenticate","true")
            this.username = username
            _authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            _authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {
        Log.d("validate","ok")
        if (username.isNotEmpty() && password.isNotEmpty()) return  true
        return  false
    }
}