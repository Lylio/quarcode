package com.lylechristine.quarcode.service;

import com.lylechristine.quarcode.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QrCodeEncoderTest {

    @Autowired
    QrCodeEncoder qrCodeEncoder;

    @Test
    public void generateQrCodeUrl() {
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodeEmail() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodeEmailAndSubject() {
        QrCodeEmail qrCodeEmail = new QrCodeEmail("email@email.com", "just a test");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }

    @Test
    public void generateQrCodePhone() {
        QrCodePhone qrCodePhone = new QrCodePhone("+15551234567");
        QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
        assertTrue(result.isSuccessfull());
        assertNotNull(result.getSuccessMessage());
        assertNotNull(result.getImage());
        assertNotNull(result.getEncodedText());
        assertNull(result.getErrorMessage());
    }
}
