package com.sgupta.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.sgupta.quotes.constants.Pages
import com.sgupta.quotes.models.Quotes
import com.sgupta.quotes.screens.QuotesDetail
import com.sgupta.quotes.screens.QuotesListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val quotes = DataManager.loadQuotes(this@MainActivity)
        setContent {
            QuotesHomeScreen(quotes)
        }
    }
}

@Composable
fun QuotesHomeScreen(quotes: Quotes) {
    if (DataManager.currentPage.value == Pages.LISTING) {
        QuotesListScreen(quotes = quotes) { it ->
            DataManager.switchPages(it)
        }
    } else {
        DataManager.currentQuote?.let {
            QuotesDetail(quote = it)
        }
    }
}
