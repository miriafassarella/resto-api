package com.mabrasoft.restoapi.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mabrasoft.restoapi.domain.exception.EntityNotFoundException;

import com.mabrasoft.restoapi.domain.model.Permission;

import com.mabrasoft.restoapi.domain.repository.PermissionRepository;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;
	
	public List<Permission> list(){
		return permissionRepository.findAll();
	}
	
	public List<Permission> byName(String name){
		return permissionRepository.name(name);
	}
	
	public Permission search(Long permissionId){
		Optional<Permission> permission = permissionRepository.findById(permissionId);
		return permission.get();
	}
	
	public Permission add(Permission permission) {
		return permissionRepository.save(permission);
	}
	
	public void remove(Long permissionId) {
		Optional<Permission> permission = permissionRepository.findById(permissionId);
		permissionRepository.delete(permission.get());
	}
	
	public Permission update(Long permissionId, Permission permission) {
		Optional<Permission> permissionCurrent = permissionRepository.findById(permissionId);
		
		if(permissionCurrent.isPresent()) {
			BeanUtils.copyProperties(permission, permissionCurrent.get(), "id");
			return permissionRepository.save(permissionCurrent.get());
		}
		throw new EntityNotFoundException(String.format("The code %d permission does not exist", permissionId));
	}
}
