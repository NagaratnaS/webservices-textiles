package com.wolken.wolkenapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.dto.TextileDTO;
import com.wolken.wolkenapp.service.TextileService;

@RestController
@RequestMapping("/")
public class TextileController {
	
	@Autowired
	TextileService service;
	
	@GetMapping("/")
	public String index() {
		return "Hello world!!";
	}
	
	@PostMapping("/save")
	public String save(@RequestBody TextileDTO dto) {
		System.out.println("Hi" + dto.getTextileShopID());
		String message = service.validateAndAdd(dto);
		return message;
	}
	
	
	
	

}