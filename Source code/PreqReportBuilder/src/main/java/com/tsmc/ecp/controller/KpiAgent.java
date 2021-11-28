package com.tsmc.ecp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KpiAgent {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World")String _name) {
        String response = "Welcome to join us, %s";
        return String.format(response, _name);
    }



}
