package com.getmedbd.db.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Result model returned after processing a prescription image via OCR & AI matching
 */
public class PrescriptionMatchResult implements Serializable {
    private String prescriptionId;
    private String rawExtractedText;
    private double overallConfidence;

    public PrescriptionMatchResult() {}

    public String getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(String prescriptionId) { this.prescriptionId = prescriptionId; }
    public String getRawExtractedText() { return rawExtractedText; }
    public void setRawExtractedText(String rawExtractedText) { this.rawExtractedText = rawExtractedText; }
    public double getOverallConfidence() { return overallConfidence; }
    public void setOverallConfidence(double overallConfidence) { this.overallConfidence = overallConfidence; }
}
