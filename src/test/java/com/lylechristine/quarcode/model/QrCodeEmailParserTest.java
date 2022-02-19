package com.lylechristine.quarcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeEmailParserTest {

    @Test
    public void thatParseEmailAddressPasses() {
        String expected = "mailto:person@mail.com";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("person@mail.com");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }

    @Test
    public void thatParseEmailAddressAndSubjectPasses() {
        String expected = "mailto:person@mail.com?subject=Hello";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("person@mail.com");
        qrCodeEmail.setSubjectToBeEncoded("Hello");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }

    @Test
    public void thatParseEmailAndSubjectWithBlanksPasses() {
        String expected = "mailto:email@email.com?subject=My%20Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        qrCodeEmail.setSubjectToBeEncoded("My Subject");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }
}
