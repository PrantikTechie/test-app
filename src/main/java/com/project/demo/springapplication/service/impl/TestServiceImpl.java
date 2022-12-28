package com.project.demo.springapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.springapplication.model.TestModel;
import com.project.demo.springapplication.repository.ParamRepository;
import com.project.demo.springapplication.repository.TestRepository;
import com.project.demo.springapplication.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestRepository testRepo;
	
	@Autowired
	ParamRepository paramRepo;
	
	public List<TestModel> getTests(){
		return testRepo.findAll();
	}

	@Override
	public Optional<TestModel> getTest(String id) {
		return testRepo.findById(id);
	}

	@Override
	public TestModel saveTest(TestModel model) {
		return testRepo.save(model);
	}

	@Override
	public void deleteTest(String id) {
		testRepo.deleteById(id);
		
	}
	
	@Override
	public Optional<List<TestModel>> getAllParamByInputReferenceType(String inputReferenceType){
		return paramRepo.findAllByInputReferenceType(inputReferenceType);
	}

}
