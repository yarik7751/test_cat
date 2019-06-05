package by.yarik.test_cat

import android.os.Bundle
import by.yarik.cats_impl.annotation.CatsScreen
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allCatsButton.setOnClickListener {
            CatsComponent.getInstance().getStarter().startScreen(this, CatsScreen.ALL_CATS)
        }

        favoriteCatsButton.setOnClickListener {
            CatsComponent.getInstance().getStarter().startScreen(this, CatsScreen.FAVORITE_CATS)
        }
    }
}
