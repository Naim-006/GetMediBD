package com.getmedbd.portals.rider.delivery;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;
import com.getmedbd.portals.rider.dashboard.RiderDashboardActivity;
import com.getmedbd.portals.rider.data.RiderRepository;

/**
 * Active Deliveries Fragment displaying live assigned order and 4-stage lifecycle stepper
 * Responsible: Jhuma (252-15-713)
 */
public class ActiveDeliveriesFragment extends Fragment {

    private LinearLayout layoutNoDelivery;
    private LinearLayout layoutDeliveryDetails;

    private TextView tvOrderId, tvStatusBadge, tvMedicines;
    private TextView stepAssigned, stepPickedUp, stepInTransit, stepDelivered;

    private TextView tvPharmacyName, tvPharmacyAddress, tvPickupOtpHint;
    private Button btnNavPharmacy, btnCallPharmacy;

    private TextView tvCustomerName, tvCustomerAddress, tvCodAmount, tvDeliveryFee;
    private Button btnNavCustomer, btnCallCustomer;

    private Button btnPrimaryAction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_active_deliveries, container, false);
        initViews(view);
        loadActiveDeliveryData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadActiveDeliveryData();
    }

    private void initViews(View view) {
        layoutNoDelivery = view.findViewById(R.id.layout_no_active_delivery);
        layoutDeliveryDetails = view.findViewById(R.id.layout_active_delivery_details);

        tvOrderId = view.findViewById(R.id.tv_active_order_id);
        tvStatusBadge = view.findViewById(R.id.tv_active_status_badge);
        tvMedicines = view.findViewById(R.id.tv_active_medicines);

        stepAssigned = view.findViewById(R.id.step_assigned);
        stepPickedUp = view.findViewById(R.id.step_picked_up);
        stepInTransit = view.findViewById(R.id.step_in_transit);
        stepDelivered = view.findViewById(R.id.step_delivered);

        tvPharmacyName = view.findViewById(R.id.tv_active_pharmacy_name);
        tvPharmacyAddress = view.findViewById(R.id.tv_active_pharmacy_address);
        tvPickupOtpHint = view.findViewById(R.id.tv_pickup_otp_hint);
        btnNavPharmacy = view.findViewById(R.id.btn_nav_pharmacy);
        btnCallPharmacy = view.findViewById(R.id.btn_call_pharmacy);

        tvCustomerName = view.findViewById(R.id.tv_active_customer_name);
        tvCustomerAddress = view.findViewById(R.id.tv_active_customer_address);
        tvCodAmount = view.findViewById(R.id.tv_cod_amount);
        tvDeliveryFee = view.findViewById(R.id.tv_delivery_fee);
        btnNavCustomer = view.findViewById(R.id.btn_nav_customer);
        btnCallCustomer = view.findViewById(R.id.btn_call_customer);

        btnPrimaryAction = view.findViewById(R.id.btn_primary_delivery_action);
    }

    public void loadActiveDeliveryData() {
        Delivery delivery = RiderRepository.getInstance().getActiveDelivery();
        if (delivery == null) {
            layoutNoDelivery.setVisibility(View.VISIBLE);
            layoutDeliveryDetails.setVisibility(View.GONE);
            return;
        }

        layoutNoDelivery.setVisibility(View.GONE);
        layoutDeliveryDetails.setVisibility(View.VISIBLE);

        tvOrderId.setText("Order #" + delivery.getOrderId());
        tvStatusBadge.setText(delivery.getStatus());
        tvMedicines.setText("Medicines: " + (delivery.getMedicinesSummary() != null ? delivery.getMedicinesSummary() : "Essential Medicines"));

        // Pharmacy info
        tvPharmacyName.setText(delivery.getPharmacyName());
        tvPharmacyAddress.setText(delivery.getPharmacyAddress());
        tvPickupOtpHint.setText("🔑 Pharmacy Pickup Verification Code: " + delivery.getPickupOtp());

        btnCallPharmacy.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + delivery.getPharmacyPhone()));
            startActivity(callIntent);
        });

        // Customer info
        tvCustomerName.setText(delivery.getCustomerName());
        tvCustomerAddress.setText(delivery.getCustomerAddress());
        if (delivery.isCod()) {
            tvCodAmount.setText("💰 Cash to Collect: ৳" + String.format("%.2f", delivery.getCodAmount()));
        } else {
            tvCodAmount.setText("💳 Payment Status: Paid Online");
        }
        tvDeliveryFee.setText("Earnings: ৳" + String.format("%.2f", delivery.getDeliveryFee()));

        btnCallCustomer.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + delivery.getCustomerPhone()));
            startActivity(callIntent);
        });

        // Update Stepper & Action Button based on delivery lifecycle
        updateStepperAndAction(delivery);
    }

    private void updateStepperAndAction(Delivery delivery) {
        String status = delivery.getStatus();

        // Reset step colors
        stepAssigned.setTextColor(getResources().getColor(R.color.text_secondary));
        stepPickedUp.setTextColor(getResources().getColor(R.color.text_secondary));
        stepInTransit.setTextColor(getResources().getColor(R.color.text_secondary));
        stepDelivered.setTextColor(getResources().getColor(R.color.text_secondary));

        if (Delivery.STATUS_ASSIGNED.equals(status)) {
            stepAssigned.setTextColor(getResources().getColor(R.color.primary));
            btnPrimaryAction.setText("1. Verify Pharmacy Pickup (Enter OTP)");
            btnPrimaryAction.setOnClickListener(v -> showPickupOtpDialog(delivery));

        } else if (Delivery.STATUS_PICKED_UP.equals(status)) {
            stepAssigned.setTextColor(getResources().getColor(R.color.primary));
            stepPickedUp.setTextColor(getResources().getColor(R.color.primary));
            btnPrimaryAction.setText("2. Start Transit to Customer");
            btnPrimaryAction.setOnClickListener(v -> {
                RiderRepository.getInstance().startTransit();
                Toast.makeText(requireContext(), "In Transit! Heading towards customer.", Toast.LENGTH_SHORT).show();
                loadActiveDeliveryData();
            });

        } else if (Delivery.STATUS_IN_TRANSIT.equals(status)) {
            stepAssigned.setTextColor(getResources().getColor(R.color.primary));
            stepPickedUp.setTextColor(getResources().getColor(R.color.primary));
            stepInTransit.setTextColor(getResources().getColor(R.color.primary));
            btnPrimaryAction.setText("3. Arrived! Open Proof of Delivery (POD)");
        }
    }

    private void showPickupOtpDialog(Delivery delivery) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Verify Pharmacy Pickup");
        builder.setMessage("Ask the pharmacist for the 4-digit Pickup verification OTP (Hint: " + delivery.getPickupOtp() + "):");

        final EditText input = new EditText(requireContext());
        input.setHint("Enter 4-Digit OTP");
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Verify & Collect", (dialog, which) -> {
            String otp = input.getText().toString().trim();
            boolean success = RiderRepository.getInstance().verifyPickup(otp);
            if (success) {
                Toast.makeText(requireContext(), "Pickup verified successfully! Package in your possession.", Toast.LENGTH_SHORT).show();
                loadActiveDeliveryData();
                if (getActivity() instanceof RiderDashboardActivity) {
                    ((RiderDashboardActivity) getActivity()).loadDashboardStats();
                }
            } else {
                Toast.makeText(requireContext(), "Invalid OTP! Please confirm with the pharmacy.", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
