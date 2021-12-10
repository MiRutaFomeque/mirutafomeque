package com.myroutefomeque.mirutafomeque.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.myroutefomeque.mirutafomeque.R
import com.myroutefomeque.mirutafomeque.databinding.LoginFragmentBinding
import com.myroutefomeque.mirutafomeque.databinding.RegisterFragmentBinding
import com.myroutefomeque.mirutafomeque.ui.login.LoginFragmentDirections
import com.myroutefomeque.mirutafomeque.ui.login.LoginViewModel
import com.myroutefomeque.mirutafomeque.utils.isEmailValid

class RegisterFragment : Fragment() {


    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerBinding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBinding = RegisterFragmentBinding.inflate(inflater, container, false)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        registerViewModel.onUserCreated.observe(viewLifecycleOwner, { result ->
            onUserCreatedSubscribe(result)

        })

        return registerBinding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegister ->
            if (isRegister) {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragment2ToLoginFragment2())
            } else
                Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(registerBinding){
            registerButton.setOnClickListener{
                val username = usernameRegisterEditText.text.toString()
                val email = emailRegisterEditText.text.toString()
                val password = passwordRegisterEditText.text.toString()
                val passwordRepeat = passwordRepeatRegisterEditText.text.toString()

                if (email.isEmpty() || password.isEmpty() || username.isEmpty() || passwordRepeat.isEmpty())
                    android.widget.Toast.makeText(context,"Los datos están incompletos", android.widget.Toast.LENGTH_SHORT).show()
                else
                    if (!isEmailValid(email))
                        android.widget.Toast.makeText(context,"El correo elesctrónico esta mal escrito", android.widget.Toast.LENGTH_SHORT).show()
                    else
                        registerViewModel.register(email, password)
            }


        }
    }

}