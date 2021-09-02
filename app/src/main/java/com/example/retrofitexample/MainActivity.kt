package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var find: Button
    lateinit var number : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        find = findViewById(R.id.find)
        number = findViewById(R.id.number)

        find.setOnClickListener {
            Toast.makeText(applicationContext,number.text.toString(),Toast.LENGTH_SHORT).show()

            val quoteApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

            GlobalScope.launch {
                val result = quoteApi.getQuotes( number.text.toString().toInt())
                if(result != null){
                    Log.d("freeKnowledge",result.body().toString())
                }
            }
        }



    }
}