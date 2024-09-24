package com.kotlin.rss.model

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

data class Item(val title: String, val link: String, val description: String, val pubDate: OffsetDateTime) {
    init {
        require(title.isNotBlank())
        require(link.isNotBlank())
        require(description.isNotBlank())
    }

    constructor(title: String, link: String, description: String, pubDateString: String?) : this(
        title, link, description, pubDateString?.let { OffsetDateTime.parse(it, DateTimeFormatter.RFC_1123_DATE_TIME) } ?: OffsetDateTime.MAX
    )
}
