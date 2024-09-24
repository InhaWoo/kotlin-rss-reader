package com.kotlin.rss.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class ItemsTest {
    @Test
    fun `단어를 입력하면 해당 단어가 포함된 게시물을 반환한다`() {
        val items = Items(
            listOf(
            Item("robot", "link", "robot", OffsetDateTime.MAX),
            Item("ai", "link2", "ai", OffsetDateTime.MAX)
            )
        )

        val actual = items.search("robot")

        assertThat(actual).isEqualTo(Items(listOf(Item("robot", "link", "robot", OffsetDateTime.MAX))))
    }
}