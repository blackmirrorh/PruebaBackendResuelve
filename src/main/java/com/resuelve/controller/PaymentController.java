package com.resuelve.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resuelve.model.Players;

@RestController
public class PaymentController {
	
	@GetMapping("/getPayment")
	public ResponseEntity<Players> getPayment(@RequestBody Players players){
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

}
