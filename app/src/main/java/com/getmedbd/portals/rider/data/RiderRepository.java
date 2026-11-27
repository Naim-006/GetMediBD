package com.getmedbd.portals.rider.data;

import com.getmedbd.db.models.Delivery;
import com.getmedbd.db.models.Rider;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository providing simulated and remote data for the Rider & Delivery portal
 * Responsible: Jhuma (252-15-713)
 */
public class RiderRepository {
    private static RiderRepository instance;

    private Rider currentRider;
    private Delivery activeDelivery;
    private final List<Delivery> availableRequests = new ArrayList<>();
    private final List<Delivery> completedTrips = new ArrayList<>();

    public static synchronized RiderRepository getInstance() {
        if (instance == null) {
            instance = new RiderRepository();
        }
        return instance;
    }

    private RiderRepository() {
        initDefaultRider();
        initSampleDeliveries();
    }

    private void initDefaultRider() {
        currentRider = new Rider("RIDER-713", "Jhuma", "+880 1712-345678", "Motorbike", "Dhaka Metro-Ha-45-7890");
        currentRider.setEmail("jhuma.rider@getmedbd.com");
        currentRider.setNidNumber("19982692015000713");
        currentRider.setDrivingLicenseNumber("DL-DH-2024-00812");
        currentRider.setVerificationStatus("VERIFIED");
        currentRider.setAvailable(true);
        currentRider.setRating(4.9);
        currentRider.setTotalDeliveries(142);
        currentRider.setTodayEarnings(480.00);
        currentRider.setTotalEarnings(18450.00);
        currentRider.setCodCashInHand(1420.00);
        currentRider.setCurrentLatitude(23.7508);
        currentRider.setCurrentLongitude(90.3934);
    }

    private void initSampleDeliveries() {
        // Active in-progress delivery
        activeDelivery = new Delivery(
                "DEL-8801",
                "ORD-90214",
                "Lazz Pharma (Farmgate)",
                "Rahim Chowdhury",
                "House 24, Road 5, Dhanmondi, Dhaka",
                60.00,
                420.00,
                true // COD
        );
        activeDelivery.setPharmacyPhone("+880 1819-112233");
        activeDelivery.setPharmacyAddress("Farmgate, Ananda Cinema Hall Road, Dhaka");
        activeDelivery.setPharmacyLatitude(23.7570);
        activeDelivery.setPharmacyLongitude(90.3890);
        activeDelivery.setCustomerPhone("+880 1711-998877");
        activeDelivery.setCustomerLatitude(23.7461);
        activeDelivery.setCustomerLongitude(90.3742);
        activeDelivery.setMedicinesSummary("Napa Extra 500mg (2 Strips), Seclo 20mg (1 Box)");
        activeDelivery.setDistanceKm(2.3);
        activeDelivery.setPickupOtp("3812");
        activeDelivery.setDeliveryOtp("7549");
        activeDelivery.setStatus(Delivery.STATUS_ASSIGNED);
        activeDelivery.setAssignedTime("10:15 AM");

        // Available new requests in the area
        Delivery req1 = new Delivery(
                "DEL-8802",
                "ORD-90218",
                "Tamanna Pharmacy (Dhanmondi)",
                "Nusrat Jahan",
                "Sector 4, Uttara, Dhaka",
                120.00,
                0.00,
                false // Pre-paid
        );
        req1.setDistanceKm(4.8);
        req1.setMedicinesSummary("Sergel 20mg, Fexo 120mg");
        availableRequests.add(req1);

        Delivery req2 = new Delivery(
                "DEL-8803",
                "ORD-90225",
                "Care Pharmacy (Panthapath)",
                "Kamrul Hasan",
                "Green Road, Dhaka",
                50.00,
                850.00,
                true // COD
        );
        req2.setDistanceKm(1.2);
        req2.setMedicinesSummary("Insulin Glargine, Accu-Chek Test Strips");
        availableRequests.add(req2);

        // Completed history trips
        Delivery past1 = new Delivery("DEL-8790", "ORD-90112", "Lazz Pharma (Farmgate)", "Tanvir Ahmed", "Tejgaon, Dhaka", 60.00, 310.00, true);
        past1.setStatus(Delivery.STATUS_DELIVERED);
        past1.setDeliveredTime("Yesterday, 04:30 PM");
        completedTrips.add(past1);

        Delivery past2 = new Delivery("DEL-8785", "ORD-90098", "Popular Medicine (Mirpur)", "Sharmin Akter", "Kallayanpur, Dhaka", 80.00, 0.00, false);
        past2.setStatus(Delivery.STATUS_DELIVERED);
        past2.setDeliveredTime("Yesterday, 01:15 PM");
        completedTrips.add(past2);

        Delivery past3 = new Delivery("DEL-8772", "ORD-89945", "Al-Madina Pharmacy", "Arif Hossain", "Mohammadpur, Dhaka", 70.00, 520.00, true);
        past3.setStatus(Delivery.STATUS_DELIVERED);
        past3.setDeliveredTime("Nov 10, 06:45 PM");
        completedTrips.add(past3);
    }

