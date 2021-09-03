package com.resuelve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resuelve.service.IPaymentService;
import com.resuelve.model.Players;

@RestController
public class PaymentController {
	
	@Autowired
	private IPaymentService service;
	
	@GetMapping("/getPayment")
	public ResponseEntity<Players> getPayment(@RequestBody Players players){
		return new ResponseEntity<>(service.returnPayment(players), HttpStatus.OK);
	}

}
