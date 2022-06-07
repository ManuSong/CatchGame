package com.risingcamp.manu.gameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.risingcamp.manu.gameapp.databinding.ActivityReslutBinding

class ReslutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReslutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReslutBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_reslut)

        val resScroe = intent.getStringExtra("score")

        Log.d("testt", resScroe.toString())


    }
}