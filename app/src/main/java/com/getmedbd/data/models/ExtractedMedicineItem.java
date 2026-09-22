package com.getmedbd.data.models;

import java.io.Serializable;

/**
 * Model representing an extracted medicine candidate from OCR/AI before or after matching
 */
public class ExtractedMedicineItem implements Serializable {
    private String rawScannedText;
    private String matchedMedicineId;
    private String matchedMedicineName;
    private String genericName;
    private String dosage;
    private String frequency;
    private int quantity;
    private double confidenceScore;
    private boolean isMatched;

    public ExtractedMedicineItem() {}

    public String getRawScannedText() { return rawScannedText; }
    public void setRawScannedText(String rawScannedText) { this.rawScannedText = rawScannedText; }
    public String getMatchedMedicineId() { return matchedMedicineId; }
    public void setMatchedMedicineId(String matchedMedicineId) { this.matchedMedicineId = matchedMedicineId; }
    public String getMatchedMedicineName() { return matchedMedicineName; }
    public void setMatchedMedicineName(String matchedMedicineName) { this.matchedMedicineName = matchedMedicineName; }
    public String getGenericName() { return genericName; }
    public void setGenericName(String genericName) { this.genericName = genericName; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(double confidenceScore) { this.confidenceScore = confidenceScore; }
    public boolean isMatched() { return isMatched; }
    public void setMatched(boolean matched) { isMatched = matched; }
}
