package com.sgupta.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.sgupta.quotes.DataManager
import com.sgupta.quotes.models.QuotesItem

@Composable
fun QuotesDetail(quote: QuotesItem) {

    BackHandler {
     DataManager.switchPages(null)
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize(1f)
                .background(
                    Brush.sweepGradient(
                        listOf(
                            Color(0xFFffffff),
                            Color(0xFFE3E3E3),
                        ),
                    ),
                ),
        contentAlignment = Alignment.Center,
    ) {
        Card(modifier = Modifier.padding(32.dp).fillMaxWidth(.8f)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(16.dp, 24.dp),
            ) {
                Image(
                    imageVector = Icons.Filled.Favorite,
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription = "Quote",
                    modifier =
                        Modifier
                            .size(40.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}
