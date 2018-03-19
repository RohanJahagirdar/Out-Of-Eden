package me.rohanjahagirdar.outofeden.Onboarding

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import me.rohanjahagirdar.outofeden.Chapter.ChapterActivity
import me.rohanjahagirdar.outofeden.Networking.OkHttpRequest
import me.rohanjahagirdar.outofeden.R
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class IndexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val recylerView = findViewById<RecyclerView>(R.id.index_recycler_view)

        recylerView.layoutManager = LinearLayoutManager(this)

        val indexAdapter = IndexAdapter(this, object: RecyclerViewClickListener {
            override fun onClick(index: Int) {
                getDetails(index)

            }
        } )
        recylerView.adapter = indexAdapter
    }

    fun getDetails(index: Int) {
        var client = OkHttpClient()
        var request= OkHttpRequest(client)
        val url = getResources().getString(R.string.chapter_url) + "?chapter=" + index

        request.GET(url, object: Callback {
            override fun onResponse(call: Call?, response: Response) {
                val responseData = response.body()?.string()
                runOnUiThread{
                    try {
                        var jsonObject = JSONObject(responseData)
                        println("SUCCESS - " + jsonObject)
                        val intent= Intent(this@IndexActivity, ChapterActivity::class.java)
                        intent.putExtra("index", index)
                        startActivity(intent)
                    } catch (e: JSONException) {
                            e.printStackTrace()

                    }
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Activity Failure.")
            }
        })
    }
}