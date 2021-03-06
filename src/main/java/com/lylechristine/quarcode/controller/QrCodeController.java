package com.lylechristine.quarcode.controller;

import com.lylechristine.quarcode.config.ApplicationProperties;
import com.lylechristine.quarcode.model.*;
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
    private final static String PAGE_QR_CODE_PHONE = "qr-code-phone";
    private final static String PAGE_QR_CODE_EMAIL = "qr-code-email";
    private final static String PAGE_QR_CODE_SMS = "qr-code-sms";
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

    @GetMapping("/qr-code-email")
    public String qrCodeEmail(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEmail", new QrCodeEmail());
        return PAGE_QR_CODE_EMAIL;
    }

    @PostMapping("/process/email")
    public String processEmail(Model model,
                               @Valid @ModelAttribute("qrCodeEmail") QrCodeEmail qrCodeEmail,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeEmail.getEmailToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_EMAIL;
    }

    @GetMapping("/qr-code-sms")
    public String qrCodeSms(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeSms", new QrCodeSms());
        return PAGE_QR_CODE_SMS;
    }

    @PostMapping("/process/sms")
    public String processSms(Model model,
                             @Valid @ModelAttribute("qrCodeSms") QrCodeSms qrCodeSms,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeSms.getPhoneToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeSms(qrCodeSms);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_SMS;
    }

    @GetMapping("/qr-code-phone")
    public String qrCodePhone(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodePhone", new QrCodePhone());
        return PAGE_QR_CODE_PHONE;
    }

    @PostMapping("/process/phone")
    public String processPhone(Model model,
                               @Valid @ModelAttribute("qrCodePhone") QrCodePhone qrCodePhone,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Phone number {}", qrCodePhone.getPhoneToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_PHONE;
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
