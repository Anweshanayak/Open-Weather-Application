# Open Weather App

**Uses**: Multiple Activities, Internet API, RecyclerViews, Option-Menus, Android Volley, JSON Data, Time conversion, Dialogs, Images 

The **Open Weather App** is an Android application that provides users with detailed weather information for a specified location. Using the OpenWeather API, the app displays current weather conditions, a 48-hour hourly forecast, and a 7-day daily forecast in an intuitive and visually appealing way.

## Features

- **Current Weather**: Displays temperature, humidity, wind speed, UV index, and more for the selected location.
- **48-Hour Forecast**: Scrollable hourly weather data with details like temperature, wind speed, and conditions.
- **7-Day Forecast**: Shows daily weather data, including high/low temperatures and precipitation probabilities.
- **Unit Conversion**: Toggle between imperial (°F) and metric (°C) units.
- **Location Change**: Users can enter a new location to fetch weather data for that area.
- **Dynamic Layouts**:
  - Home screen: Separate layouts for portrait and landscape orientations.
  - Daily forecast: Single layout works in both orientations.

## Technical Details

### API Integration
- **Weather Data Source**: [OpenWeather API](https://openweathermap.org/api/one-call-api)
- **API Endpoint**:
https://api.openweathermap.org/data/2.5/onecall?lat=<LATITUDE>&lon=<LONGITUDE>&appid=<API_KEY>&units=<UNITS>&exclude=minutely
- **lat** and **lon**: Latitude and longitude of the location.
- **appid**: Your OpenWeather API key.
- **units**: `metric` or `imperial` for temperature units.

### UI Components
- **RecyclerView**:
- Used for displaying hourly and daily weather data.
- **Options Menu**:
- Unit conversion toggle.
- Daily forecast navigation.
- Location change dialog.
- **Custom Icons**:
- Weather icons dynamically loaded based on API response.

### Time Conversion
- Converts Unix UTC timestamps into local time using Java's `LocalDateTime` and `DateTimeFormatter`.

### Geolocation
- Converts user-input location names into latitude and longitude using the `Geocoder` API.

### Network Handling
- Checks for active network connections and handles offline scenarios gracefully with user feedback.

## Extra Features
- **Swipe to Refresh**: Reload weather data by swiping down on the home screen.
- **Persistent Settings**: Saves the last used location and unit preference for a consistent experience across app sessions.
- **Open Calendar**: Tapping an hourly forecast entry opens the device's calendar for the corresponding time.

## Getting Started

### Prerequisites
- Android Studio installed.
- An OpenWeather API key. Sign up for free [here](https://home.openweathermap.org/users/sign_up).

### Installation
1. Clone this repository.
2. Open the project in Android Studio.
3. Add your API key to the configuration file.
4. Build and run the app on an emulator or Android device.

## How It Works

1. Launch the app to view the current weather and hourly forecast for the default location.
2. Use the options menu to:
 - Change temperature units between °F and °C.
 - View the 7-day weather forecast.
 - Change the location using the provided dialog.
3. Swipe left/right in the hourly or daily RecyclerView to navigate through the forecasts.
4. Tap on an hourly forecast entry to open the corresponding date and time in the device’s calendar.

