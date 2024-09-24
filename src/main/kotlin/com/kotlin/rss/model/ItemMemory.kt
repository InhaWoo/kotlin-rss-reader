package com.kotlin.rss.model

class ItemMemory(private val itemList: MutableList<Item> = mutableListOf()) : MutableList<Item> by itemList {
    val items get() = Items(itemList)
}