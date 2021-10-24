package com.example.newsifyredesigned.presentation.news_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsifyredesigned.presentation.news_list.NewsListViewModel
import com.example.newsifyredesigned.presentation.ui.theme.ChipSelected

@Composable
fun NewsChips(
    modifier: Modifier = Modifier,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val chipState = viewModel.newsChips.value
    val currentSelectedChip = viewModel.currentSelectedChip.value
    NewsChipList(
        chips = chipState,
        modifier = modifier,
        viewModel = viewModel,
        currentSelectedChip = currentSelectedChip
    )
}

@Composable
fun NewsChipList(
    modifier: Modifier = Modifier,
    chips: List<String>,
    viewModel: NewsListViewModel,
    currentSelectedChip: String
) {
    LazyRow {

        items(chips){chip->
            NewsChipItem(
                chip = chip,
                modifier = modifier,
                viewModel = viewModel,
                currentSelectedChip = currentSelectedChip
            )
        }
    }
}

@Composable
fun NewsChipItem(
    modifier: Modifier = Modifier,
    chip: String,
    viewModel: NewsListViewModel,
    currentSelectedChip: String
) {
    Card(
        modifier = modifier.clickable {
                            viewModel.updateSelectedChip(currentSelectedChip = currentSelectedChip, newlySelectedChip = chip)
                            viewModel.getNewsByChip()
        },
        backgroundColor = if(chip == currentSelectedChip) ChipSelected else Color.DarkGray
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = chip, style = MaterialTheme.typography.body1, modifier = Modifier.padding(4.dp), color = Color.White)
        }
    }
}
