package com.kotlin.rss.view

import com.kotlin.rss.model.Item
import com.kotlin.rss.view.dto.LatestFeedsDto

class RssOutputView {
    fun printLatestFeed(latestFeeds: List<Item>) {
        val feedsDto = latestFeeds
            .map { LatestFeedsDto(it.title, it.link).toItemString() }
            .joinToString(separator = "\n")
        println(feedsDto)
    }

    fun printSearchMessage() {
        println("검색어를 입력하세요")
    }

}