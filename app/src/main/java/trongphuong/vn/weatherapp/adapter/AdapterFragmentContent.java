package trongphuong.vn.weatherapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import trongphuong.vn.weatherapp.R;
import trongphuong.vn.weatherapp.datamodel.DataModel;
import trongphuong.vn.weatherapp.datamodel.DataWeatherModelJSON;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class AdapterFragmentContent extends RecyclerView.Adapter<AdapterFragmentContent.ContentViewHolder> {
    private List<DataModel> dataWeatherModelJSONs;
    private Context context;
    private View.OnClickListener onClickListener;
    View view;

    public AdapterFragmentContent(List<DataModel> dataModels,Context context){
        this.dataWeatherModelJSONs = dataModels;
        this.context = context;
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
        Log.d("  ","haha " + dataWeatherModelJSONs.size());
        return dataWeatherModelJSONs.size();
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvTime, tvCondition;
        private TextView tvDayMonth;
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
        }

        private void setData(DataModel data, Context context){
                if(data!=null){
                    tvDayMonth.setText(data.getDt_txt());
                    tvTime.setText(data.getWeather().get(0).getMain());
                    tvCondition.setText(data.getWeather().get(0).getDescription());
                    view.setTag(data);
                } else{
                    Log.d(""," vailua");
            }
        }
    }
}
