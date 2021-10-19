package com.example.myfragmentapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val COLOR = "color"

class MyNewFragment : Fragment() {

    private var color: Int = Color.BLUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            color = it.getInt(COLOR)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_my_new, container, false)

        rootView.findViewById<TextView>(R.id.my_fragment_id).setTextColor(color)

        return rootView
    }

    companion object {

        @JvmStatic
        fun newInstance(color: Int) =
            MyNewFragment().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }

    }
}