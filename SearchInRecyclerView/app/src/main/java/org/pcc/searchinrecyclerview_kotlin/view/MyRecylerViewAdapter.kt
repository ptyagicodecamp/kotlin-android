package org.pcc.searchinrecyclerview_kotlin.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import org.pcc.searchinrecyclerview_kotlin.R
import org.pcc.searchinrecyclerview_kotlin.model.TheCard
import java.util.*

/**
 * Created by ptyagi on 9/9/17.
 */
//model data display configuration happens here
class MyRecyclerViewAdapter(private val mContext: Context, internal var theCards: ArrayList<TheCard>) : RecyclerView.Adapter<MyRecyclerViewHolder>(), Filterable {
    private var viewHolder: MyRecyclerViewHolder? = null
    private var searchFilter: SearchFilter? = null
    internal var filteredCardList: ArrayList<TheCard>

    init {
        this.filteredCardList = theCards
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, null)
        viewHolder = MyRecyclerViewHolder(view)
        return viewHolder as MyRecyclerViewHolder
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.tvCardId.setText(theCards[position].cardId)
        holder.tvCardName.setText(theCards[position].name)

        holder.setCardItemClickListener(object : CardItemClickListener {
            override fun onItemClick(v: View, pos: Int) {
                Toast.makeText(mContext, theCards[pos].name, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun getItemCount(): Int {
        return this.theCards.size
    }

    override fun getFilter(): Filter {
        if (searchFilter == null) {
            searchFilter = SearchFilter(filteredCardList, this)
        }

        return searchFilter as SearchFilter
    }
}
