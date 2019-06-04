package by.yarik.core

import android.content.Context

class AppContexProvider {

    companion object {
        var context: Context? = null

        fun getApplicationContext(): Context? {
            return context
        }

        fun setApplicationContext(appContext: Context?) {
            context = appContext
        }
    }
}