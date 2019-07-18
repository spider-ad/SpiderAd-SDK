package com.spider.ad.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.spider.ad.sdk.AdView
import com.spider.ad.sdk.Advertising
import com.spider.ad.sdk.GeoLocation

//import com.spider.ad.sdk.AdView
//import com.spider.ad.sdk.Advertising
//import com.spider.ad.sdk.GeoLocation


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtGid = findViewById(R.id.txt_gid) as TextView
        val txtGeo = findViewById(R.id.txt_geo) as TextView
        val adContainer = findViewById(R.id.adview) as LinearLayout
//        val btnLocation = findViewById(R.id.btn_location) as Button
//        val btnGid = findViewById(R.id.btn_gid) as Button

        val adview = AdView(this, adContainer)
        adview.initialize()
        Advertising(this, txtGid).execute()
        GeoLocation(this, txtGeo).geoLocation()

//        btnGid.setOnClickListener {
//            Advertising(this, text).execute()
//        }
//
//        btnLocation.setOnClickListener {
//            GeoLocation(this, text).geoLocation()
//        }
    }


}
