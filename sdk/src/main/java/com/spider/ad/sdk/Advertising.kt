package com.spider.ad.sdk

import android.content.Context
import android.os.AsyncTask
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import java.io.IOException

class Advertising(var context: Context, private val callback: (content: String) -> Unit) : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void?): String? {
        var adInfo: Info
        try {
            adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context)
        } catch (e: IOException) {
            return e.message
        } catch (e: GooglePlayServicesNotAvailableException) {
            return e.message

        }
//        var id: String = adInfo.id
//        var isLAT: Boolean = adInfo.isLimitAdTrackingEnabled

        return adInfo.id
    }

    override fun onPreExecute() {
        super.onPreExecute()
        // ...
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        callback(result)
    }
}