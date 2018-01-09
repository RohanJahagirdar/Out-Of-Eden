package me.rohanjahagirdar.outofeden.Onboarding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import me.relex.circleindicator.CircleIndicator
import me.rohanjahagirdar.outofeden.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = CustomPagerAdapter(this)

        val circleIndicator = findViewById<CircleIndicator>(R.id.indicator)
        circleIndicator.setViewPager(viewPager)
    }
}
