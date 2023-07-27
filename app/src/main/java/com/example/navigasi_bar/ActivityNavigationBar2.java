package com.example.navigasi_bar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.navigasi_bar.databinding.ActivityNavigationBar2Binding;

public class ActivityNavigationBar2 extends AppCompatActivity {

    ActivityNavigationBar2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBar2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.BottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.bottom_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.bottom_history:
                    replaceFragment(new HistroyFragment());
                    break;
                case R.id.bottom_notif:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.bottom_profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();

    }
}