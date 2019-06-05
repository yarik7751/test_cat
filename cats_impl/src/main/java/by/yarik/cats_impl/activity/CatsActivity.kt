package by.yarik.cats_impl.activity

import android.os.Bundle
import by.yarik.cats_impl.R
import by.yarik.cats_impl.annotation.CatsScreen
import by.yarik.cats_impl.presentation.cats.view.CatsFragment
import by.yarik.cats_impl.presentation.favorite_cats.view.FavoriteCatsFragment
import by.yarik.core.BaseActivity

class CatsActivity: BaseActivity() {

    companion object {
        const val CATS_SCREEN = "CATS_SCREEN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)
        setContainerFragmentRes(R.id.container)

        val screen = intent.getIntExtra(CATS_SCREEN, 0)

        val fragment = when(screen) {
            CatsScreen.ALL_CATS -> CatsFragment()
            CatsScreen.FAVORITE_CATS -> FavoriteCatsFragment()
            else -> CatsFragment()
        }

        setMainFragment(fragment)
    }
}