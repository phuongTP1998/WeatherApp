package trongphuong.vn.weatherapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import trongphuong.vn.weatherapp.R;
import trongphuong.vn.weatherapp.datamodel.DataModel;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class FragmentDetail extends Fragment {
    private DataModel dataModel;
    private ImageView ivAvatar;
    private TextView tvCelcius, tvHumidity, tvPressure, tvSpeed,situation;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        EventBus.getDefault().register(this);
        init(view);
        setupData();
        return view;
    }

    private void setupData() {
        Picasso.with(getContext())
                .load("http://openweathermap.org/img/w/"+dataModel.getWeather().get(0).getIcon()+".png").into(ivAvatar);
        tvCelcius.setText(dataModel.getMain().getTemp());
        tvHumidity.setText(dataModel.getMain().getHumidity());
        tvPressure.setText(dataModel.getMain().getPressure());
        tvSpeed.setText(dataModel.getWind().getSpeed());
        situation.setText(dataModel.getWeather().get(0).getDescription());
    }

    private void init(View view) {
        ivAvatar = (ImageView) view.findViewById(R.id.avatar);
        tvCelcius = (TextView) view.findViewById(R.id.celcius);
        tvHumidity = (TextView) view.findViewById(R.id.tv_humidity);
        tvPressure = (TextView) view.findViewById(R.id.tv_pressure);
        tvSpeed = (TextView) view.findViewById(R.id.tv_speed);
        situation = (TextView) view.findViewById(R.id.situation);
    }

    @Subscribe(sticky = true)
    public void onReceivedDataModel(DataModel dataModel){
        this.dataModel = dataModel;
    }
}
