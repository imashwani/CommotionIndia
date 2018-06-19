package com.example.ashwani.commotionindia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ashwani.commotionindia.HomeFragments.HomeFragment;

import GenderFragment.GenderFragment;

public class MainActivity extends AppCompatActivity {
   FragmentManager fragmentManager;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                   fragmentTransaction.add(R.id.fragment_container,new HomeFragment());
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction.add(R.id.fragment_container, new GenderFragment());
                    fragmentTransaction.commit();

                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
