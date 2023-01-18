package com.alpamedev.pokewixexplorer.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseAuth>(null)
    val user : MutableLiveData<FirebaseAuth> = _user

}