package me.rohanjahagirdar.outofeden.Onboarding

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import me.rohanjahagirdar.outofeden.R

/**
 * Created by Rohan Jahagirdar on 12/7/2017.
 */

class CustomPagerAdapter( context: Context)  : PagerAdapter() {
    var mContext: Context = context
    var mLayoutInflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var mResources = intArrayOf(R.drawable.walk_1, R.drawable.walk_2, R.drawable.walk_3)

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if(position < 2) {
            val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            val walkButton = itemView.findViewById<Button>(R.id.walkButton)
            walkButton.visibility = View.INVISIBLE
            imageView.setImageResource(mResources[position])
            container.addView(itemView)
            return itemView
        } else {
            val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            val walkButton = itemView.findViewById<Button>(R.id.walkButton)
            walkButton.visibility = View.VISIBLE
            imageView.setImageResource(mResources[position])
            container.addView(itemView)
            walkButton.setOnClickListener(View.OnClickListener {
                val intent = Intent(mContext, IndexActivity::class.java)
                mContext.startActivity(intent)
            })

            return itemView
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}