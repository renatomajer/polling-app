package com.project.polling.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.polling.R
import com.project.polling.viewmodels.MainScreenViewModel
import org.koin.androidx.compose.viewModel


@Composable
fun MainScreen() {

    val mainScreenViewModel by viewModel<MainScreenViewModel>()
    val tokens = mainScreenViewModel.getData().collectAsState(initial = emptyList())

    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            tokens.value.forEach { t ->
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = dimensionResource(id = R.dimen.border_width),
                                color = Color.Black
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = R.string.price) + ": " + t.bpi.USD.rate + "USD")
                        Text(text = stringResource(id = R.string.timestamp) + ": " + t.time.updated)
                    }
                }
            }
        }
    }
}