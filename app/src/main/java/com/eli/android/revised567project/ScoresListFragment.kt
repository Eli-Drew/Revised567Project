package com.eli.android.revised567project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ScoresListFragment : Fragment() {
    private lateinit var userScore: UserScore
    private lateinit var scoreRecyclerView: RecyclerView
    private var adapter:ScoreAdapter? = ScoreAdapter(emptyList())
    private val scoresListViewModel: ScoresListViewModel by lazy {
        ViewModelProvider(this).get(ScoresListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userScore = UserScore()
    } // end of onCreate()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.scores_list_layout, container,false)

        scoreRecyclerView = view.findViewById(R.id.score_recycler_view)
        scoreRecyclerView.layoutManager = LinearLayoutManager(context)
//        updateUI()
        return view
    } // end of onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scoresListViewModel.scoresListLiveData.observe(
            viewLifecycleOwner,
            Observer { scores ->
                scores?.let {
                    updateUI(scores)
                }
            }
        )
    } // end of onViewCreated

    private fun updateUI(scores: List<UserScore>) {
//        val scores : MutableList<UserScore> = scoresListViewModel.scores
        adapter = ScoreAdapter(scores)
        scoreRecyclerView.adapter=adapter
    } // end of updateUI()

    companion object {
        fun newInstance(): ScoresListFragment {
            return ScoresListFragment()
        }
    } // end of companion object

    private inner class ScoreHolder(view: View) : RecyclerView.ViewHolder(view){
        private lateinit var score: UserScore

        private val usernameTextView: TextView = itemView.findViewById(R.id.score_item_username)
        private val timeTextView: TextView = itemView.findViewById(R.id.score_item_time)
        private val scoreTextView: TextView = itemView.findViewById(R.id.score_item_points)

        fun bind(score: UserScore) {
            this.score = score
            timeTextView.text = this.score.time
            usernameTextView.text = this.score.userName
            scoreTextView.text = this.score.totalPoints.toString()
        } // end of bind()

    } // end of ScoreHolder inner class

    private inner class ScoreAdapter(var scores:List<UserScore>) : RecyclerView.Adapter<ScoreHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreHolder {
            val view: View = layoutInflater.inflate(R.layout.score_item_layout, parent, false)
            return ScoreHolder(view)
        } // end of onCreateViewHolder

        override fun getItemCount(): Int {
            return scores.size
        }

        override fun onBindViewHolder(holder: ScoreHolder, position: Int) {
            val score: UserScore = scores[position]
            holder.bind(score)
//            holder.apply {
//                usernameTextView.text = score.userName
//                timeTextView.text = score.time
//            }
        } // end of onBindViewHolder

    } // end of ScoreAdapter inner class
}