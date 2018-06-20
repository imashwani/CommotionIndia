package com.example.ashwani.commotionindia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ashwani.commotionindia.EducationFragment.EducationFragment;
import com.example.ashwani.commotionindia.ForyouFragment.ForyouFragment;
import com.example.ashwani.commotionindia.GenderFragment.GenderFragment;
import com.example.ashwani.commotionindia.HomeFragments.HomeFragment;
import com.example.ashwani.commotionindia.MediaFragment.MediaFragment;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
   FragmentManager fragmentManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_education:
                    fragmentTransaction.replace(R.id.fragment_container, new EducationFragment());
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_gender:
                    fragmentTransaction.replace(R.id.fragment_container, new GenderFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_media:
                    fragmentTransaction.replace(R.id.fragment_container, new MediaFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_foryou:
                    fragmentTransaction.replace(R.id.fragment_container, new ForyouFragment());
                    fragmentTransaction.commit();
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new HomeFragment());

        fragmentTransaction.commit();
    }


}
