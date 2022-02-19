package com.lylechristine.quarcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeUrlParserTest {

    @Test
    public void thatParseUrlPasses() {
        String expected = "http://www.google.com";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }

    @Test
    public void thatParseUrlWithBlanksPasses() {
        String expected = "http://www.google.com?value=My%20Site";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.com?value=My%20Site");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }
}
