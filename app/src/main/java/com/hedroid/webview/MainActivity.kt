package com.hedroid.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.hedroid.webview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.webView.loadUrl( "https://github.com/sachin-maury")
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled=true

    }

    //Handle page navigation

    override fun onKeyDown(keyCode:Int,event: KeyEvent?):Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}