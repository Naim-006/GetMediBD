package com.getmedbd.portals.rider.verification;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;
import com.getmedbd.portals.rider.data.RiderRepository;

/**
 * Proof of Delivery (POD) Activity
 * Handles customer OTP verification, parcel photo proof, and Cash on Delivery (COD) acknowledgment
 * Responsible: Jhuma (252-15-713)
 */
public class ProofOfDeliveryActivity extends AppCompatActivity {

    private TextView tvOrderId, tvCustomerInfo, tvCodAmount;
    private EditText etDeliveryOtp;
    private ImageView ivProofPreview;
    private Button btnTakePhoto;
    private LinearLayout layoutCod;
    private CheckBox cbCodCollected;
    private Button btnConfirmDelivery, btnCancelPod;

    private boolean isPhotoCaptured = false;
    private Delivery activeDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proof_of_delivery);

        activeDelivery = RiderRepository.getInstance().getActiveDelivery();
        if (activeDelivery == null) {
            Toast.makeText(this, "No active delivery found to complete.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        initViews();
        bindDeliveryData();
    }

    private void initViews() {
        tvOrderId = findViewById(R.id.tv_pod_order_id);
        tvCustomerInfo = findViewById(R.id.tv_pod_customer_info);
        tvCodAmount = findViewById(R.id.tv_pod_cod_amount);
        etDeliveryOtp = findViewById(R.id.et_delivery_otp);
        ivProofPreview = findViewById(R.id.iv_proof_preview);
        btnTakePhoto = findViewById(R.id.btn_take_photo);
        layoutCod = findViewById(R.id.layout_cod_verification);
        cbCodCollected = findViewById(R.id.cb_cod_collected);
        btnConfirmDelivery = findViewById(R.id.btn_confirm_delivery);
        btnCancelPod = findViewById(R.id.btn_cancel_pod);

        // Photo capture simulator
        btnTakePhoto.setOnClickListener(v -> {
            isPhotoCaptured = true;
            ivProofPreview.setImageResource(R.drawable.ic_check);
            btnTakePhoto.setText("Photo Verified ✔");
            btnTakePhoto.setEnabled(false);
            Toast.makeText(this, "Parcel drop-off photo captured successfully!", Toast.LENGTH_SHORT).show();
        });

        btnCancelPod.setOnClickListener(v -> finish());

        btnConfirmDelivery.setOnClickListener(v -> attemptDeliveryCompletion());
    }

    private void bindDeliveryData() {
        tvOrderId.setText("Order #" + activeDelivery.getOrderId());
        tvCustomerInfo.setText("Customer: " + activeDelivery.getCustomerName() + "\nAddress: " + activeDelivery.getCustomerAddress());

        if (activeDelivery.isCod()) {
            layoutCod.setVisibility(View.VISIBLE);
            tvCodAmount.setText("Total Cash to Collect: ৳" + String.format("%.2f", activeDelivery.getCodAmount()));
        } else {
            layoutCod.setVisibility(View.GONE);
        }

        // Show expected OTP hint for seamless testing
        etDeliveryOtp.setHint("Hint: " + activeDelivery.getDeliveryOtp());
    }

    private void attemptDeliveryCompletion() {
        String enteredOtp = etDeliveryOtp.getText().toString().trim();

        if (enteredOtp.isEmpty()) {
            etDeliveryOtp.setError("Please enter customer's 4-digit OTP");
            etDeliveryOtp.requestFocus();
            return;
        }

        if (activeDelivery.isCod() && !cbCodCollected.isChecked()) {
            Toast.makeText(this, "Please confirm that you have collected the Cash On Delivery (COD) amount!", Toast.LENGTH_LONG).show();
            return;
        }

        boolean success = RiderRepository.getInstance().completeDelivery(enteredOtp, isPhotoCaptured ? "mock_photo_uri" : null);

        if (success) {
            showSuccessDialog();
        } else {
            etDeliveryOtp.setError("Incorrect OTP! Please check with customer.");
            Toast.makeText(this, "Invalid Customer OTP. Please ask the customer for the correct code.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("🎉 Delivery Completed!");
        builder.setMessage("Order #" + activeDelivery.getOrderId() + " has been successfully delivered!\n\n"
                + "Delivery Fee Earned: +৳" + String.format("%.2f", activeDelivery.getDeliveryFee()) + "\n"
                + (activeDelivery.isCod() ? "COD Collected: ৳" + String.format("%.2f", activeDelivery.getCodAmount()) : "Paid Online"));
        builder.setCancelable(false);
        builder.setPositiveButton("Return to Dashboard", (dialog, which) -> {
            dialog.dismiss();
            finish();
        });
        builder.show();
    }
}
