package trongphuong.vn.weatherapp.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class Wind {
    @SerializedName("speed")
    private String speed;
    @SerializedName("deg")
    private String deg;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }
}
