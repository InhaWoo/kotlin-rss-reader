package com.kotlin.rss.controller

import com.kotlin.rss.model.Item
import com.kotlin.rss.view.RssOutputView

class RssController(private val outputView: RssOutputView = RssOutputView()) {

    fun showLatestFeeds(latestFeeds: List<Item>) {
        outputView.printLatestFeed(latestFeeds)
    }

}