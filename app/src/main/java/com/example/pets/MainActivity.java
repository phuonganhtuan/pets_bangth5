package com.example.pets;

import android.arch.persistence.room.Room;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pets.adapter.ViewPagerAdapter;
import com.example.pets.listener.ItemDAO;

import java.util.List;
//import androidx.viewpager.widget.ViewPager;
//import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

//    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 2;

    private TabLayout mTabLayout ;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeDark);
        setContentView(R.layout.activity_main);

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

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.POSITION_NONE); //BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}