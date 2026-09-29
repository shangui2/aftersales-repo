package com.demo.aftersales.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RiskControlEngine {
    public boolean checkRisk(String userId) {
        log.info("Checking risk for user: {}", userId);
        return true; 
    }
}
