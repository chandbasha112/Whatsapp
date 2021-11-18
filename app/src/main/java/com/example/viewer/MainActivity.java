package com.example.viewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new ChatFragment());
        pagerAdapter.addFragment(new StatusFragment());
        pagerAdapter.addFragment(new CallFragment());

        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);



        tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Chat");
        tabLayout.getTabAt(1).setText("Status");
        tabLayout.getTabAt(2).setText("Calls");

        recyclerView=findViewById(R.id.recycleview);


    }
}