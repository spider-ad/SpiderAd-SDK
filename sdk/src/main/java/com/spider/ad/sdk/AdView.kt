package com.spider.ad.sdk

import android.content.Context
import android.view.ViewGroup
import android.webkit.WebView
import android.content.pm.PackageManager
import android.util.Log



class AdView(var context: Context, var adContainer: ViewGroup, val adFormat: String) {

    lateinit var spdWebView : WebView
    var url = "https://s3.amazonaws.com/exemplos.spider.ad/spider_sdk/banner_arroba.html"

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