package com.kotlin.rss.controller

import com.kotlin.rss.model.Item
import com.kotlin.rss.model.Items
import com.kotlin.rss.view.RssInputView
import com.kotlin.rss.view.RssOutputView

class RssController(
    private val outputView: RssOutputView = RssOutputView(),
    private val inputView: RssInputView = RssInputView()
) {

    fun showLatestFeeds(latestFeeds: List<Item>) {
        outputView.printLatestFeed(Items(latestFeeds).page(10).items)
    }

    fun searchList(feeds: List<Item>) {
        outputView.printSearchMessage()
        val keyword = inputView.getInput()
        val items = Items(feeds).search(keyword).page(10).items
        outputView.printLatestFeed(items)
    }

}