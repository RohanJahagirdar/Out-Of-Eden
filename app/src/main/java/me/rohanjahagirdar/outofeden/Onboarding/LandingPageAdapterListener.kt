package me.rohanjahagirdar.outofeden.Onboarding

import android.support.v4.view.ViewPager

/**
 * Created by Rohan Jahagirdar on 12/22/2017.
 */


class LandingPageAdapterListener: ViewPager.SimpleOnPageChangeListener() {
    var currentPage: Int = 0

    override fun onPageSelected(position: Int) {
        currentPage = position
    }
    fun selectedPage():Int {
        return currentPage
    }
}