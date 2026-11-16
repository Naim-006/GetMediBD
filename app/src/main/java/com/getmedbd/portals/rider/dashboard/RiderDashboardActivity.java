package com.getmedbd.portals.rider.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.materialswitch.MaterialSwitch;

import com.getmedbd.R;
import com.getmedbd.db.models.Rider;
import com.getmedbd.portals.rider.data.RiderRepository;
import com.getmedbd.portals.rider.delivery.ActiveDeliveriesFragment;
import com.getmedbd.portals.rider.earnings.RiderEarningsFragment;
import com.getmedbd.portals.rider.history.DeliveryHistoryFragment;
import com.getmedbd.portals.rider.orders.RiderOrdersFragment;
import com.getmedbd.portals.rider.profile.RiderProfileActivity;

/**
 * Main Rider Dashboard Activity
 * Responsible: Jhuma (252-15-713)
 */
public class RiderDashboardActivity extends AppCompatActivity {

    private TextView tvRiderName;
    private TextView tvDutyStatusLabel;
    private MaterialSwitch switchDutyStatus;
    private TextView tvStatTodayEarnings;
    private TextView tvStatTrips;
    private TextView tvStatRating;
    private TextView tvStatCod;
    private BottomNavigationView bottomNav;
    private ImageView btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_dashboard);

        initViews();
        setupDutyToggle();
        setupBottomNavigation();
        loadDashboardStats();

        // Load Active Deliveries fragment by default
        if (savedInstanceState == null) {
            loadFragment(new ActiveDeliveriesFragment());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDashboardStats();
    }

    private void initViews() {
        tvRiderName = findViewById(R.id.tv_rider_name);
        tvDutyStatusLabel = findViewById(R.id.tv_duty_status_label);
        switchDutyStatus = findViewById(R.id.switch_duty_status);
        tvStatTodayEarnings = findViewById(R.id.tv_stat_today_earnings);
        tvStatTrips = findViewById(R.id.tv_stat_trips);
        tvStatRating = findViewById(R.id.tv_stat_rating);
        tvStatCod = findViewById(R.id.tv_stat_cod);
        bottomNav = findViewById(R.id.rider_bottom_navigation);
        btnProfile = findViewById(R.id.btn_profile);

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(RiderDashboardActivity.this, RiderProfileActivity.class);
            startActivity(intent);
        });
    }

    private void setupDutyToggle() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        switchDutyStatus.setChecked(rider.isAvailable());

        switchDutyStatus.setOnCheckedChangeListener((buttonView, isChecked) -> {
            RiderRepository.getInstance().setAvailability(isChecked);
            if (isChecked) {
                tvDutyStatusLabel.setText("● On Duty (Available)");
                tvDutyStatusLabel.setTextColor(getResources().getColor(R.color.primary));
                Toast.makeText(this, "You are now Online and will receive delivery requests!", Toast.LENGTH_SHORT).show();
            } else {
                tvDutyStatusLabel.setText("○ Off Duty (Offline)");
                tvDutyStatusLabel.setTextColor(getResources().getColor(R.color.text_secondary));
                Toast.makeText(this, "You are now Offline. No delivery requests will be assigned.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadDashboardStats() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        if (rider != null) {
            tvRiderName.setText(rider.getName() + " (#" + rider.getId() + ")");
            tvStatTodayEarnings.setText("৳" + String.format("%.0f", rider.getTodayEarnings()));
            tvStatTrips.setText(String.valueOf(rider.getTotalDeliveries()));
            tvStatRating.setText("★ " + rider.getRating());
            tvStatCod.setText("৳" + String.format("%.0f", rider.getCodCashInHand()));
        }
    }

    private void setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_active_delivery) {
                loadFragment(new ActiveDeliveriesFragment());
                return true;
            } else if (itemId == R.id.nav_requests) {
                loadFragment(new RiderOrdersFragment());
                return true;
            } else if (itemId == R.id.nav_earnings) {
                loadFragment(new RiderEarningsFragment());
                return true;
            } else if (itemId == R.id.nav_history) {
                loadFragment(new DeliveryHistoryFragment());
                return true;
            }
            return false;
        });
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rider_fragment_container, fragment)
                .commit();
    }
}
