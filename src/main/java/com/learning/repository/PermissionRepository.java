package com.learning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{

}
