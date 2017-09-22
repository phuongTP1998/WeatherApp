package trongphuong.vn.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import trongphuong.vn.weatherapp.datamodel.DataModel;
import trongphuong.vn.weatherapp.fragment.FragmentContent;
import trongphuong.vn.weatherapp.manager.ScreenManager;

public class MainActivity extends AppCompatActivity {
    public static List<DataModel> dataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenManager.openFragment(getSupportFragmentManager(),new FragmentContent(),R.id.rl_content);
    }

}
