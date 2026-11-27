package com.getmedbd.portals.rider.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;
import com.getmedbd.portals.rider.dashboard.RiderDashboardActivity;
import com.getmedbd.portals.rider.data.RiderRepository;
import com.getmedbd.portals.rider.delivery.ActiveDeliveriesFragment;

import java.util.List;

/**
 * Fragment displaying new incoming marketplace delivery requests for the rider to accept/reject
 * Responsible: Jhuma (252-15-713)
 */
public class RiderOrdersFragment extends Fragment implements DeliveryRequestAdapter.OnRequestActionListener {

    private RecyclerView rvRequests;
    private TextView tvEmpty;
    private DeliveryRequestAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rider_orders, container, false);
        rvRequests = view.findViewById(R.id.rv_delivery_requests);
        tvEmpty = view.findViewById(R.id.tv_empty_requests);

        rvRequests.setLayoutManager(new LinearLayoutManager(requireContext()));
        loadRequests();
        return view;
    }

    public void loadRequests() {
        List<Delivery> requests = RiderRepository.getInstance().getAvailableRequests();
        if (requests.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rvRequests.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rvRequests.setVisibility(View.VISIBLE);
            adapter = new DeliveryRequestAdapter(requests, this);
            rvRequests.setAdapter(adapter);
        }
    }

    @Override
    public void onAccept(Delivery delivery) {
        RiderRepository.getInstance().acceptRequest(delivery);
        Toast.makeText(requireContext(), "Order #" + delivery.getOrderId() + " accepted! Navigate to pharmacy for pickup.", Toast.LENGTH_SHORT).show();

        // Refresh stats and transition to active delivery screen
        if (getActivity() instanceof RiderDashboardActivity) {
            RiderDashboardActivity activity = (RiderDashboardActivity) getActivity();
            activity.loadDashboardStats();
            activity.loadFragment(new ActiveDeliveriesFragment());
        }
    }

    @Override
    public void onReject(Delivery delivery) {
        RiderRepository.getInstance().rejectRequest(delivery);
        Toast.makeText(requireContext(), "Delivery request declined.", Toast.LENGTH_SHORT).show();
        loadRequests();
    }
}
