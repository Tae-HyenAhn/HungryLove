package me.hungrylove.hungryloveproject.kotlin

import android.content.Context
import android.content.res.AssetManager
import android.util.Log

import org.json.JSONArray
import org.json.JSONException

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList

import me.hungrylove.hungryloveproject.Book

/**
 * Created by Taehyen on 2017-05-29.
 */

object BookJsonParser {

    fun bookJsonParse(context: Context, list: ArrayList<Book>) {

        val assetManager = context.resources.assets

        try {
            val ais = assetManager.open("json/hungry_love01.json") as AssetManager.AssetInputStream
            val br = BufferedReader(InputStreamReader(ais))

            val sb:StringBuilder = StringBuilder()
            var str:String? = ""

            //while({str = br.readLine()}() != null){   //always true condition
            while(str != null){
                str = br.readLine()
                sb.append(str)
            }

            val res = sb.toString()
            Log.d("TAG", res)
            try {
                val jarray = JSONArray(res)
                for (i in 0..jarray.length() - 1) {
                    val jObject = jarray.getJSONObject(i)

                    list.add(Book(jObject.getInt("page_num"), jObject.getString("boo_title"),
                            jObject.getString("author"), jObject.getString("intro"), jObject.getString("title"), jObject.getString("content")))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

}
