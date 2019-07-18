package com.spider.ad.sdk

import android.content.Context
import android.view.ViewGroup
import android.webkit.WebView

class AdView(var context: Context, var adContainer: ViewGroup) {

    lateinit var spdWebView : WebView
    var url = "https://s3.amazonaws.com/exemplos.spider.ad/spider_sdk/banner_arroba.html#1032#divSpdStandardBanner"

    fun initialize() {
        spdWebView = WebView(this.context)

        spdWebView.settings.javaScriptEnabled = true

        spdWebView.loadUrl(this.url)
        adContainer.addView(spdWebView)
    }
}