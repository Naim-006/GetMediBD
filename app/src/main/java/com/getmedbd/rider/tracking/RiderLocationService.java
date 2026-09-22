package com.getmedbd.rider.tracking;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

/**
 * Background service for real-time GPS location tracking and updates for active deliveries
 */
public class RiderLocationService extends Service {
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Start foreground location updates and broadcast coordinates to Supabase Realtime
        return START_STICKY;
    }
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
