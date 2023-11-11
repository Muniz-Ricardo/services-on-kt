package com.atarax.services.ui

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.atarax.services.R
import com.atarax.services.RunService
import com.atarax.services.utils.Actions

class MainActivity : AppCompatActivity() {

    private lateinit var startBtn: Button
    private lateinit var stopBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(POST_NOTIFICATIONS),
                0
            )
        }

        startBtn = findViewById(R.id.btn_start)
        stopBtn = findViewById(R.id.btn_stop)

        startBtn.setOnClickListener {
            Intent(applicationContext, RunService::class.java).also {
                it.action = Actions.START.name
                startService(it)
            }
        }

        stopBtn.setOnClickListener {
            Intent(applicationContext, RunService::class.java).also {
                it.action = Actions.STOP.name
                startService(it)
            }
        }
    }
}
