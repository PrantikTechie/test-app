package com.project.demo.springapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.project.demo.springapplication.model.TestModel;

public interface ParamRepository extends JpaRepository<TestModel, Integer>, JpaSpecificationExecutor<TestModel>{
	Optional<List<TestModel>> findAllByInputReferenceType(String inputReferenceType);
	Optional<List<TestModel>> findAllByReferenceId(String referenceId);

}
