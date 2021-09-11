package com.example.project_kbm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_kbm.R
import com.example.project_kbm.database.Constants.NEWS_DETAIL
import com.example.project_kbm.databinding.ActivityNewsDetailBinding
import com.example.project_kbm.fragment.NewsFragment
import com.example.project_kbm.model.ModelNews

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding
    private lateinit var newsData: ModelNews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(NEWS_DETAIL)) {
            newsData = intent.getParcelableExtra(NEWS_DETAIL)!!
        }

        binding.tvCategory.text = newsData.nameCategory
        binding.tvName.text = newsData.name
        binding.tvDate.text = newsData.date
        binding.tvNameNews.text = newsData.nameNews
        binding.tvDetailNews.text = newsData.detailNews
    }
}