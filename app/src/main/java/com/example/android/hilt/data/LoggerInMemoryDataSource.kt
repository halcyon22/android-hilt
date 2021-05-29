package com.example.android.hilt.data

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoggerInMemoryDataSource @Inject constructor() : LoggerDataSource {

    private val logs = mutableListOf<Log>()

    override fun addLog(msg: String) {
        logs.add(
            Log(msg, System.currentTimeMillis())
        )
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs.reversed())
    }

    override fun removeLogs() {
        logs.clear()
    }
}