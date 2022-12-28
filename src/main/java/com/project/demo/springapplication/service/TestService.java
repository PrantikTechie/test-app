package com.project.demo.springapplication.service;

import java.util.List;
import java.util.Optional;

import com.project.demo.springapplication.model.TestModel;

public interface TestService {
	
	List<TestModel> getTests();
	
	Optional<TestModel> getTest(String id);
	
	TestModel saveTest(TestModel model);
	
	void deleteTest(String id);
	
	Optional<List<TestModel>> getAllParamByInputReferenceType(String inputReferenceType);

}
