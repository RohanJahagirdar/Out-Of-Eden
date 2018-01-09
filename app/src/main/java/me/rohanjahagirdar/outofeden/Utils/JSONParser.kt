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
class JSONParser(c: Context) {
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

/*    try {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray m_jArry = obj.getJSONArray("formules");
        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> m_li;

        for (int i = 0; i < m_jArry.length(); i++) {
            JSONObject jo_inside = m_jArry.getJSONObject(i);
            Log.d("Details-->", jo_inside.getString("formule"));
            String formula_value = jo_inside.getString("formule");
            String url_value = jo_inside.getString("url");

            //Add your values in your `ArrayList` as below:
            m_li = new HashMap<String, String>();
            m_li.put("formule", formula_value);
            m_li.put("url", url_value);

            formList.add(m_li);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }*/
}