package trongphuong.vn.weatherapp.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class Cloud {
    @SerializedName("all")
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
