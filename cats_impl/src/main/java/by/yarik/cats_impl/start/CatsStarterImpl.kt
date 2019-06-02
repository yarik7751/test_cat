package by.yarik.cats_impl.start

import androidx.fragment.app.Fragment
import by.yarik.cats_api.CatsStarter
import by.yarik.cats_impl.presentation.cats.view.CatsFragment

class CatsStarterImpl : CatsStarter {
    override fun getScreen(): Fragment {
        return CatsFragment()
    }
}