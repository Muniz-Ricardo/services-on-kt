package com.atarax.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.atarax.services.utils.Actions

/**
 * Classe responsável por rodar o processo(mante-lo) que está sendo requisitado.
 */
class RunService: Service() {

    /**
     * Interage com o componente que vai ser processado durante a execução.
     */
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    /**
     * Recebe o comando sendo descrito pela INTENT, nesse caso o START e STOP.
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent!!.action) {
            Actions.START.name -> start()
            Actions.STOP.name -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(androidx.core.R.drawable.notification_bg)
            .setContentTitle("App in background")
            .setContentText("Running service")
            .build()

        startForeground(1, notification)
    }

}