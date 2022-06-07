package com.risingcamp.manu.gameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.risingcamp.manu.gameapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.gameStartBtn.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, GameActivity::class.java)
                )
            }
        }

        binding.howtoBtn.apply {
            setOnClickListener {

                val mDialogView = LayoutInflater.from(this@MainActivity).inflate(R.layout.howto_dialog, null)
                val mBuilder = AlertDialog.Builder(this@MainActivity).setView(mDialogView)

                val mAlertDialog = mBuilder.show()


                val okBtn = mDialogView.findViewById<Button>(R.id.howto_ok_btn)
                okBtn.setOnClickListener {
                    mAlertDialog.dismiss()
                }

            }
        }
    }
}