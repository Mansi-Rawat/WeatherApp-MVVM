package com.example.weatherapp.ui.theme.screen

import WeatherViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.WeatherUI

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {

    var city by remember { mutableStateOf("Delhi") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF4A90E2), Color(0xFF001F54))
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            var input by remember { mutableStateOf(city) }

            androidx.compose.material3.OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { androidx.compose.material3.Text("Enter city") })

            androidx.compose.material3.Button(onClick = {
                city = input
                viewModel.fetchWeather(city)
            }) {
                androidx.compose.material3.Text("Search")
            }

            Spacer(modifier = Modifier.height(20.dp))

            WeatherUI(viewModel)
        }
    }
}
