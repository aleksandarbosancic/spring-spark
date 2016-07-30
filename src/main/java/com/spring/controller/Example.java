/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.model.MyMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aleksandar
 */
@RestController
public class Example {
    
    @RequestMapping("/")
    public String init() {
        return "Hello from Spring!";
    }
    
    @RequestMapping("/example")
    public MyMessage model() {
        return new MyMessage(1, "Hello from Spring");
    }
    
}
