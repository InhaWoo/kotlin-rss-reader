package com.kotlin.rss.model

data class Items(val items: List<Item>) {
    fun search(keyword: String): Items {
        return Items(
            items.filter { it.title.contains(keyword) }
        )
    }
}