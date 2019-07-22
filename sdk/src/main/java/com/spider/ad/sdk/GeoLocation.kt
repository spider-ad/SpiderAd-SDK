package com.spider.ad.sdk

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import kotlin.Array


class GeoLocation(var context: Context, private val callback: (content: Array<Double?>) ->Unit) {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    var response = arrayOfNulls<Double>(2)

    @SuppressLint("MissingPermission")
    fun geoLocation(){

        Permissions.check(context, Manifest.permission.ACCESS_FINE_LOCATION, null, object : PermissionHandler() {
            override fun onGranted() {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location : Location? ->
                        response[0] = location!!.latitude
                        response[1] =  location!!.longitude

                        callback(response)
                    }
            }

            override fun onDenied(context: Context, deniedPermissions: ArrayList<String>) {
                response[0] = 0.0
                response[1] = 0.0
                callback(response)
            }
        })
    }

}