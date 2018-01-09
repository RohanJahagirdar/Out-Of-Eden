package me.rohanjahagirdar.outofeden.Chapter

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import me.rohanjahagirdar.outofeden.R

/**
 * Created by Rohan Jahagirdar on 12/7/2017.
 */

class ChapterCustomPagerAdapter(context: Context)  : PagerAdapter() {
    var mContext: Context = context
    var mLayoutInflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var mResources = intArrayOf(R.drawable.africa_1, R.drawable.africa_2, R.drawable.africa_3,
            R.drawable.africa_4, R.drawable.africa_5, R.drawable.africa_6, R.drawable.africa_7)

    override fun getCount(): Int {
        return mResources.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.chapter_pager_item, container, false)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(mResources[position])
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}