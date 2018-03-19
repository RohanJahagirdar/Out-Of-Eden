package me.rohanjahagirdar.outofeden.Chapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import android.widget.Toast
import me.relex.circleindicator.CircleIndicator
import me.rohanjahagirdar.outofeden.Onboarding.CustomPagerAdapter
import me.rohanjahagirdar.outofeden.R
import me.rohanjahagirdar.outofeden.Utils.JSONParser
import org.json.JSONObject

class ChapterActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
        private lateinit var chapterDetailsJSON: JSONObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)
        val index:Int = intent.getIntExtra("index", -1)
        //Toast.makeText(this@ChapterActivity,"index: "+ index ,  Toast.LENGTH_SHORT).show()

        val mToolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(mToolbar)
       // val mCollapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        //mCollapsingToolbarLayout.setTitleEnabled(false)
        chapterDetailsJSON = JSONObject()
        chapterDetailsJSON.put("valid",false)
        loadChapterDetails(index)

        println(chapterDetailsJSON)

        if(chapterDetailsJSON.getBoolean("valid")) {
            val chapter_name_textview = findViewById<TextView>(R.id.chapter_name)
            val chapter_title_textview = findViewById<TextView>(R.id.chapter_title)
            val chapter_details_textview = findViewById<TextView>(R.id.chapter_details)
            val chapter_subtitle_textview = findViewById<TextView>(R.id.chapter_sub_title)
            val chapter_date_textview = findViewById<TextView>(R.id.chapter_date)

            chapter_name_textview.setText(chapterDetailsJSON.getString("name"))
            chapter_title_textview.setText(chapterDetailsJSON.getString("title"))
            chapter_details_textview.setText(chapterDetailsJSON.getString("detail"))
            chapter_subtitle_textview.setText(chapterDetailsJSON.getString("sub_title"))
            chapter_date_textview.setText(chapterDetailsJSON.getString("date"))

        }
        mToolbar.setTitle("title")

    }


    fun loadChapterDetails(index: Int) {
        val json = JSONParser(this).parseJSON()
        if(json.has("version")) {
            val walk = json.getJSONArray("walk")
            chapterDetailsJSON = walk.getJSONObject(index)
            chapterDetailsJSON.put("valid",true)
        }
    }
}