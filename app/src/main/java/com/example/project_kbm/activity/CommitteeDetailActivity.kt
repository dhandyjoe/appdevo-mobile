package com.example.project_kbm.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.project_kbm.R
import com.example.project_kbm.database.Constants
import com.example.project_kbm.database.Constants.COMMITTEE_DETAIL
import com.example.project_kbm.databinding.ActivityCommitteeDetailBinding
import com.example.project_kbm.model.ModelCommittee

class CommitteeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommitteeDetailBinding
    private lateinit var committeeData: ModelCommittee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommitteeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Code for status bar transparant
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        if (intent.hasExtra(COMMITTEE_DETAIL)) {
            committeeData = intent.getParcelableExtra(COMMITTEE_DETAIL)!!
        }

        binding.ivPosterCommittee.setImageResource(committeeData.cardCommittee)
        binding.nameCommittee.text = committeeData.nameCommittee
        binding.btnDirectLinkCommittee.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(committeeData.url)
            startActivity(intent)
        }

        binding.ivBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}