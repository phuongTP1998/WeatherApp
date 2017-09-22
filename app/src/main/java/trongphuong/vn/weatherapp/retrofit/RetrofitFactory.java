package trongphuong.vn.weatherapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class RetrofitFactory {
    private static Retrofit retrofit;

    private static RetrofitFactory instance = new RetrofitFactory();

    public static RetrofitFactory getInstance(){ return instance; }

    private RetrofitFactory(){
        retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/forecast/?")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    public <T> T create (final  Class<T> service){
        return retrofit.create(service);
    }
}
