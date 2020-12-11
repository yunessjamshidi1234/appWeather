package com.example.appweather

data class Pop(
    val city_name: String,
    val country_code: String,
    val `data`: List<Data>,
    val lat: String,
    val lon: String,
    val state_code: String,
    val timezone: String
)

data class Data(
    val app_max_temp: Double,
    val app_min_temp: Double,
    val clouds: Double,
    val clouds_hi: Double,
    val clouds_low: Double,
    val clouds_mid: Double,
    val datetime: String,
    val dewpt: Double,
    val high_temp: Double,
    val low_temp: Double,
    val max_dhi: Any,
    val max_temp: Double,
    val min_temp: Double,
    val moon_phase: Double,
    val moon_phase_lunation: Double,
    val moonrise_ts: Double,
    val moonset_ts: Double,
    val ozone: Double,
    val pop: Double,
    val precip: Double,
    val pres: Double,
    val rh: Double,
    val slp: Double,
    val snow: Double,
    val snow_depth: Double,
    val sunrise_ts: Double,
    val sunset_ts: Double,
    val temp: Double,
    val ts: Double,
    val uv: Double,
    val valid_date: String,
    val vis: Double,
    val weather: Weather,
    val wind_cdir: String,
    val wind_cdir_full: String,
    val wind_dir: Double,
    val wind_gust_spd: Double,
    val wind_spd: Double
)

data class Weather(
    val code: Int,
    val description: String,
    val icon: String
)