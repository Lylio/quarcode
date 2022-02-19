package com.lylechristine.quarcode.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ApplicationPropertiesTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    public void thatTitleIsValid() {
        String actual = this.applicationProperties.getTitle();
        assertNotNull(actual);
        assertEquals("quarcode", actual);
    }

    @Test
    public void thatAppInfoIsValid() {
        String actual = this.applicationProperties.getAppInfo();
        assertNotNull(actual);
    }
}
