package com.example.pets;

import android.arch.persistence.room.Room;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pets.adapter.ViewPagerAdapter;
import com.example.pets.listener.ItemDAO;
import com.example.pets.utils.DarkModeInterface;
import com.example.pets.utils.DarkModeUtil;

import java.util.List;
//import androidx.viewpager.widget.ViewPager;
//import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements DarkModeInterface {

//    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 2;

    private TabLayout mTabLayout ;
    private ViewPager mViewPager;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyTheme();
        setContentView(R.layout.activity_main);
        applyBackground();
/*
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries() // chạy luôn trên luồng chính do đang còn đơn giản, chuưa cần AsynTask
                .build();
        ItemDAO itemDAO = database.getItemDAO();
        Item item = new Item("","","","");
        item.setName("Item001");
        item.setDescription("Item 001");
        item.setLike("Like");

        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
        System.out.println(items);

 */

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        button = findViewById(R.id.button);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.POSITION_NONE); //BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DarkModeUtil.isDarkMode= !DarkModeUtil.isDarkMode;
                recreate();
            }
        });
    }

    private void applyBackground() {
        if (DarkModeUtil.isDarkMode){
            enableDarkMode();
        }
        else {
            disableDarkMode();
        }
    }

    private void applyTheme() {
        if (DarkModeUtil.isDarkMode) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppTheme);
            }

    }

    @Override
    public void enableDarkMode() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            button.setBackground(getDrawable(R.drawable.background_dark));
//        }
    }

    @Override
    public void disableDarkMode() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            button.setBackground(getDrawable(R.drawable.background_default));
//        }
    }
}