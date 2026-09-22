package com.getmedbd.db.models;

import java.io.Serializable;

/**
 * Model representing an extracted medicine candidate from OCR/AI
 */
public class ExtractedMedicineItem implements Serializable {
    private String rawScannedText;
    private String matchedMedicineId;
    private double confidenceScore;

    public ExtractedMedicineItem() {}

    public String getRawScannedText() { return rawScannedText; }
    public void setRawScannedText(String rawScannedText) { this.rawScannedText = rawScannedText; }
    public String getMatchedMedicineId() { return matchedMedicineId; }
    public void setMatchedMedicineId(String matchedMedicineId) { this.matchedMedicineId = matchedMedicineId; }
    public double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(double confidenceScore) { this.confidenceScore = confidenceScore; }
}
