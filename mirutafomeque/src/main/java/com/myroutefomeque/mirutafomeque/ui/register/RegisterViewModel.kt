package com.myroutefomeque.mirutafomeque.ui.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.myroutefomeque.mirutafomeque.model.SitiosTuristicosItem

class RegisterViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private var userCreate : MutableLiveData<Boolean> = MutableLiveData()
    val onUserCreated : LiveData<Boolean> = userCreate

    fun register(email: String, password: String) {
        // Initialize Firebase Auth
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    userCreate.value = true
                    Log.d("Registro", "createUserWithEmail:success")


                } else {
                    // If sign in fails, display a message to the user.
                    userCreate.value = false
                    Log.w("Registro", "createUserWithEmail:failure", task.exception)

                }
            }
    }

}