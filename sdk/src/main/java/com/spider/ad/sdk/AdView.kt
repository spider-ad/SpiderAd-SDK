package com.spider.ad.sdk

import android.app.Activity
import android.content.Context
import android.view.ViewGroup
import android.webkit.WebView
import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import android.widget.Button


class AdView(var context: Context, val adFormat: String, val closeBtn: Boolean = true) {

    lateinit var spdWebView: WebView
    private val adContainer: ViewGroup
    private val btnCloseAd: Button

    var url = "https://s3.amazonaws.com/sdk.spider.ad/ad.html"

    init {
        if (adFormat == "divSpdRetangulo") {
            adContainer = (context as Activity).findViewById(R.id.adviewRetangulo) as ViewGroup
            btnCloseAd = (context as Activity).findViewById(R.id.closeAdRetangulo) as Button
        } else {
            adContainer = (context as Activity).findViewById(R.id.adviewStdBanner) as ViewGroup
            btnCloseAd = (context as Activity).findViewById(R.id.closeAdStdBanner) as Button
        }

        if (closeBtn) {
            btnCloseAd.setOnClickListener {
                adContainer.visibility = View.INVISIBLE
            }
        } else {
            btnCloseAd.visibility = View.INVISIBLE
        }
    }

    fun initialize() {
        GeoLocation(context, ::getGeoLocationCallback).geoLocation()

        spdWebView = WebView(this.context)

        spdWebView.settings.javaScriptEnabled = true
        try {
            val ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA)
            val bundle = ai.metaData
            url = url+"#"+bundle.getInt("com.spider.ad.sdk.AdView.AFFILIATE_ID")
        } catch (e: NullPointerException) {
            url = url+"#null"
            Log.e("error_affiliate", "Failed to load meta-data, NullPointer: " + e.message)
        }

        url = url+"#"+adFormat
    }

    fun getAdvIdCallback(content: String){
        url = url+"#"+content

        spdWebView.loadUrl(this.url)
        adContainer.addView(spdWebView)
    }

    fun getGeoLocationCallback(content: Array<Double?>){
        url = url+"#"+content[0].toString()+"#"+content[1].toString()
        Advertising(context, ::getAdvIdCallback).execute()
    }
}