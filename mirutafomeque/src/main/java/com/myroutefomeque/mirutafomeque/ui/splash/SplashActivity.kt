package com.myroutefomeque.mirutafomeque.ui.splash

import android.content.Intent
import android.view.Window
import  java.util.*
import kotlin.concurrent.timerTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import com.myroutefomeque.mirutafomeque.R
import com.myroutefomeque.mirutafomeque.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(timerTask {
            goToMainActivity()
        }, 3000
        )
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}