package com.eli.android.revised567project

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

class ScoresList : AppCompatActivity() {

    private lateinit var scoresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.scores_list_layout)
    }


    fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.scores_list_layout, container, false)

        scoresRecyclerView = view.findViewById(R.id.score_recycler_view) as RecyclerView
        scoresRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        return view
    }

    private inner class ScoreHolder(view: View) : RecyclerView.ViewHolder(view) {
        val usernameTextView: TextView = itemView.findViewById(R.id.score_item_username)
        val timeTextView: TextView = itemView.findViewById(R.id.score_item_time)
    }
}