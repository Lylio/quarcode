package com.lylechristine.quarcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * Format: http://google.com
 */
@Getter
@Setter
@Validated
public class QuarcodeUrl {

    @NotEmpty
    private String urlToBeEncoded;

    public QuarcodeUrl() {
    }

    public QuarcodeUrl(String urlToBeEncoded) {
        this.urlToBeEncoded = urlToBeEncoded;
    }
}
