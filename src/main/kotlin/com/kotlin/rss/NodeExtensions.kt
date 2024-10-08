package com.kotlin.rss

import com.kotlin.rss.model.Item
import org.w3c.dom.Node
import java.time.OffsetDateTime

fun Node.toItemList() : List<Item> {
    val childNodes = this.childNodes

    return (0..< childNodes.length).map {childNodes.item(it)} .filter { it.nodeName == "item" }
        .map {
            Item(
                it.getChildNodeValue("title")?: "",
                it.getChildNodeValue("link")?: "",
                it.getChildNodeValue("description")?: "",
                it.getChildNodeValue("pubDate")
            )
        }
}

fun Node.getChildNodeValue(nodeName: String): String? {
    val children = this.childNodes
    for (i in 0 until children.length) {
        val child = children.item(i)
        if (child.nodeName == nodeName) {
            return child.textContent // Return the text content of the node
        }
    }
    return null // Return null if the node is not found
}
