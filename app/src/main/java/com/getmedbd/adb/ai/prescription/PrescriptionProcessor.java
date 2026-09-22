package com.getmedbd.ai.prescription;

import android.graphics.Bitmap;
import com.getmedbd.ai.handwriting.HandwritingAIService;
import com.getmedbd.ai.matcher.MedicineMatcher;
import com.getmedbd.data.models.Medicine;
import com.getmedbd.data.models.PrescriptionMatchResult;
import com.getmedbd.ocr.tesseract.TesseractOCRService;
import java.util.List;

/**
 * Orchestrator pipeline for Prescription Digitization and Medicine Matching:
 * 1. Executes on-device Tesseract OCR on the prescription image.
 * 2. Checks recognition confidence / handwriting detection.
 * 3. Falls back to Handwriting AI API if OCR fails or confidence is below threshold.
 * 4. Passes extracted text to MedicineMatcher to match against medicine database.
 */
public class PrescriptionProcessor {

    private final TesseractOCRService tesseractOCRService;
    private final HandwritingAIService handwritingAIService;
    private final MedicineMatcher medicineMatcher;

    public PrescriptionProcessor() {
        this.tesseractOCRService = new TesseractOCRService();
        this.handwritingAIService = new HandwritingAIService();
        this.medicineMatcher = new MedicineMatcher();
    }

    public PrescriptionMatchResult processPrescriptionImage(String imagePath, List<Medicine> catalog) {
        // Run OCR, fallback to AI if handwriting detected/confidence low, match medicines
        return null;
    }

    public PrescriptionMatchResult processPrescriptionBitmap(Bitmap bitmap, List<Medicine> catalog) {
        // Process bitmap through the hybrid OCR -> AI -> Matcher pipeline
        return null;
    }
}