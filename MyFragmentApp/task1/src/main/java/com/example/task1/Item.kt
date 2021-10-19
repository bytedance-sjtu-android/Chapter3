package com.example.task1

import java.io.Serializable
import java.util.ArrayList

class Item(val title: String, val body: String) : Serializable {

    override fun toString(): String {
        return title
    }

    companion object {

        private const val serialVersionUID = -6099312954099962806L

        val items: ArrayList<Item>
            get() {
                val items = ArrayList<Item>()
                items.add(Item("位置", "查看位置详情"))
                items.add(Item("隐私", "查看隐私详情"))
                items.add(Item("权限设置", "查看权限设置"))
                return items
            }
    }

}