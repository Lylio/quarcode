package com.lylechristine.quarcode.controller;

import com.lylechristine.quarcode.config.ApplicationProperties;
import com.lylechristine.quarcode.model.*;
import com.lylechristine.quarcode.service.QuarcodeEncoder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class QuarcodeController {

    private final static String PAGE_INDEX = "index";
    private final static String PAGE_RESULT = "result";
    private final static String PAGE_QR_CODE_URL = "quarcode-url";

    private final ApplicationProperties applicationProperties;
    private final QuarcodeEncoder quarcodeEncoder;

    public QuarcodeController(ApplicationProperties applicationProperties, QuarcodeEncoder quarcodeEncoder) {
        this.applicationProperties = applicationProperties;
        this.quarcodeEncoder = quarcodeEncoder;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        return PAGE_INDEX;
    }

    @GetMapping("/quarcode-url")
    public String quarcodeUrl(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("quarcode-url", new QuarcodeUrl());
        return PAGE_QR_CODE_URL;
    }

    private void addCommonModelAttributes(@NotNull Model model) {
        model.addAttribute("titleMessage", this.applicationProperties.getTitle());
        model.addAttribute("appInfo", this.applicationProperties.getAppInfo());
    }
}
