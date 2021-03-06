package com.example.task1

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

class ItemsListFragment : Fragment() {
    private var adapterItems: ArrayAdapter<Item>? = null
    private var lvItems: ListView? = null
    private var listener: OnItemSelectedListener? = null

    interface OnItemSelectedListener {
        fun onItemSelected(i: Item?)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        listener =
            if (activity is OnItemSelectedListener) {
                activity
            } else {
                throw ClassCastException(
                    activity.toString()
                            + " must implement ItemsListFragment.OnItemSelectedListener"
                )
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create arraylist from item fixtures
        val items = Item.items
        adapterItems = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_activated_1, items
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view
        val view = inflater.inflate(
            R.layout.fragment_items_list, container,
            false
        )
        // Bind adapter to ListView
        lvItems = view.findViewById<View>(R.id.lvItems) as ListView
        lvItems!!.adapter = adapterItems
        lvItems!!.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, item, position, rowId -> // Retrieve item based on position
                val i = adapterItems!!.getItem(position)
                // Fire selected event for item
                listener!!.onItemSelected(i)
            }
        return view
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    fun setActivateOnItemClick(activateOnItemClick: Boolean) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        lvItems!!.choiceMode =
            if (activateOnItemClick) ListView.CHOICE_MODE_SINGLE else ListView.CHOICE_MODE_NONE
    }
}