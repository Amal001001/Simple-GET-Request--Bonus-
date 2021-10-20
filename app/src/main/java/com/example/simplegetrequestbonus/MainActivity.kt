package com.example.simplegetrequestbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv =findViewById(R.id.tv)

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<ArrayList<people.peopleItem>?>? = apiInterface!!.getNames()

        call?.enqueue(object : Callback<ArrayList<people.peopleItem>?> {
            override fun onResponse(call: Call<ArrayList<people.peopleItem>?>?, response: Response<ArrayList<people.peopleItem>?>) {
                Log.d("TAG", "onResponse")
                var displayResponse = ""
                val resource: ArrayList<people.peopleItem>? = response.body()
                val peopleItems = resource

                for (people in peopleItems!!) {
                    displayResponse += "${people.name}\n"
                }
                tv.text = displayResponse
            }

            override fun onFailure(call: Call<ArrayList<people.peopleItem>?>, t: Throwable?) {
                call.cancel()
                Log.d("TAG", "onFailure")
            }
        })
    }
}