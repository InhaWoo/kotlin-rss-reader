package com.kotlin.rss.view.dto

import com.kotlin.rss.model.Item

data class LatestFeedsDto(val title: String, val link: String) {
    fun toItemString(): String {
        return "title : $title, link : $link"
    }
}