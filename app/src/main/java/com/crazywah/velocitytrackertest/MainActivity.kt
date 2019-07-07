package com.crazywah.velocitytrackertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private val TAG : String = "AppCompatActivity"
    }

    private var velocityTrack: VelocityTracker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cl_background?.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (velocityTrack == null) {
                    velocityTrack = VelocityTracker.obtain()
                }
                velocityTrack?.addMovement(p1)
                when (p1?.action) {
                    MotionEvent.ACTION_DOWN -> {
                    }
                    MotionEvent.ACTION_MOVE -> {
                        // 时间单位(1: X像素每毫秒，1000：X像素每秒)
                        velocityTrack?.computeCurrentVelocity(1)
                    }
                    MotionEvent.ACTION_UP ,
                    MotionEvent.ACTION_CANCEL -> {
//                        Log.d(TAG," vX = ${velocityTrack?.getXVelocity()}")
//                        Log.d(TAG," vY = ${velocityTrack?.getYVelocity()}")
                        velocityTrack?.recycle()
                        velocityTrack = null
                    }
                    else -> {

                    }
                }
                return true
            }

        })
    }
}
