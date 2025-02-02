package com.kaspersky.kaspresso.tutorials.simple

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kaspersky.kaspresso.tutorials.R
import kotlinx.android.synthetic.main.activity_simple.*
import java.util.concurrent.Executors

class SimpleActivity : AppCompatActivity() {

    companion object {
        private const val TIMEOUT: Long = 2000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
    }

    override fun onResume() {
        super.onResume()
        button_1.setOnClickListener {
            button_2.visibility = View.VISIBLE
        }
        button_2.setOnClickListener {
            // special sleep to emulate ui block operation to check attempt method correctness
            Executors.newSingleThreadExecutor().submit {
                Thread.sleep(TIMEOUT)
                runOnUiThread { edit.visibility = View.VISIBLE }
            }
        }
    }
}
