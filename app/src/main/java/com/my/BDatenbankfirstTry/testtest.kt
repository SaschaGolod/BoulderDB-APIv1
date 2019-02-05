package com.my.BDatenbankfirstTry

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

class testtest {

    var client = OkHttpClient()

    @Throws(IOException::class)
    internal fun post(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder()
                .url(url)
                .post(body)
                .build()
        val response = client.newCall(request).execute()
        return response.body()!!.string()
    }

    companion object {

        val JSON = MediaType.parse("application/json; charset=utf-8")
    }


}