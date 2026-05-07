package com.eazybytes.eazybytes.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logging")
@Slf4j
public class LoggingController {

//    private static final Logger log = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping
    public ResponseEntity<String> testLog() {
        log.trace("🔍 TRACE : This is a very detailed trace log .Used for tracking execution flow");
        log.debug("🐞 DEBUG : This is a debug message . Used fro debugging");
        log.info("❗ INFO : This is a info message . Application events");
        log.warn("⚠️ WARN : This is a warn message . Something might go wrong");
        log.error("💀 ERROR : This is an error message . This needs immediate attention");
        return ResponseEntity.ok("Logging tested successfully");
    }
}
