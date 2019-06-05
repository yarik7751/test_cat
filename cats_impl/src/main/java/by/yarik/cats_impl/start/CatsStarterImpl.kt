package by.yarik.cats_impl.start

import android.content.Context
import android.content.Intent
import by.yarik.cats_api.CatsStarter
import by.yarik.cats_impl.activity.CatsActivity
import by.yarik.cats_impl.annotation.CatsScreen

class CatsStarterImpl : CatsStarter {
    override fun startScreen(context: Context?, @CatsScreen screen: Int) {
        val intent = Intent(context, CatsActivity::class.java)
        intent.putExtra(CatsActivity.CATS_SCREEN, screen)
        context!!.startActivity(intent)
    }
}