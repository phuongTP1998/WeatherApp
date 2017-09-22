package trongphuong.vn.weatherapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import trongphuong.vn.weatherapp.R;
import trongphuong.vn.weatherapp.datamodel.DataModel;
import trongphuong.vn.weatherapp.datamodel.DataWeatherModelJSON;
import trongphuong.vn.weatherapp.fragment.FragmentDetail;
import trongphuong.vn.weatherapp.manager.ScreenManager;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class AdapterFragmentContent extends RecyclerView.Adapter<AdapterFragmentContent.ContentViewHolder> {
    private List<DataModel> dataWeatherModelJSONs;
    private Context context;
    private View.OnClickListener onClickListener;
    private FragmentManager fragmentManager;
    private Fragment fragment;
    View view;

    public AdapterFragmentContent(List<DataModel> dataModels,Context context,FragmentManager fragmentManager, Fragment fragment){
        this.dataWeatherModelJSONs = dataModels;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.fragment = fragment;
    }

    public void setOnItemClick(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_weather,parent,false);
        view.setOnClickListener(onClickListener);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        holder.setData(this.dataWeatherModelJSONs.get(position),context);
    }

    @Override
    public int getItemCount() {
        return dataWeatherModelJSONs.size();
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvTime, tvCondition;
        private TextView tvDayMonth;
        private LinearLayout llWeather;
        public ContentViewHolder(View itemView) {
            super(itemView);
            this.init(itemView);
            view = itemView;
        }
        private void init(View itemView){
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvCondition = (TextView) itemView.findViewById(R.id.tv_situation);
            tvDayMonth = (TextView) itemView.findViewById(R.id.tv_day_month);
            llWeather = (LinearLayout) itemView.findViewById(R.id.ll_weather);
        }

        private void setData(final DataModel data, Context context){
                if(data!=null){
                    Picasso.with(context)
                            .load("http://openweathermap.org/img/w/"+data.getWeather().get(0).getIcon()+".png").into(ivIcon);
                    tvDayMonth.setText(data.getDt_txt());
                    tvTime.setText(data.getWeather().get(0).getMain());
                    tvCondition.setText(data.getWeather().get(0).getDescription());
                    view.setTag(data);
                }
            llWeather.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(data);
                    ScreenManager.openFragment(fragmentManager,new FragmentDetail(),R.id.rl_content);
                }
            });
        }
    }
}
