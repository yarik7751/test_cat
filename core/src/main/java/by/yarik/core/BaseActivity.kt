package by.yarik.core

import android.annotation.SuppressLint
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {

    @LayoutRes
    private var containerFragmentRes = 0

    fun setMainFragment(fragment: Fragment) {
        setFragment(fragment, false)
    }

    fun setCurrentFragment(fragment: Fragment) {
        setFragment(fragment, true)
    }

    @SuppressLint("ResourceType")
    fun setFragment(fragment: Fragment, add: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val fragmentName = fragment.javaClass.name

        transaction.replace(containerFragmentRes, fragment, fragmentName)
        if (add) {
            transaction.addToBackStack(fragmentName)
        }
        transaction.commit()
    }

    protected fun setContainerFragmentRes(containerFragmentRes: Int) {
        this.containerFragmentRes = containerFragmentRes
    }
}