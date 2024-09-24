package com.kotlin.rss

import com.kotlin.rss.controller.RssController
import com.kotlin.rss.model.Item
import kotlinx.coroutines.*
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.time.Duration

fun main() {
    runBlocking {
        val controller = RssController()
        var latestFeeds: List<Item> = listOf()
        launch {
            while (true) {
                val channel = getChannel()
                latestFeeds = channel.toItemList()
                controller.showLatestFeeds(latestFeeds)
                delay(Duration.parse("10m"))
            }
        }
        launch {
            controller.searchList(latestFeeds)
        }
    }
}

fun getChannel(): Node {
        val factory = DocumentBuilderFactory.newInstance()
        val xml = factory.newDocumentBuilder()
            .parse("https://techblog.woowahan.com/feed")
        return xml.getElementsByTagName("channel").item(0)
}
