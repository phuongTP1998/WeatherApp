package trongphuong.vn.weatherapp.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class DataModelJSON {
    @SerializedName("list")
    private List<DataWeatherModelJSON> list;

    public DataModelJSON(){

    }

    public List<DataWeatherModelJSON> getList() {
        return list;
    }

    public void setList(List<DataWeatherModelJSON> list) {
        this.list = list;
    }
}
