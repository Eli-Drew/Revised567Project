package com.eli.android.revised567project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ScoresListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scores_list_fragment_container)
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_scoreslist_container)
        if (currentFragment == null) {
            val fragment = ScoresListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_scoreslist_container, fragment)
                .commit()
        }
    }
}