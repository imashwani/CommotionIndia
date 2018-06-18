package com.example.ashwani.commotionindia.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HomePageAdapter extends FragmentPagerAdapter {


    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        switch (position){
            case 0:
                fragment=new HomeWhatsNewFragment();

                break;

            case 1:
                     fragment=new HomeJoinUsFragment();

                break;
        }

       return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}