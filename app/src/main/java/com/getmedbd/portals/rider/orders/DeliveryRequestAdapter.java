package com.getmedbd.portals.rider.orders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;

import java.util.List;

/**
 * RecyclerView Adapter for incoming marketplace delivery requests
 * Responsible: Jhuma (252-15-713)
 */
public class DeliveryRequestAdapter extends RecyclerView.Adapter<DeliveryRequestAdapter.ViewHolder> {

    public interface OnRequestActionListener {
        void onAccept(Delivery delivery);
        void onReject(Delivery delivery);
    }

    private final List<Delivery> requestList;
    private final OnRequestActionListener listener;

    public DeliveryRequestAdapter(List<Delivery> requestList, OnRequestActionListener listener) {
        this.requestList = requestList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivery_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Delivery delivery = requestList.get(position);
        holder.tvOrderId.setText("New Order #" + delivery.getOrderId());
        holder.tvFee.setText("+ ৳" + String.format("%.2f", delivery.getDeliveryFee()));
        holder.tvPharmacy.setText("📍 Pickup: " + delivery.getPharmacyName());
        holder.tvDropoff.setText("🏁 Drop: " + delivery.getCustomerAddress() + " (" + delivery.getDistanceKm() + " km)");
        holder.tvItems.setText("📦 Items: " + (delivery.getMedicinesSummary() != null ? delivery.getMedicinesSummary() : "Essential Medicines"));

        holder.btnAccept.setOnClickListener(v -> {
            if (listener != null) listener.onAccept(delivery);
        });

        holder.btnReject.setOnClickListener(v -> {
            if (listener != null) listener.onReject(delivery);
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderId, tvFee, tvPharmacy, tvDropoff, tvItems;
        Button btnAccept, btnReject;

        ViewHolder(View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tv_req_order_id);
            tvFee = itemView.findViewById(R.id.tv_req_fee);
            tvPharmacy = itemView.findViewById(R.id.tv_req_pharmacy);
            tvDropoff = itemView.findViewById(R.id.tv_req_dropoff);
            tvItems = itemView.findViewById(R.id.tv_req_items);
            btnAccept = itemView.findViewById(R.id.btn_req_accept);
            btnReject = itemView.findViewById(R.id.btn_req_reject);
        }
    }
}
