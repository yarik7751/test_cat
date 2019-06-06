package by.yarik.core

import android.content.Context
import androidx.annotation.StringRes

class ResourceManager(var context: Context?) {

    fun getString(@StringRes res: Int): String {
        return context!!.getString(res)
    }

    fun getString(@StringRes res: Int, vararg items: Any): String {
        return context!!.getString(res, items)
    }
}