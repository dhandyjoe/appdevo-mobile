package com.example.project_kbm.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.project_kbm.R
import com.example.project_kbm.database.Constants
import com.example.project_kbm.database.Constants.EVENT_DETAIL
import com.example.project_kbm.database.Constants.NEWS_DETAIL
import com.example.project_kbm.databinding.ActivityEventDetailBinding
import com.example.project_kbm.model.ModelEvent

class EventDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailBinding
    private lateinit var eventData: ModelEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Code for status bar transparant
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        if (intent.hasExtra(EVENT_DETAIL)) {
            eventData = intent.getParcelableExtra(EVENT_DETAIL)!!
        }

        binding.ivPosterEvent.setImageResource(eventData.cardPoster)
        binding.nameEvent.text = eventData.name
        binding.btnDirectLinkEvent.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(eventData.url)
            startActivity(intent)
        }

        binding.ivBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}