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

class UpdateDelet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delet)
        val backbtn=findViewById<Button>(R.id.backbtn2)
        val editTextName = findViewById<EditText>(R.id.etName1)
        val editTextTaboo1 = findViewById<EditText>(R.id.etTaboo11)
        val editTextTaboo2 = findViewById<EditText>(R.id.etTaboo22)
        val editTextTaboo3 = findViewById<EditText>(R.id.etTaboo33)
        val delbtn=findViewById<Button>(R.id.delbtn)
        val updatebtn=findViewById<Button>(R.id.updatebtn)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        val data =intent.extras?.getStringArrayList("data")
        if(data!=null){
            editTextName.setText(data[1])
            editTextTaboo1.setText(data[2])
            editTextTaboo2.setText(data[3])
            editTextTaboo3.setText(data[4])
        }
        else{
            Toast.makeText(this, "Sorry null", Toast.LENGTH_SHORT).show()
        }

        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        delbtn.setOnClickListener {



            apiInterface!!.deleteUser(data!![0].toInt()).enqueue(object: Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "The User Has Been Deleted Successfully!!", Toast.LENGTH_SHORT).show()

                    move()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,The User Has Not Been Deleted Successfully!!", Toast.LENGTH_SHORT).show()
                }

            })
        }

        updatebtn.setOnClickListener {
            val pk= data!![0].toInt()
            val name = editTextName.text.toString()
            val taboo1 = editTextTaboo1.text.toString()
            val taboo2 = editTextTaboo2.text.toString()
            val taboo3 = editTextTaboo3.text.toString()
            apiInterface!!.updateUser(pk,HeadsUpDetailsItem(name,pk,taboo1,taboo2,taboo3)).enqueue(object:
                Callback<HeadsUpDetailsItem>
            {
                override fun onResponse(call: Call<HeadsUpDetailsItem>, response: Response<HeadsUpDetailsItem>) {
                    Toast.makeText(applicationContext, "The User Has Been pdated Successfully!!", Toast.LENGTH_SHORT).show()
                    move()


                }

                override fun onFailure(call: Call<HeadsUpDetailsItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,The User Has Not Been Updated Successfully!!", Toast.LENGTH_SHORT).show()
                }

            })

        }

        }

    fun move(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}














