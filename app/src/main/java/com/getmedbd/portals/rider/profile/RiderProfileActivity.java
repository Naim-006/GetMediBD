package com.getmedbd.portals.rider.profile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.getmedbd.R;
import com.getmedbd.db.models.Rider;
import com.getmedbd.portals.rider.data.RiderRepository;

/**
 * Rider Profile & Document Verification Activity
 * Responsible: Jhuma (252-15-713)
 */
public class RiderProfileActivity extends AppCompatActivity {

    private TextView tvProfileName, tvProfileId, tvNid, tvLicense;
    private EditText etVehicleType, etVehiclePlate, etPhone, etEmail;
    private Button btnSaveProfile, btnBackDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_profile);

        initViews();
        loadProfileData();
    }

    private void initViews() {
        tvProfileName = findViewById(R.id.tv_profile_name);
        tvProfileId = findViewById(R.id.tv_profile_id);
        tvNid = findViewById(R.id.tv_nid);
        tvLicense = findViewById(R.id.tv_license);

        etVehicleType = findViewById(R.id.et_vehicle_type);
        etVehiclePlate = findViewById(R.id.et_vehicle_plate);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);

        btnSaveProfile = findViewById(R.id.btn_save_profile);
        btnBackDashboard = findViewById(R.id.btn_back_dashboard);

        btnBackDashboard.setOnClickListener(v -> finish());

        btnSaveProfile.setOnClickListener(v -> saveProfileData());
    }

    private void loadProfileData() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        if (rider != null) {
            tvProfileName.setText(rider.getName());
            tvProfileId.setText("Partner ID: #" + rider.getId());
            tvNid.setText(rider.getNidNumber() + " (Verified ✔)");
            tvLicense.setText(rider.getDrivingLicenseNumber() + " (Verified ✔)");

            etVehicleType.setText(rider.getVehicleType());
            etVehiclePlate.setText(rider.getVehiclePlateNumber());
            etPhone.setText(rider.getPhone());
            etEmail.setText(rider.getEmail());
        }
    }

    private void saveProfileData() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        if (rider != null) {
            rider.setVehicleType(etVehicleType.getText().toString().trim());
            rider.setVehiclePlateNumber(etVehiclePlate.getText().toString().trim());
            rider.setPhone(etPhone.getText().toString().trim());
            rider.setEmail(etEmail.getText().toString().trim());

            Toast.makeText(this, "Profile and vehicle details updated successfully!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
