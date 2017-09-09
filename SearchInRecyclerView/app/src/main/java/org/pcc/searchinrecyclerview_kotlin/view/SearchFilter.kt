package org.pcc.searchinrecyclerview_kotlin.view

import android.widget.Filter
import org.pcc.searchinrecyclerview_kotlin.model.TheCard
import java.util.*

/**
 * Created by ptyagi on 9/9/17.
 */
//Filters data as per search term entered
class SearchFilter(private val filteredCardList: ArrayList<TheCard>, private val adapter: MyRecyclerViewAdapter) : Filter() {

    override fun performFiltering(charSequence: CharSequence?): Filter.FilterResults {
        var charSequence = charSequence
        val filterResults = Filter.FilterResults()

        if (charSequence != null && charSequence.length > 0) {
            charSequence = charSequence.toString().toLowerCase()
            val filteredCards = ArrayList<TheCard>()

            for (i in filteredCardList.indices) {
                if (filteredCardList[i].cardId!!.toLowerCase().contains(charSequence) || filteredCardList[i].name!!.toLowerCase().contains(charSequence)) {
                    filteredCards.add(filteredCardList[i])
                }
            }

            filterResults.count = filteredCards.size
            filterResults.values = filteredCards
        } else {
            filterResults.count = filteredCardList.size
            filterResults.values = filteredCardList
        }

        return filterResults
    }

    override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
        adapter.theCards = filterResults.values as ArrayList<TheCard>
        adapter.notifyDataSetChanged()
    }
}
