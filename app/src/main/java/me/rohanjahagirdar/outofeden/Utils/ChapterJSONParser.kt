package me.rohanjahagirdar.outofeden.Utils

import android.R
import android.app.PendingIntent.getActivity
import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

/**
 * Created by Rohan Jahagirdar on 07-01-2018.
 */
class ChapterJSONParser(c: Context) {
    var context = c

    fun loadJSONFromAsset(): String {
        var json = null
        try{
            var inputStream = context.assets.open("walkofeden.json")
            var size = inputStream.available()
            var buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer, Charset.forName("UTF-8"))
        } catch(ex: IOException) {
            return ""
        }
    }


    fun parseJSON() : JSONObject{
        try {
            var obj = JSONObject(loadJSONFromAsset())
            return obj
        } catch(e: JSONException) {
            var obj = JSONObject()
            return obj
        }
    }
}