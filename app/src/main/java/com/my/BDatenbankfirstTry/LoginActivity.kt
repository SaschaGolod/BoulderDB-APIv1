package com.my.BDatenbankfirstTry

import android.os.*
import android.widget.*
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.testlogin.*
import okhttp3.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testlogin)
    }


    fun loginBtn(view: View) {
        Toast.makeText(this, "Username: " + editTextView_Username.text, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Password: " + editTextView_Password.text, Toast.LENGTH_SHORT).show()

        fetchJSON(editTextView_Username.text.toString(), editTextView_Password.text.toString())

    }

    private fun fetchJSON(_username: String, _password: String) {
        Toast.makeText(this, "FETCH JSON", Toast.LENGTH_SHORT).show()
        println("Attempting to Fetch JSON")
        val client = OkHttpClient()

        val url = "http://boulderdb.flashh.de/account/login"

        val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("_username", "Sascha G")
                .addFormDataPart("_password", "sascha246810")
                .build()

                val request = Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build()
        //Do something with the response todo
    }
}