package com.mabrasoft.restoapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mabrasoft.restoapi.domain.model.FormOfPayment;

import com.mabrasoft.restoapi.domain.service.FormOfPaymentService;


@RestController
@RequestMapping("/methodspayments")
public class FormOfPaymentController {

	@Autowired
	FormOfPaymentService paymentService;
	

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<FormOfPayment> cityList(){
		return paymentService.list();
	}
	
	@GetMapping("/{cityId}")
	public ResponseEntity<FormOfPayment> cityByName(@PathVariable Long paymentId){
		FormOfPayment payment = paymentService.search(paymentId);
		return ResponseEntity.status(HttpStatus.FOUND).body(payment);
	}
	
	@PostMapping
	public ResponseEntity<FormOfPayment> add(@RequestBody FormOfPayment payment){
		FormOfPayment paymentSave = paymentService.add(payment);
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentSave);
	}
	
	@DeleteMapping("/{cityId}")
	public ResponseEntity<FormOfPayment> remove(@PathVariable Long paymentId){
		paymentService.remove(paymentId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/{cityId}")
	public ResponseEntity<?> update(@PathVariable Long paymentId, @RequestBody FormOfPayment payment){
		FormOfPayment paymentCurrent = paymentService.update(paymentId, payment);
		return ResponseEntity.status(HttpStatus.OK).body(paymentCurrent);
	}
}
