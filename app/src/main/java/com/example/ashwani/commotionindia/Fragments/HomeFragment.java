package com.example.ashwani.commotionindia.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashwani.commotionindia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    private ViewPager viewPager;
    View root;
    private TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = root.findViewById(R.id.viewpager_home);
       viewPager.setAdapter(new HomePageAdapter(getActivity(),getChildFragmentManager()));

        tabLayout = (TabLayout) root.findViewById(R.id.tabs_home);
        tabLayout.setupWithViewPager(viewPager);


        return root;
    }

public class HomePageAdapter extends FragmentPagerAdapter{

    public HomePageAdapter(FragmentActivity activity, FragmentManager fm) {
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


}
