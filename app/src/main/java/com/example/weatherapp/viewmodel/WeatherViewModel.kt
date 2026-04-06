import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()

    var weatherData by mutableStateOf<WeatherResponse?>(null)
    var isLoading by mutableStateOf(false)

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                weatherData = repository.getWeather(city)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            isLoading = false
        }
    }
}
