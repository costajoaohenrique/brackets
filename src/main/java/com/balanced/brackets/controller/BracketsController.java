package com.balanced.brackets.controller;

import com.balanced.brackets.service.BracketsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * BracketsController
 */
@RestController
@RequestMapping("/api")
public class BracketsController {

    @Autowired
    private BracketsService service;

    @RequestMapping(value = "/valid/{sequence}", method = RequestMethod.GET, produces = {"application/json"})
    public boolean isBracketValid(@PathVariable String sequence){
        return service.isValid(sequence);
    }
}