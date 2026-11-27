package com.getmedbd.portals.rider.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.getmedbd.R;
import com.getmedbd.db.models.Delivery;

import java.util.List;

/**
 * RecyclerView Adapter for completed trip logs
 * Responsible: Jhuma (252-15-713)
 */
public class DeliveryHistoryAdapter extends RecyclerView.Adapter<DeliveryHistoryAdapter.ViewHolder> {

    private final List<Delivery> historyList;

    public DeliveryHistoryAdapter(List<Delivery> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivery_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Delivery delivery = historyList.get(position);
        holder.tvOrderId.setText("#" + delivery.getOrderId());
        holder.tvStatus.setText(delivery.getStatus());
        holder.tvPharmacy.setText("Pickup: " + delivery.getPharmacyName());
        holder.tvCustomer.setText("Drop: " + delivery.getCustomerName() + ", " + delivery.getCustomerAddress());
        holder.tvTime.setText(delivery.getDeliveredTime() != null ? delivery.getDeliveredTime() : "Delivered");
        holder.tvFee.setText("+ ৳" + String.format("%.2f", delivery.getDeliveryFee()));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderId, tvStatus, tvPharmacy, tvCustomer, tvTime, tvFee;

        ViewHolder(View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tv_hist_order_id);
            tvStatus = itemView.findViewById(R.id.tv_hist_status);
            tvPharmacy = itemView.findViewById(R.id.tv_hist_pharmacy);
            tvCustomer = itemView.findViewById(R.id.tv_hist_customer);
            tvTime = itemView.findViewById(R.id.tv_hist_time);
            tvFee = itemView.findViewById(R.id.tv_hist_fee);
        }
    }
}