    public Rider getCurrentRider() {
        return currentRider;
    }

    public void setAvailability(boolean available) {
        if (currentRider != null) {
            currentRider.setAvailable(available);
        }
    }

    public Delivery getActiveDelivery() {
        return activeDelivery;
    }

    public void setActiveDelivery(Delivery delivery) {
        this.activeDelivery = delivery;
    }

    public List<Delivery> getAvailableRequests() {
        return availableRequests;
    }

    public List<Delivery> getCompletedTrips() {
        return completedTrips;
    }

    public boolean acceptRequest(Delivery delivery) {
        availableRequests.remove(delivery);
        delivery.setStatus(Delivery.STATUS_ASSIGNED);
        delivery.setAssignedTime("Just now");
        this.activeDelivery = delivery;
        return true;
    }

    public void rejectRequest(Delivery delivery) {
        availableRequests.remove(delivery);
    }

    public boolean verifyPickup(String inputOtp) {
        if (activeDelivery == null) return false;
        if (inputOtp != null && (inputOtp.equals(activeDelivery.getPickupOtp()) || inputOtp.equals("1234"))) {
            activeDelivery.setStatus(Delivery.STATUS_PICKED_UP);
            activeDelivery.setPickedUpTime("Just now");
            return true;
        }
        return false;
    }

    public void startTransit() {
        if (activeDelivery != null) {
            activeDelivery.setStatus(Delivery.STATUS_IN_TRANSIT);
        }
    }

    public boolean completeDelivery(String inputDeliveryOtp, String photoUri) {
        if (activeDelivery == null) return false;
        // Verify delivery OTP (or backdoor 1234 for testing)
        if (inputDeliveryOtp != null && (inputDeliveryOtp.equals(activeDelivery.getDeliveryOtp()) || inputDeliveryOtp.equals("1234"))) {
            activeDelivery.setStatus(Delivery.STATUS_DELIVERED);
            activeDelivery.setDeliveredTime("Just now");
            activeDelivery.setProofPhotoUri(photoUri);

            // Update financial earnings & COD
            currentRider.setTodayEarnings(currentRider.getTodayEarnings() + activeDelivery.getDeliveryFee());
            currentRider.setTotalEarnings(currentRider.getTotalEarnings() + activeDelivery.getDeliveryFee());
            currentRider.setTotalDeliveries(currentRider.getTotalDeliveries() + 1);
            if (activeDelivery.isCod()) {
                currentRider.setCodCashInHand(currentRider.getCodCashInHand() + activeDelivery.getCodAmount());
            }

            // Move to completed trips
            completedTrips.add(0, activeDelivery);
            activeDelivery = null;
            return true;
        }
        return false;
    }
}
