package com.lylechristine.quarcode.controller;

import com.lylechristine.quarcode.config.ApplicationProperties;
import com.lylechristine.quarcode.model.QrCodeProcessingResult;
import com.lylechristine.quarcode.model.QrCodeUrl;
import com.lylechristine.quarcode.service.QrCodeEncoder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class QrCodeController {

    private final static String PAGE_INDEX = "index";
    private final static String PAGE_RESULT = "result";
    private final static String PAGE_QR_CODE_URL = "qr-code-url";
    private final static String QR_CODE = "image";
    private final static String TEXT_TO_BE_ENCODED = "text";
    private final static String SUCCESS_MESSAGE = "successMessage";
    private final static String ERROR_MESSAGE = "errorMessage";

    private final ApplicationProperties applicationProperties;
    private final QrCodeEncoder qrCodeEncoder;

    public QrCodeController(ApplicationProperties applicationProperties, QrCodeEncoder qrCodeEncoder) {
        this.applicationProperties = applicationProperties;
        this.qrCodeEncoder = qrCodeEncoder;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        return PAGE_INDEX;
    }

    @GetMapping("/qr-code-url")
    public String qrCodeUrl(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeUrl", new QrCodeUrl());
        return PAGE_QR_CODE_URL;
    }

    @PostMapping("/process/url")
    public String processUrl(Model model,
                             @Valid @ModelAttribute("qrCodeUrl") QrCodeUrl qrCodeUrl,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Url {}", qrCodeUrl.getUrlToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_URL;
    }

    private void addCommonModelAttributes(@NotNull Model model) {
        model.addAttribute("titleMessage", this.applicationProperties.getTitle());
        model.addAttribute("appInfo", this.applicationProperties.getAppInfo());
    }

    private void addResultModelAttributes(@NotNull Model model, @NotNull QrCodeProcessingResult result) {
        model.addAttribute(QR_CODE, result.getImage());
        model.addAttribute(TEXT_TO_BE_ENCODED, result.getEncodedText());
        if (result.isSuccessfull()) {
            model.addAttribute(SUCCESS_MESSAGE, result.getSuccessMessage());
        } else {
            model.addAttribute(ERROR_MESSAGE, result.getErrorMessage());
        }
    }
}
