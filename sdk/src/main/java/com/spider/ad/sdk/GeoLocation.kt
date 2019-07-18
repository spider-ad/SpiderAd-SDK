package com.spider.ad.sdk

import android.Manifest
import android.app.Activity
import android.widget.TextView
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions


class GeoLocation(var context: Activity, var txv: TextView) {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    fun geoLocation() {

        Permissions.check(context, Manifest.permission.ACCESS_FINE_LOCATION, null, object : PermissionHandler() {
            override fun onGranted() {
                fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location : Location? ->
                        txv.text = "Latitude: " + location!!.latitude + "\nLongitude: " + location!!.longitude
                    }
            }

            override fun onDenied(context: Context, deniedPermissions: ArrayList<String>) {
                txv.text = "negou a permissao"
            }
        })
    }

}