package com.example.aqi_projectiii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aqi_projectiii.adapter.ViewpagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
private ViewPager2 viewPager2;
private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        bottomNav = findViewById(R.id.bottomNav);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(this);
        viewPager2.setAdapter(viewpagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNav.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.menu_map).setChecked(true);
                        break;
                    case 2:
                        bottomNav.getMenu().findItem(R.id.menu_infor).setChecked(true);
                        break;
                    case 3:
                        bottomNav.getMenu().findItem(R.id.menu_setting).setChecked(true);
                        break;
}
            }
        });

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        viewPager2.getCurrentItem();
                        break;
                    case R.id.menu_map:
                        viewPager2.getCurrentItem();
                        break;
                    case R.id.menu_infor:
                        viewPager2.getCurrentItem();
                        break;
                    case R.id.menu_setting:
                        viewPager2.getCurrentItem();
                        break;
                }
                return true;
            }
        });
    }
}