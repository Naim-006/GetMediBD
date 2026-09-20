package com.getmedbd.pharmacy.dashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.getmedbd.R;

/**
 * Dashboard Activity for Pharmacy users
 */
public class PharmacyDashboardActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_dashboard);
        
        // Initialize pharmacy dashboard components
        initDashboard();
    }
    
    private void initDashboard() {
        // TODO: Setup dashboard components
        // - Statistics cards
        // - Recent orders list
        // - Inventory summary
        // - Earnings chart
    }
}
