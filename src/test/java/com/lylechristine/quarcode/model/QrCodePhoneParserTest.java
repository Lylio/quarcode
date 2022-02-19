package com.lylechristine.quarcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodePhoneParserTest {

    @Test
    public void thatParsePhonePasses() {
        String expected = "tel:+495551234567";
        QrCodePhone qrCodePhone = new QrCodePhone("+495551234567");
        assertEquals(expected, new QrCodePhoneParser(qrCodePhone).parse());
    }
}

