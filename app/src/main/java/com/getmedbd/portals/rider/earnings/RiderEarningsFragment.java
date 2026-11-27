package com.getmedbd.portals.rider.earnings;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.getmedbd.R;
import com.getmedbd.db.models.Rider;
import com.getmedbd.portals.rider.dashboard.RiderDashboardActivity;
import com.getmedbd.portals.rider.data.RiderRepository;

/**
 * Fragment displaying earnings summary, COD collections, and remittance settlement
 * Responsible: Jhuma (252-15-713)
 */
public class RiderEarningsFragment extends Fragment {

    private TextView tvWeeklyTotal;
    private TextView tvTodayVal;
    private TextView tvCodInHand;
    private Button btnRemitCod;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rider_earnings, container, false);
        initViews(view);
        loadEarningsData();
        return view;
    }

    private void initViews(View view) {
        tvWeeklyTotal = view.findViewById(R.id.tv_earnings_weekly_total);
        tvTodayVal = view.findViewById(R.id.tv_earnings_today_val);
        tvCodInHand = view.findViewById(R.id.tv_cod_in_hand);
        btnRemitCod = view.findViewById(R.id.btn_remit_cod);

        btnRemitCod.setOnClickListener(v -> showRemittanceDialog());
    }

    public void loadEarningsData() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        if (rider != null) {
            tvWeeklyTotal.setText("৳" + String.format("%.2f", rider.getTotalEarnings()));
            tvTodayVal.setText("৳" + String.format("%.2f", rider.getTodayEarnings()) + " (" + rider.getTotalDeliveries() + " Total Trips)");
            tvCodInHand.setText("৳" + String.format("%.2f", rider.getCodCashInHand()));
        }
    }

    private void showRemittanceDialog() {
        Rider rider = RiderRepository.getInstance().getCurrentRider();
        double amount = rider != null ? rider.getCodCashInHand() : 0.0;

        if (amount <= 0) {
            Toast.makeText(requireContext(), "No pending COD cash to remit! You are all settled.", Toast.LENGTH_SHORT).show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Deposit COD Cash Remittance");
        builder.setMessage("Deposit ৳" + String.format("%.2f", amount) + " to GetMediBD Merchant bKash/Nagad account (01900-112233) to clear your COD balance?");
        builder.setPositiveButton("Confirm Deposit", (dialog, which) -> {
            if (rider != null) {
                rider.setCodCashInHand(0.0);
            }
            Toast.makeText(requireContext(), "Remittance received! Your cash-in-hand is now ৳0.00", Toast.LENGTH_LONG).show();
            loadEarningsData();
            if (getActivity() instanceof RiderDashboardActivity) {
                ((RiderDashboardActivity) getActivity()).loadDashboardStats();
            }
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
