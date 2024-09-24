package com.kotlin.rss.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class ItemMemoryTest {


    @Test
    fun `아이템을 추가한다`() {
        val itemMemory = ItemMemory()
        val item = Item("title", "link", "description", OffsetDateTime.now())

        itemMemory += item

        assertThat(itemMemory.items).isEqualTo(Items(listOf(item)))
    }

    @Test
    fun `아이템 리스트를 추가한다`() {
        val itemMemory = ItemMemory()
        val items = Items(listOf(Item("title", "link", "description", OffsetDateTime.now())))

        itemMemory.addAll(items)

        assertThat(itemMemory.items).isEqualTo(items)
    }

    @Test
    fun `중복된 아이템은 추가되지 않는다`() {
        val item = Item("title", "link", "description", OffsetDateTime.now())
        val itemMemory = ItemMemory(mutableListOf(item))

        itemMemory.add(item)

        assertThat(itemMemory.items).hasSize(1)
    }

    @Test
    fun `중복된 아이템들은 추가되지 않는다`() {
        val item = Item("title", "link", "description", OffsetDateTime.now())
        val itemMemory = ItemMemory(mutableListOf(item))
        val items = Items(listOf(item))

        itemMemory.addAll(items)

        assertThat(itemMemory.items).hasSize(1)
    }
}