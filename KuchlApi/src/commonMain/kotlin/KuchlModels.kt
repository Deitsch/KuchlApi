package io.github.kotlin.fibonacci

import kotlinx.serialization.Serializable

@Serializable
data class MenuWeek(
    val kw: String,
    val cat: List<Category>,
    val menues: List<MenuDay>
)

@Serializable
data class Category(
    val id: Int,
    val name: String,
    val price: Int,
    val guestprice: Int,
    val desc: String
)

@Serializable
data class MenuDay(
    val day: String,
    val dishes: List<Dish>
)

@Serializable
data class Dish(
    val name: String,
    val kj: Int,
    val kcal: Int,
    val rating: Double,
    val cat: Int,
    val foodTypes: List<String>
)