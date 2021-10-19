package com.example.myfragmentapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.task1.ItemsListActivity
import com.example.task2.AnimationActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_change_color).setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }

}

/*
参考代码
supportFragmentManager
    .beginTransaction()
    .add(R.id.fragmentPlaceholder, MyNewFragment.newInstance(Color.RED))
    .commit()

findViewById<Button>(R.id.btn_change_color).setOnClickListener {
    // 完成需求
    supportFragmentManager
        .beginTransaction()
        .addToBackStack(null)
        .replace(
            R.id.fragmentPlaceholder, MyNewFragment.newInstance(
                Color.rgb(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255)
                )
            )
        )
        .commit()
}
*/