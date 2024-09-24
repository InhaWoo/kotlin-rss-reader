package com.kotlin.rss.view

import com.kotlin.rss.model.Item
import com.kotlin.rss.view.dto.LatestFeedsDto
import java.io.File.separator

class RssOutputView {
    fun printLatestFeed(latestFeeds: List<Item>) {
        val feedsDto = latestFeeds
            .sortedByDescending { it.pubDate }
            .take(10)
            .map { LatestFeedsDto(it.title, it.link).toItemString() }
            .joinToString(separator = "\n")

        println(feedsDto)
    }

}