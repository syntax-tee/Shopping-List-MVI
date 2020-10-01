package com.zizohanto.android.tobuy.data.models

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*

data class ShoppingListEntity(
    val id: String,
    val name: String,
    val budget: Double,
    val dateCreated: String,
    val dateModified: String
) {
    companion object {
        fun createNewShoppingList(): ShoppingListEntity {
            val shoppingListId: String = UUID.randomUUID().toString()
            val formattedDate: String = getCurrentTime()
            return ShoppingListEntity(
                shoppingListId,
                "",
                0.0,
                formattedDate,
                formattedDate
            )

        }

        private fun getCurrentTime(): String {
            val fmt: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val date: LocalDate = LocalDate.now()
            return date.toString(fmt)
        }
    }
}