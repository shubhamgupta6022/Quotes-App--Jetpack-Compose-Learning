package com.sgupta.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.sgupta.quotes.constants.Pages
import com.sgupta.quotes.models.Quotes
import com.sgupta.quotes.models.QuotesItem

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: QuotesItem? = null

    fun loadQuotes(context: Context): Quotes {
        val jsonString: String =
            context.assets
                .open("quotes.json")
                .bufferedReader()
                .use { it.readText() }

        return Gson().fromJson(jsonString, Quotes::class.java)
    }

    fun switchPages(quotesItem: QuotesItem?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quotesItem
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}
