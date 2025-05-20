package io.github.kotlin.fibonacci

data class MenuWeek(
    val kw: String,
    val cat: List<Category>,
    val menues: List<MenuDay>
)

data class Category(
    val id: Int,
    val name: String,
    val price: Int,
    val guestprice: Int,
    val desc: String
)

data class MenuDay(
    val day: String,
    val dishes: List<Dish>
)

data class Dish(
    val name: String,
    val kj: Int,
    val kcal: Int,
    val rating: Double,
    val cat: Int,
    val foodTypes: List<String>
)
