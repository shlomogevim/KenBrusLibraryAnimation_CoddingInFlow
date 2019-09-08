package com.example.kenbruslibraryanimation_coddinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import com.flaviofaria.kenburnsview.KenBurnsView
import com.flaviofaria.kenburnsview.KenBurnsView.TransitionListener
import com.flaviofaria.kenburnsview.RandomTransitionGenerator
import com.flaviofaria.kenburnsview.Transition
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var moving = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adi=AccelerateDecelerateInterpolator()
        val generator=RandomTransitionGenerator(5000,adi)
        kbv.setTransitionGenerator(generator)


        kbv.setOnClickListener {
            if (moving) {
                kbv.pause()
                moving = false
            } else {
                kbv.resume()
                moving = true
            }
        }
        kbv.setTransitionListener(object : KenBurnsView.TransitionListener {
            override fun onTransitionEnd(transition: Transition?) {
               // Toast.makeText(this@MainActivity, "Transition Start", Toast.LENGTH_LONG).show()
            }

            override fun onTransitionStart(transition: Transition?) {
               // Toast.makeText(this@MainActivity, "Transition Stop", Toast.LENGTH_LONG).show()
            }

        })
    }
}
