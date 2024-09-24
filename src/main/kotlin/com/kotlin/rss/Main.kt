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
                println("${Thread.currentThread().name} while문 반복중")
                val channel = getChannel()
                latestFeeds = channel.toItemList()
                controller.showLatestFeeds(latestFeeds)
                delay(Duration.parse("5s"))
            }
        }
        launch(Dispatchers.IO) {
            println("${Thread.currentThread().name} 검색어 입력기다리는중")
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
