package com.kotlin.rss.model

class ItemMemory(private val itemList: MutableList<Item> = mutableListOf()) : MutableList<Item> by itemList {
    val items get() = Items(itemList)

    override fun add(element: Item): Boolean {
        if (!itemList.contains(element))
            return itemList.add(element)
        return false // return false if item is not added
    }

    override fun addAll(elements: Collection<Item>): Boolean {
        return itemList.addAll(elements.filter { !itemList.contains(it) })
    }
}