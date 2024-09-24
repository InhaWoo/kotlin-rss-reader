package com.kotlin.rss

import com.kotlin.rss.controller.RssController
import com.kotlin.rss.model.Item
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    val factory = DocumentBuilderFactory.newInstance()
    val xml = factory.newDocumentBuilder()
        .parse("https://techblog.woowahan.com/feed")
    val channel = xml.getElementsByTagName("channel").item(0)
    val controller = RssController()

    val latestFeeds = channel.toItemList()

    controller.showLatestFeeds(latestFeeds)
}
