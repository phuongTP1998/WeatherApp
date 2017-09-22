package trongphuong.vn.weatherapp.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class DataWeatherModelJSON {
    @SerializedName("main")
    private Main main;
    @SerializedName("clouds")
    private Cloud clouds;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("dt_txt")
    private String dt_txt;
    @SerializedName("weather")
    private List<Weather> weather;

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
