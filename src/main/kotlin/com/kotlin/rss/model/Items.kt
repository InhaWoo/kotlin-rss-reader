package com.kotlin.rss.model

data class Items(val items: List<Item>) {
    fun search(keyword: String): Items {
        return Items(
            items.filter { it.title.contains(keyword) }
        )
    }

    fun page(size: Int): Items {
        return Items(
            items.sortedByDescending { it.pubDate }
            .take(size))
    }
}