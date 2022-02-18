package com.lylechristine.quarcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Validated
public class QrCodeEmail {

    @NotEmpty
    private String emailToBeEncoded = "";

    private String subjectToBeEncoded = "";

    public QrCodeEmail() {
    }

    public QrCodeEmail(@NotEmpty String emailToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
    }

    public QrCodeEmail(String emailToBeEncoded, String subjectToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
        this.subjectToBeEncoded = subjectToBeEncoded;
    }
}
