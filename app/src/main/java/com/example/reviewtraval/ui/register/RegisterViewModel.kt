package com.example.reviewtraval.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel  : ViewModel(){
    private val _registerModel  = MutableLiveData<RegisterModel>()
    val registerModel: LiveData<RegisterModel> = _registerModel
    fun  register(){

    }

}