package com.myroutefomeque.mirutafomeque.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.myroutefomeque.mirutafomeque.databinding.LoginFragmentBinding
import com.myroutefomeque.mirutafomeque.utils.isEmailValid

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = LoginFragmentBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginViewModel.onUserLoggedIn.observe(viewLifecycleOwner, { result ->
            onUserLoggedInSubscribe(result)

        })

        return loginBinding.root
    }


    private fun onUserLoggedInSubscribe(result: Boolean?) {
        result?.let { isLoggedIn ->
            if (isLoggedIn){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNavigationList())
            } else
                Toast.makeText(context, "Error en el inicio se sesión", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(loginBinding){
            loginButton.setOnClickListener{
                val email = emailLoginEditText.text.toString()
                val password = passwordLoginEditText.text.toString()

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(context,"Ingrese un correo electrónico y su contraseña", Toast.LENGTH_SHORT).show()
                else
                    if (!isEmailValid(email))
                        Toast.makeText(context,"El correo elesctrónico esta mal escrito", Toast.LENGTH_SHORT).show()
                    else
                        loginViewModel.login(email, password)
            }

            registerTextView.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment2())
            }

        }
    }

}


