package trongphuong.vn.weatherapp.manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import trongphuong.vn.weatherapp.R;

/**
 * Created by trongphuong1011 on 9/22/2017.
 */

public class ScreenManager {
    public static void openFragment(FragmentManager fragmentManager, Fragment fragment, int layoutID) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutID, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int layoutID) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.setCustomAnimations(R.anim.anim_left, R.anim.anim_right);
        fragmentTransaction.replace(layoutID, fragment);
        fragmentTransaction.commit();
    }
    public static void replaceFragment2(FragmentManager fragmentManager, Fragment fragment, int layoutID) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(layoutID, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
    public static void replaceFragmentRtoL(FragmentManager fragmentManager, Fragment fragment, int layoutID) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.anim_right, R.anim.anim_left);
        fragmentTransaction.replace(layoutID, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    public static  void backFragment(FragmentManager fragmentManager) {
        fragmentManager.popBackStackImmediate();
    }
}

