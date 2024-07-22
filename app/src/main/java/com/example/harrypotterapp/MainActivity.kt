package com.example.harrypotterapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter : MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val items = mutableListOf<character>()



        val apiService = RetrofitInstance.instance

        apiService.getCharacter().enqueue(
            object :Callback<List<character>>{
                override fun onResponse(
                    call: Call<List<character>>,
                    response: Response<List<character>>
                ) {
                    val character = response.body()
                    Log.d("onResponse", "onResponse: ${character.toString()}")
                    if (character != null) {
                        character.forEach {
                          val item = character(it.fullName,it.image)
                            items.add(item)

                        }
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<character>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_SHORT).show()
                }

            }

        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
         adapter = MainAdapter(items,this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}