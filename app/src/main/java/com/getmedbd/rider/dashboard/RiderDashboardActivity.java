package com.getmedbd.rider.dashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.getmedbd.R;

/**
 * Dashboard Activity for Rider / Delivery users
 */
public class RiderDashboardActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_dashboard);
        
        // Initialize rider dashboard components
        initDashboard();
    }
    
    private void initDashboard() {
        // TODO: Setup dashboard components
        // - Online / Offline toggle
        // - Available delivery requests
        // - Ongoing active deliveries
        // - Daily earnings summary
        // - Delivery stats & ratings
    }
}
