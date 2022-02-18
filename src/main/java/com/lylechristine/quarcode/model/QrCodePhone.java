package com.lylechristine.quarcode.model;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Form:
 * <p>
 * tel:+12125551212
 */
@Getter
@Setter
@Validated
public class QrCodePhone {

    @NotEmpty
    private String phoneToBeEncoded;

    public QrCodePhone() {
    }

    public QrCodePhone(String phoneToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
    }
}

