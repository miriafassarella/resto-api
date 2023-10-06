package com.mabrasoft.restoapi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mabrasoft.restoapi.domain.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	List<Permission> name(String name);
}
