package com.myroutefomeque.mirutafomeque.ui.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private var userLogin : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLoggedIn : LiveData<Boolean> = userLogin

    fun login(email: String, password: String) {
        // Initialize Firebase Auth
        auth = Firebase.auth

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    userLogin.value = true
                    Log.d("Login", "signInWithEmail:success")

                } else {
                    // If sign in fails, display a message to the user.
                    userLogin.value = false
                    Log.w("Login", "signInWithEmail:failure", task.exception)

                }
            }
    }


}