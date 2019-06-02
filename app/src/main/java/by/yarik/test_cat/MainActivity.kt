package by.yarik.test_cat

import android.os.Bundle
import by.yarik.cats_impl.di.CatsComponent
import by.yarik.core.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContainerFragmentRes(R.id.container)

        setMainFragment(CatsComponent.getInstance().getStarter().getScreen())
    }
}
