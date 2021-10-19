package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val item = findViewById<Button>(R.id.my_item)
        val cart = findViewById<TextView>(R.id.cart)
        val cartWrapper = findViewById<LinearLayout>(R.id.cart_wrapper)

        item.setOnClickListener {
            // 实现动画
        }
    }

}


/**
 参考代码
 val startX = item.x
 val startY = item.y
 val endX = cart_wrapper.x + cart.x
 val endY = cart_wrapper.y + cart.y
 Log.i("tagg", "$startX,$startY,$endX,$endY")
 val valueAnimator = ValueAnimator.ofFloat(0f, 1f)
 valueAnimator.addUpdateListener {
 item.x = yTypeEvaluator.evaluate(it.animatedValue as Float, startX, endX)
 item.y = yTypeEvaluator.evaluate(yInterpolator.getInterpolation(it.animatedValue as Float), startY, endY)
 item.alpha = yTypeEvaluator.evaluate(yInterpolator.getInterpolation(it.animatedValue as Float), 1f, 0f)
 item.scaleX = yTypeEvaluator.evaluate(acc.getInterpolation(yInterpolator.getInterpolation(it.animatedValue as Float)), 1f, 0f)
 item.scaleY = yTypeEvaluator.evaluate(acc.getInterpolation(yInterpolator.getInterpolation(it.animatedValue as Float)), 1f, 0f)
 Log.i("tagg", yTypeEvaluator.evaluate(startX, endX,  it.animatedValue as Float).toString())
 }
 valueAnimator.duration = 1000
 valueAnimator.start()
 **/