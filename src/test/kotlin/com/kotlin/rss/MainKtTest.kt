package com.kotlin.rss

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.xml.parsers.DocumentBuilderFactory


class MainKtTest {
    @Test
    fun `업데이트된 게시글이 존재한다`() {
        val factory = DocumentBuilderFactory.newInstance()
        val xml = factory.newDocumentBuilder()
            .parse("https://techblog.woowahan.com/feed")
        val channel = xml.getElementsByTagName("channel").item(0)
        println(channel.attributes.item(0))
        val itemList = channel.toItemList()

        assertThat(itemList).isNotEmpty
    }
}