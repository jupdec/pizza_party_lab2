package com.example.pizzaparty

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * PizzaCalculator: responsible for calculating the number of pizzas required
 * @property partySize denotes No.of people to be considered for pizza
 * @property hungerLevel denotes how hungry level of person
 */
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}