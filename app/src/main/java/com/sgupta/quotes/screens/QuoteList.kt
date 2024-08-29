package com.sgupta.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.sgupta.quotes.models.Quotes
import com.sgupta.quotes.models.QuotesItem

@Composable
fun QuoteList(quotes: Quotes, onClick:(quote: QuotesItem)->Unit) {
    LazyColumn(content = {
        items(quotes.quotes.size) {
            QuotesListItem(quote = quotes.quotes[it], onClick)
        }
    })
}
