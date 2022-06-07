package com.risingcamp.manu.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.risingcamp.manu.gameapp.databinding.ActivityGameBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler(Looper.getMainLooper())
    var runnable : Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = 0

        imageArray = arrayListOf(binding.chacImg1, binding.chacImg2, binding.chacImg3, binding.chacImg4, binding.chacImg5, binding.chacImg6, binding.chacImg7, binding.chacImg8, binding.chacImg9)

        hideImages()


            object : CountDownTimer(10000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.timeText.text = "Time : " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                    binding.timeText.text = "Time Over"
                    handler.removeCallbacks(runnable)
                    for (image in imageArray) {
                        image.visibility = View.INVISIBLE
                    }
                    val intent = Intent(this@GameActivity, ReslutActivity::class.java)
                    startActivity(intent)
                }


            }.start()




        for (images in imageArray) {
            images.setOnClickListener {
                increaseScore(binding.scoreText)
            }
        }



    }

    fun hideImages() {
        runnable = object : Runnable{
            override fun run() {

                for (images in imageArray) {
                    images.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(8 - 0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable, 500)

            }

        }
        handler.post(runnable)
    }

    fun increaseScore(view : View){
        score++

        binding.scoreText.text = "Score : " + score
        intent.putExtra("score", binding.scoreText.text)

    }
}