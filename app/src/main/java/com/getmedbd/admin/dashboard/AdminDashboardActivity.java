package com.getmedbd.admin.dashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.getmedbd.R;

/**
 * Dashboard Activity for Admin users
 */
public class AdminDashboardActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        
        // Initialize admin dashboard components
        initDashboard();
    }
    
    private void initDashboard() {
        // TODO: Setup admin dashboard components
        // - User management overview
        // - Pharmacy approval requests
        // - System statistics
        // - Recent complaints
    }
}
