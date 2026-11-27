package com.getmedbd.portals.rider.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;
import com.getmedbd.portals.rider.data.RiderRepository;

import java.util.List;

/**
 * Fragment displaying trip history and completed delivery logs
 * Responsible: Jhuma (252-15-713)
 */
public class DeliveryHistoryFragment extends Fragment {

    private RecyclerView rvHistory;
    private TextView tvEmpty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery_history, container, false);
        rvHistory = view.findViewById(R.id.rv_delivery_history);
        tvEmpty = view.findViewById(R.id.tv_empty_history);

        rvHistory.setLayoutManager(new LinearLayoutManager(requireContext()));
        loadHistory();
        return view;
    }

    public void loadHistory() {
        List<Delivery> historyList = RiderRepository.getInstance().getCompletedTrips();
        if (historyList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rvHistory.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rvHistory.setVisibility(View.VISIBLE);
            DeliveryHistoryAdapter adapter = new DeliveryHistoryAdapter(historyList);
            rvHistory.setAdapter(adapter);
        }
    }
}
