package com.example.appweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val Button=findViewById<Button>(R.id.button_back)
        val text=findViewById<TextView>(R.id.text_city)
        val textToday=findViewById<TextView>(R.id.txtToday)
        val textsun=findViewById<TextView>(R.id.txtSun)
        val textmon=findViewById<TextView>(R.id.txtMon)
        val textTu=findViewById<TextView>(R.id.txtTu)
        val textWe=findViewById<TextView>(R.id.txtWe)
        val textThu=findViewById<TextView>(R.id.txtThu)

        val yuness=PreferenceManager.getDefaultSharedPreferences(this).getString("citysaved","Unknown")
        text.text=yuness
        val client= AsyncHttpClient()
        val url="https://api.weatherbit.io/v2.0/forecast/daily?city="+yuness+"&key=411bd85f099a492eacad855dff906f14"

        client.get(url,object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                super.onSuccess(statusCode, headers, response)
                val gson=Gson()
                val pray=gson.fromJson(response.toString(),Pop::class.java)
                textToday.text=pray.data[0].temp.toString()
                textsun.text=pray.data[1].temp.toString()
                textmon.text=pray.data[2].temp.toString()
                textTu.text=pray.data[3].temp.toString()
                textWe.text=pray.data[4].temp.toString()
                textThu.text=pray.data[5].temp.toString()
            }
            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
                println(throwable?.message)
            }
            })
        Button.setOnClickListener(View.OnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}