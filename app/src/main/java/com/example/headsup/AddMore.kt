package com.example.headsup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddMore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_more)
        val editTextName = findViewById<EditText>(R.id.etName)
        val editTextTaboo1 = findViewById<EditText>(R.id.edTaboo1)
        val editTextTaboo2 = findViewById<EditText>(R.id.etTaboo2)
        val editTextTaboo3 = findViewById<EditText>(R.id.etTaboo3)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val addbtn=findViewById<Button>(R.id.addbtn2)
        val backbtn=findViewById<Button>(R.id.backbtn)
        addbtn.setOnClickListener {
            val pk=1
            val name =editTextName.text.toString()
            val taboo1=editTextTaboo1.text.toString()
            val taboo2=editTextTaboo2.text.toString()
            val taboo3=editTextTaboo3.text.toString()


            apiInterface!!.addUsers(HeadsUpDetailsItem(name,pk,taboo1,taboo2,taboo3)).enqueue(object:
                Callback<HeadsUpDetailsItem> {
                override fun onResponse(
                    call: Call<HeadsUpDetailsItem>,
                    response: Response<HeadsUpDetailsItem>
                ) {
                    Toast.makeText(applicationContext, "It Has Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<HeadsUpDetailsItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,It Has Not Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

            }
            )

        }
        backbtn.setOnClickListener {  val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

    }
}



