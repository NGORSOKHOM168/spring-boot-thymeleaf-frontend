package com.learning.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Sequence;

@Repository
public interface SequenceRepository extends CrudRepository<Sequence, Long>{
	Sequence findByTableName(String tableName);	
}
