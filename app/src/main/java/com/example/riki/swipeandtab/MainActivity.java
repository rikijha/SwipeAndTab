package com.example.riki.swipeandtab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
TabLayout myTab;
    ViewPager myPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTab=(TabLayout)findViewById(R.id.mytab);
        myPager=(ViewPager)findViewById(R.id.myPagger);
        myPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myPager);

        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    class MyPagerAdapter extends FragmentPagerAdapter{
String data[]={"First","Second","Third"};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new First();
            }
            else if(position==1){
                return new Second();
            }
            else if(position==2){
                return new Third();
            }
            else {
                return null;
            }
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }

}
