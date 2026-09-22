package com.getmedbd.ai.handwriting;

import android.graphics.Bitmap;

/**
 * AI Vision API fallback service for complex or handwritten doctor prescriptions
 * Used when traditional OCR (Tesseract) confidence is low or fails to extract text
 */
public class HandwritingAIService {

    public String analyzeHandwrittenPrescription(String imagePath) {
        // Send prescription image to Vision AI API (e.g. Gemini Vision / Cloud Vision)
        // Extract doctor's handwriting including medicine names, strength, and dosages
        return null;
    }

    public String analyzeHandwrittenPrescription(Bitmap bitmap) {
        // Encode bitmap to Base64 and process via AI Vision API
        return null;
    }

    public String correctOcrWithAI(String rawOcrText) {
        // Use LLM API to fix misspelled pharmaceutical names from raw OCR output
        return null;
    }
}