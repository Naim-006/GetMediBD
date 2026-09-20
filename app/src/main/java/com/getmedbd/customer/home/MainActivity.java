package com.getmedbd.customer.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.getmedbd.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main Activity for Customer module
 * Contains bottom navigation for customer features
 */
public class MainActivity extends AppCompatActivity {
    
    private BottomNavigationView bottomNavigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        setupNavigation();
    }
    
    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }
    
    private void setupNavigation() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHostFragment);
        
        if (navHostFragment != null) {
            NavigationUI.setupWithNavController(
                    bottomNavigationView,
                    navHostFragment.getNavController()
            );
        }
    }
}
