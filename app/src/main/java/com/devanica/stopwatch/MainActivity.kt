package com.devanica.stopwatch

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fromFloat = 0f
    var toFloat = 6f

    var minFromFloat = 0f
    var minToFloat = 6f

    var hourFromFloat = 0f
    var hourToFloat = 6f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animateSeconds(seconds, fromFloat, toFloat)
        animateMinutes(minutes, minFromFloat, minToFloat)
        animateHours(hours, hourFromFloat, hourToFloat)
    }

    private fun animateSeconds(view: ImageView, from: Float, to: Float) {
        val rotate = RotateAnimation(
            from,
            to,
            Animation.RELATIVE_TO_SELF,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            1.0f
        )
        rotate.duration = 1000
        rotate.fillAfter = true
        rotate.interpolator = LinearInterpolator()
        rotate.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                fromFloat = toFloat
                toFloat += 6f
                animateSeconds(seconds, fromFloat, toFloat)
            }
        })

        view.startAnimation(rotate)
    }

    private fun animateMinutes(view: ImageView, from: Float, to: Float) {
        val rotate = RotateAnimation(
            from,
            to,
            Animation.RELATIVE_TO_SELF,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            1.0f
        )
        rotate.duration = 60000
        rotate.fillAfter = true
        rotate.interpolator = LinearInterpolator()
        rotate.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                minFromFloat = minToFloat
                minToFloat += 6f
                animateSeconds(minutes, minFromFloat, minToFloat)
            }
        })

        view.startAnimation(rotate)
    }

    private fun animateHours(view: ImageView, from: Float, to: Float) {
        val rotate = RotateAnimation(
            from,
            to,
            Animation.RELATIVE_TO_SELF,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            1.0f
        )
        rotate.duration = 3600000
        rotate.fillAfter = true
        rotate.interpolator = LinearInterpolator()
        rotate.setAnimationListener(object : Animation.AnimationListener {

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                hourFromFloat = hourToFloat
                hourToFloat += 6f
                animateSeconds(hours, hourFromFloat, hourToFloat)
            }
        })

        view.startAnimation(rotate)
    }
}
