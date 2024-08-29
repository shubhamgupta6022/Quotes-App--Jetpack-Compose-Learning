package com.sgupta.quotes.models

data class Quotes(
    val quotes: List<QuotesItem>,
)

data class QuotesItem(
    val quote: String,
    val author: String,
)
