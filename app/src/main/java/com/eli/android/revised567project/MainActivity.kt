package com.eli.android.revised567project

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var menuStartButton: Button
    private lateinit var menuScoresButton: Button
    private lateinit var menuHelpButton: Button
    private lateinit var menuQuitButton: Button
    private lateinit var animationLogo: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuStartButton = findViewById(R.id.menu_start_button)
        menuScoresButton = findViewById(R.id.menu_score_button)
        menuHelpButton = findViewById(R.id.menu_help_button)
        menuQuitButton = findViewById(R.id.menu_quit_button)

        val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        imageView.setBackgroundResource(R.drawable.main_logo_animation)
        animationLogo = imageView.background as AnimationDrawable

//        animationLogo = AnimationUtils.loadAnimation(this, R.anim.main_logo_animation)
//        imageView.startAnimation(animationLogo)


        menuStartButton.setOnClickListener{
            val intent = Intent(this, LanguageSelect::class.java)
            startActivity(intent)
        } // end  of menuStartButton

        menuScoresButton.setOnClickListener {
            val scoreIntent = Intent(this, ScoresListActivity::class.java)
            startActivity(scoreIntent)
        } // end of menuScoresButton

        menuHelpButton.setOnClickListener {
            val helpIntent = Intent(this, HelpActivity::class.java)
            startActivity(helpIntent)
        } // end of menuHelpButton

        menuQuitButton.setOnClickListener {
//            onFinishedClick()
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags((Intent.FLAG_ACTIVITY_NEW_TASK))
            startActivity(intent)
            finish()

        } // end of menuQuitButton



    } // end of override fun onCreate

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        animationLogo.start()
    }

} // end of class

