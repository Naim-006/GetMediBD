package com.getmedbd.portals.rider.tracking;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;

import com.getmedbd.portals.rider.data.RiderRepository;

/**
 * Service to manage real-time rider GPS tracking and Google Maps turn-by-turn navigation
 * Responsible: Jhuma (252-15-713)
 */
public class RiderLocationService extends Service {
    private static final String CHANNEL_ID = "rider_location_channel";
    private static final int NOTIFICATION_ID = 1001;

    public interface LocationCallback {
        void onLocationChanged(double latitude, double longitude);
    }

    private static LocationCallback locationCallback;

    public static void setLocationCallback(LocationCallback callback) {
        locationCallback = callback;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("GetMediBD Rider GPS Tracking")
                .setContentText("Sharing live delivery coordinates with customer and pharmacy")
                .setSmallIcon(android.R.drawable.ic_menu_mylocation)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        startForeground(NOTIFICATION_ID, notification);

        // Broadcast current rider GPS coordinates
        if (locationCallback != null && RiderRepository.getInstance().getCurrentRider() != null) {
            double lat = RiderRepository.getInstance().getCurrentRider().getCurrentLatitude();
            double lng = RiderRepository.getInstance().getCurrentRider().getCurrentLongitude();
            locationCallback.onLocationChanged(lat, lng);
        }

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Rider Location Tracking",
                    NotificationManager.IMPORTANCE_LOW
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    /**
     * Helper to open Google Maps turn-by-turn navigation directly to target coordinates
     */
    public static void openGoogleMapsNavigation(Context context, double destLat, double destLng, String label) {
        Uri navigationUri = Uri.parse("google.navigation:q=" + destLat + "," + destLng + "&mode=d");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigationUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
        } else {
            // Fallback to web browser or generic map viewer
            Uri webUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + destLat + "," + destLng);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
            context.startActivity(webIntent);
        }
    }

    /**
     * Calculate distance between two coordinates in kilometers using Haversine formula
     */
    public static double calculateDistanceKm(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius in KM
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.round(R * c * 10.0) / 10.0;
    }
}
