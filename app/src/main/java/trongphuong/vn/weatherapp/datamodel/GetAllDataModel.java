package trongphuong.vn.weatherapp.datamodel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by trongphuong1011 on 9/21/2017.
 */

public interface GetAllDataModel {
    @GET("https://api.openweathermap.org/data/2.5/forecast/?lat=21.0090602&lon=105.8324736&mode=json&units=metric&cnt=7&APPID=5735fdfc80fbfdcf103b4b43143f006f")
    Call<DataModelJSON> getDataModel();
}
