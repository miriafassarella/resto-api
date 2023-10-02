package com.mabrasoft.restoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;
import com.mabrasoft.restoapi.domain.model.FormOfPayment;

import com.mabrasoft.restoapi.domain.repository.FormOfPaymentRepository;


@Service
public class FormOfPaymentService {

	@Autowired
	FormOfPaymentRepository paymentService;
	
	public List<FormOfPayment> list(){
		return paymentService.findAll();
	}
	
	public FormOfPayment search(Long paymentId){
		Optional<FormOfPayment> payment = paymentService.findById(paymentId);
		return payment.get();
	}
	
	public FormOfPayment add(FormOfPayment payment) {
		return paymentService.save(payment);
	}
	
	public void remove(Long paymentId) {
		Optional<FormOfPayment> payment = paymentService.findById(paymentId);
		paymentService.delete(payment.get());
	}
	
	public FormOfPayment update(Long paymentId, FormOfPayment payment) {
		Optional<FormOfPayment> paymentCurrent = paymentService.findById(paymentId);
		
		if(paymentCurrent.isPresent()) {
			BeanUtils.copyProperties(payment, paymentCurrent.get(), "id");
			return paymentService.save(paymentCurrent.get());
		}
		throw new EntityNotFoundException(String.format("The code %d form of payment does not exist", paymentId));
	}
}
