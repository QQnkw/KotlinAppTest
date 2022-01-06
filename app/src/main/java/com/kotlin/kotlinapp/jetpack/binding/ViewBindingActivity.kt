package com.kotlin.kotlinapp.jetpack.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.text.HtmlCompat
import com.kotlin.kotlinapp.databinding.ActivityViewBindingBinding
import net.nightwhistler.htmlspanner.HtmlSpanner

/**
 * 视图绑定activity
 */
class ViewBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val html =
            "<p style=\"text-align:center\"><span style=\"font-size: 36px; color: #333333;\">Foreo would like to access your <span style=\"color:#0000FF;\"><strong>photo gallery</strong></span> , so you can <span style=\"color:#FF0000;font-size: 16px;\" ><strong>choose the existing photo as your profile picture</strong></span>.</span></p>"
        binding.textView.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)

        binding.webView.loadDataWithBaseURL(null, html, "text/html", "base64", null)

        val htmlSpanner = HtmlSpanner()
        binding.textView1.text = htmlSpanner.fromHtml(html)

        val ss = SpannableString("Foreo would like to access your")
        ss.setSpan(AbsoluteSizeSpan(16),6,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView2.text = ss
    }
}