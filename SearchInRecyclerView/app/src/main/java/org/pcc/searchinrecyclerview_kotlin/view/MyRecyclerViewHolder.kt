package org.pcc.searchinrecyclerview_kotlin.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.pcc.searchinrecyclerview_kotlin.R

/**
 * Created by ptyagi on 9/9/17.
 */
//Handles displaying data in UI Views
class MyRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    internal var tvCardId: TextView
    internal var tvCardName: TextView

    internal lateinit var cardItemClickListener: CardItemClickListener

    init {

        this.tvCardId = itemView.findViewById<TextView>(R.id.tvCardId) as TextView
        this.tvCardName = itemView.findViewById<TextView>(R.id.tvCardName) as TextView

        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        this.cardItemClickListener.onItemClick(view, layoutPosition)

    }

    fun setCardItemClickListener(listener: CardItemClickListener) {
        this.cardItemClickListener = listener
    }
}
