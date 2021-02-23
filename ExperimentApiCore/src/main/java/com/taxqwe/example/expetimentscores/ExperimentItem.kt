package com.taxqwe.example.expetimentscores

data class ExperimentItem(
    val shortDescription: String,
    val fullDescription: String,
    val experiment: () -> Unit
)