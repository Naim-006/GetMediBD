package com.getmedbd.data.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Result model returned after processing a prescription image via OCR & AI matching
 */
public class PrescriptionMatchResult implements Serializable {
    private String prescriptionId;
    private String rawExtractedText;
    private String extractionMethod; // "TESSERACT_OCR" or "AI_HANDWRITING_API"
    private double overallConfidence;
    private List<ExtractedMedicineItem> matchedMedicines = new ArrayList<>();
    private List<String> unmatchedLines = new ArrayList<>();

    public PrescriptionMatchResult() {}

    public String getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(String prescriptionId) { this.prescriptionId = prescriptionId; }
    public String getRawExtractedText() { return rawExtractedText; }
    public void setRawExtractedText(String rawExtractedText) { this.rawExtractedText = rawExtractedText; }
    public String getExtractionMethod() { return extractionMethod; }
    public void setExtractionMethod(String extractionMethod) { this.extractionMethod = extractionMethod; }
    public double getOverallConfidence() { return overallConfidence; }
    public void setOverallConfidence(double overallConfidence) { this.overallConfidence = overallConfidence; }
    public List<ExtractedMedicineItem> getMatchedMedicines() { return matchedMedicines; }
    public void setMatchedMedicines(List<ExtractedMedicineItem> matchedMedicines) { this.matchedMedicines = matchedMedicines; }
    public List<String> getUnmatchedLines() { return unmatchedLines; }
    public void setUnmatchedLines(List<String> unmatchedLines) { this.unmatchedLines = unmatchedLines; }
}
