package com.example.cryptocurrencyapp.presentation.coin_list.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencyapp.domain.model.Coin
import java.lang.reflect.Modifier

@Composable
fun  CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
){
    Row (
        modifier = Modifier.padding(20.dp)
            .fillMaxWidth()
            .clickable { onItemClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween
            ){
        Text(
            text= "${coin.rank}. ${coin.name} ${coin.symbol}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text= if (coin.is_active)"active" else "inactive",
            color = if (coin.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.align(CenterVertical)
        )


    }

}