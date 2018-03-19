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
                val intent= Intent(this@IndexActivity, ChapterActivity::class.java)
                intent.putExtra("index", index)
                startActivity(intent)

            }
        } )
        recylerView.adapter = indexAdapter
    }
}