package me.rohanjahagirdar.outofeden.Chapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import me.relex.circleindicator.CircleIndicator
import me.rohanjahagirdar.outofeden.Onboarding.CustomPagerAdapter
import me.rohanjahagirdar.outofeden.R

class ChapterActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        val viewPager = findViewById<ViewPager>(R.id.appBarViewPager)
        viewPager.adapter = ChapterCustomPagerAdapter(this)

        val circleIndicator = findViewById<CircleIndicator>(R.id.indicator)
        circleIndicator.setViewPager(viewPager)

        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mToolbar)
       // val mCollapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        //mCollapsingToolbarLayout.setTitleEnabled(false)

        //mToolbar.setTitle("title")

    }
}