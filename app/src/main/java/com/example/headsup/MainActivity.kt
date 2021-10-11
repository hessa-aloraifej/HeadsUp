package com.example.headsup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var mainRV: RecyclerView
    lateinit var list2: List<HeadsUpDetailsItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainRV = findViewById(R.id.rvMain)
        val addbtn = findViewById<Button>(R.id.addbtn)
        val submitbtn = findViewById<Button>(R.id.submit)
        val search = findViewById<EditText>(R.id.tvsearch)

        submitbtn.setOnClickListener {
            var founded :HeadsUpDetailsItem?=null
            val searchtext = search.text.toString()
            for (i in list2) {
                if (searchtext==i.name){
                    founded=i
                    break
                }
            }


            if (founded!=null) {

                val intent = Intent(this, UpdateDelet::class.java)

                intent.putStringArrayListExtra("data", arrayListOf(founded.pk.toString(),founded.name,founded.taboo1,founded.taboo2,founded.taboo3))
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Sorry , Its Not Found. Go To Add A New One ",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, AddMore::class.java)
                startActivity(intent)
            }

        }
        addbtn.setOnClickListener {

            val intent = Intent(this, AddMore::class.java)
            startActivity(intent)
        }
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface!!.getUsers().enqueue(object : Callback<List<HeadsUpDetailsItem>> {


            override fun onFailure(call: Call<List<HeadsUpDetailsItem>>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(
                call: Call<List<HeadsUpDetailsItem>>,
                response: retrofit2.Response<List<HeadsUpDetailsItem>>
            ) {
                val list = response.body()!!
                updateView(list)

            }
        })
    }


    private fun updateView(list: List<HeadsUpDetailsItem>) {
        list2 = list
        mainRV.adapter = HeadsUPRVAdapter(list)
        mainRV.layoutManager = LinearLayoutManager(this)
    }
}



