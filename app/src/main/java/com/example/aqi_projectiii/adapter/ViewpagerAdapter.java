package com.example.aqi_projectiii.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aqi_projectiii.fragment.HomeFragment;
import com.example.aqi_projectiii.fragment.InforFragment;
import com.example.aqi_projectiii.fragment.MapFragment;
import com.example.aqi_projectiii.fragment.SettingFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {
    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new InforFragment();
            default:
                return new SettingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
