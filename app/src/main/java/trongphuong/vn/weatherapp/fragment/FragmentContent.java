package trongphuong.vn.weatherapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import trongphuong.vn.weatherapp.R;
import trongphuong.vn.weatherapp.adapter.AdapterFragmentContent;
import trongphuong.vn.weatherapp.datamodel.Cloud;
import trongphuong.vn.weatherapp.datamodel.DataModel;
import trongphuong.vn.weatherapp.datamodel.DataModelJSON;
import trongphuong.vn.weatherapp.datamodel.DataWeatherModelJSON;
import trongphuong.vn.weatherapp.datamodel.GetAllDataModel;
import trongphuong.vn.weatherapp.datamodel.Main;
import trongphuong.vn.weatherapp.datamodel.Weather;
import trongphuong.vn.weatherapp.datamodel.Wind;
import trongphuong.vn.weatherapp.retrofit.RetrofitFactory;

public class FragmentContent extends Fragment implements View.OnClickListener {
    private AdapterFragmentContent adapterFragmentContent;
    private RecyclerView rvContent;
    private List<DataModel> dataWeatherModelJSONs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        dataWeatherModelJSONs = new ArrayList<>();
        GetAllDataModel getAllDataModel = RetrofitFactory.getInstance().create(GetAllDataModel.class);
        getAllDataModel.getDataModel().enqueue(new Callback<DataModelJSON>() {
            @Override
            public void onResponse(Call<DataModelJSON> call, Response<DataModelJSON> response) {

                for (int i = 0; i < response.body().getList().size(); i++) {
                    DataModel dataWeatherModelJSON = new DataModel();
                    Main main = new Main();
                    main.setTemp(response.body().getList().get(i).getMain().getTemp());
                    main.setTemp_min(response.body().getList().get(i).getMain().getTemp_min());
                    main.setTemp_max(response.body().getList().get(i).getMain().getTemp_max());
                    main.setGrnd_level(response.body().getList().get(i).getMain().getGrnd_level());
                    main.setHumidity(response.body().getList().get(i).getMain().getHumidity());
                    main.setPressure(response.body().getList().get(i).getMain().getPressure());
                    main.setSea_level(response.body().getList().get(i).getMain().getSea_level());
                    Cloud cloud = new Cloud();
                    cloud.setAll(response.body().getList().get(i).getClouds().getAll());
                    Wind wind = new Wind();
                    wind.setSpeed(response.body().getList().get(i).getWind().getSpeed());
                    wind.setDeg(response.body().getList().get(i).getWind().getDeg());
                    List<Weather> weathers = new ArrayList<Weather>();
                    Weather weather = new Weather();
                    weather.setMain(response.body().getList().get(i).getWeather().get(0).getMain());
                    weather.setDescription(response.body().getList().get(i).getWeather().get(0).getDescription());
                    weather.setIcon(response.body().getList().get(i).getWeather().get(0).getIcon());
                    weathers.add(weather);
                    dataWeatherModelJSON.setMain(main);
                    dataWeatherModelJSON.setClouds(cloud);
                    dataWeatherModelJSON.setWeather(weathers);
                    dataWeatherModelJSON.setWind(wind);
                    dataWeatherModelJSON.setDt_txt(response.body().getList().get(i).getDt_txt());
                    dataWeatherModelJSONs.add(dataWeatherModelJSON);
                }
                adapterFragmentContent.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataModelJSON> call, Throwable t) {

            }
        });
            rvContent = (RecyclerView) view.findViewById(R.id.rv_content);
            Log.d("data ", "" + dataWeatherModelJSONs.size());
            adapterFragmentContent = new AdapterFragmentContent(dataWeatherModelJSONs, getContext(),getActivity().getSupportFragmentManager(),this);
            rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
            rvContent.setAdapter(adapterFragmentContent);
            adapterFragmentContent.setOnItemClick(this);
    }

    @Override
    public void onClick(View view) {
        DataModel data = (DataModel) view.getTag();
        Log.d("tag ","" + data.getDt_txt());
    }
}
