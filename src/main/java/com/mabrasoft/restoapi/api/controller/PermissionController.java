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


import com.mabrasoft.restoapi.domain.model.Permission;

import com.mabrasoft.restoapi.domain.service.PermissionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/permissions")
@Tag(name = "Permissions")
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Permission> cityList(){
		return permissionService.list();
	}
	
	@GetMapping("/byname")
	public List<Permission> byName(String name){
		return permissionService.byName(name);
	}
	@GetMapping("/{cityId}")
	public ResponseEntity<Permission> cityByName(@PathVariable Long permissionId){
		Permission permission = permissionService.search(permissionId);
		return ResponseEntity.status(HttpStatus.FOUND).body(permission);
	}
	
	@PostMapping
	public ResponseEntity<Permission> add(@RequestBody Permission permission){
		Permission permissionSave = permissionService.add(permission);
		return ResponseEntity.status(HttpStatus.CREATED).body(permissionSave);
	}
	
	@DeleteMapping("/{permissionId}")
	public ResponseEntity<Permission> remove(@PathVariable Long permissionId){
		permissionService.remove(permissionId);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/{permissionId}")
	public ResponseEntity<?> update(@PathVariable Long permissionId, @RequestBody Permission permission){
		Permission permissionCurrent = permissionService.update(permissionId, permission);
		return ResponseEntity.status(HttpStatus.OK).body(permissionCurrent);
	}
}
