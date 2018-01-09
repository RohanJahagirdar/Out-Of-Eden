package me.rohanjahagirdar.outofeden.Onboarding

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.rohanjahagirdar.outofeden.R
import me.rohanjahagirdar.outofeden.Utils.JSONParser

/**
 * Created by Rohan Jahagirdar on 06-01-2018.
 */


class IndexAdapter(val context: Context, val listener: RecyclerViewClickListener) : RecyclerView.Adapter<IndexAdapter.ChapterViewHolder>() {
    lateinit var index: Array<String>
    lateinit var images: Array<String>

    companion object {
        var recyclerViewClickListener: RecyclerViewClickListener? = null
    }

    var names = ArrayList<String>()
    var titles = ArrayList<String>()
    var dates = ArrayList<String>()
    var details = ArrayList<String>()
    var locations = ArrayList<String>()
    var sub_titles = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.index_item, parent, false)
        return ChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder?, position: Int) {
        recyclerViewClickListener = listener

        holder?.itemView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                recyclerViewClickListener?.onClick(position)
            }
        })


        if(position == 0) {
            holder?.chapterTitle?.setText(titles.get(position))
            holder?.chapterName?.setText(names.get(position))
            holder?.chapterDetail?.setText(details.get(position))
            holder?.chapterDate?.visibility = View.INVISIBLE
            var id = context.getResources().getIdentifier(images[position], "drawable", context.getPackageName())
            //holder?.chapterImage?.setImageResource(id)

            Picasso.with(context).load(id).into(holder?.chapterImage)


        } else {
            holder?.chapterTitle?.setText(titles.get(position))
            holder?.chapterName?.setText(names.get(position))
            holder?.chapterDetail?.setText(details.get(position))
            holder?.chapterDate?.setText(dates.get(position))
            var id = context.getResources().getIdentifier(images[position], "drawable", context.getPackageName())
            //holder?.chapterImage?.setImageResource(id)
            Picasso.with(context).load(id).into(holder?.chapterImage)
        }
    }

    override fun getItemCount(): Int {
        return index.size
    }

    class ChapterViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{
        private var view: View = v
        lateinit var card: CardView
        lateinit var chapterName: TextView
        lateinit var chapterDate: TextView
        lateinit var chapterImage: ImageView
        lateinit var chapterTitle: TextView
        lateinit var chapterDetail: TextView
        var index = position

        init{

            v.setOnClickListener(this)
            chapterName = v.findViewById(R.id.chapter_name)
            chapterTitle = v.findViewById(R.id.chapter_title)
            chapterDate = v.findViewById(R.id.chapter_date)
            chapterImage = v.findViewById(R.id.chapter_image)
            chapterDetail = v.findViewById(R.id.chapter_details)
        }

        override fun onClick(p0: View?) {
            println("On Click!!")
        }

    }

    init {
        index = context.applicationContext.resources.getStringArray(R.array.chapters)
        images = context.applicationContext.resources.getStringArray(R.array.chapter_drawables)
        val json = JSONParser(context).parseJSON()
        if(json.has("version")) {
            val walk = json.getJSONArray("walk")
            for(i in 0..(walk.length() - 1)) {
                val chapter = walk.getJSONObject(i)
                names.add(chapter.getString("name"))
                titles.add(chapter.getString("title"))
                details.add(chapter.getString("detail"))
                dates.add(chapter.getString("date"))
                sub_titles.add(chapter.getString("sub_title"))
            }
        }
    }
}