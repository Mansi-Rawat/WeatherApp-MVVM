package com.example.weatherapp

import WeatherViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.weatherapp.ui.theme.MyApplicationTheme
import com.example.weatherapp.ui.theme.screen.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                WeatherScreen()
            }
        }
    }
}



@Composable
fun WeatherUI(viewModel: WeatherViewModel) {

     val data = viewModel.weatherData

    data?.let {

        Column {

            androidx.compose.material3.Text(
                text = it.name, color = Color.Blue
            )

            androidx.compose.material3.Text(
                text = "${it.main.temp}°C", color = Color.White
            )

            androidx.compose.material3.Text(
                text = it.weather[0].description, color = Color.White
            )
        }
    }
}




