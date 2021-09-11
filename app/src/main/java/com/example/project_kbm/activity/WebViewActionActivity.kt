package com.example.project_kbm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.project_kbm.databinding.ActivityWebViewActionBinding

class WebViewActionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewActionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewActionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value = intent.getStringExtra("value").toString()

        val webSetting = binding.wvAction.settings
        webSetting.javaScriptEnabled
        webSetting.supportZoom()
        webSetting.builtInZoomControls
        webSetting.useWideViewPort

        binding.wvAction.webViewClient = WebViewClient()
        binding.wvAction.loadUrl(value)
    }

    override fun onBackPressed() {
        if (binding.wvAction.canGoBack()) {
            binding.wvAction.goBack()
        } else {
            super.onBackPressed()
        }
    }
}