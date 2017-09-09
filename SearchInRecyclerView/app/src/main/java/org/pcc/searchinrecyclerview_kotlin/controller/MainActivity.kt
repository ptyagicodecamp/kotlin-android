package org.pcc.searchinrecyclerview_kotlin.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import org.pcc.searchinrecyclerview_kotlin.R
import org.pcc.searchinrecyclerview_kotlin.model.TheCard
import org.pcc.searchinrecyclerview_kotlin.view.MyRecyclerViewAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mSeachView: SearchView? = null
    private var mRecyclerView: RecyclerView? = null
    //private MyRecyclerViewAdapter adapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSeachView = findViewById<SearchView>(R.id.searchView) as SearchView
        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView

        //Set RecyclerView layout as LinearLayout to laid out data in it
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))

        //Set ItemAnimator for RecyclerView list items
        mRecyclerView!!.setItemAnimator(DefaultItemAnimator())

        //Set adapter to display contents in View
        val adapter = MyRecyclerViewAdapter(this, cards)
        mRecyclerView!!.setAdapter(adapter)

        mSeachView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.getFilter().filter(newText)
                return false
            }
        })

    }

    //Generate DummyData
    val cards: ArrayList<TheCard>
        get() {
            val theCards = ArrayList<TheCard>()

            var card = TheCard()
            card.cardId = "my_card_1"
            card.name = "This is Card 1"
            theCards.add(card)

            card = TheCard()
            card.cardId = "my_card_2"
            card.name = "This is Card 2"
            theCards.add(card)

            card = TheCard()
            card.cardId = "my_card_3"
            card.name = "This is Card 3"
            theCards.add(card)

            card = TheCard()
            card.cardId = "my_card_4"
            card.name = "This is Card 4"
            theCards.add(card)

            card = TheCard()
            card.cardId = "my_card_5"
            card.name = "This is Card 5"
            theCards.add(card)

            return theCards
        }
}
