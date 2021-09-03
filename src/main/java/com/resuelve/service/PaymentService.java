package com.resuelve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resuelve.dao.IPlayerDao;
import com.resuelve.model.Players;

@Service
public class PaymentService implements IPaymentService{

	@Autowired
	IPlayerDao dao;
	
	@Override
	public Players returnPayment(Players players) {
		return dao.returnPayment(players);
	}

}
