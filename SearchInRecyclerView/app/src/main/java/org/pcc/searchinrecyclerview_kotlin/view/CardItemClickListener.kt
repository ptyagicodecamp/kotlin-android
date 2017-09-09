package org.pcc.searchinrecyclerview_kotlin.view

import android.view.View

/**
 * Created by ptyagi on 9/9/17.
 */
interface CardItemClickListener {
    abstract fun onItemClick(v: View, pos: Int)
}