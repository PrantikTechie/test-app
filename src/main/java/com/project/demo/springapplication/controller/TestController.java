package com.project.demo.springapplication.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.springapplication.model.TestModel;
import com.project.demo.springapplication.repository.ParamRepository;
import com.project.demo.springapplication.service.impl.TestServiceImpl;

@RestController
public class TestController {
	
	@Autowired
	TestServiceImpl testServiceImpl;
	
	@Autowired
	ParamRepository paramRepo;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/test")
	public ResponseEntity<List<TestModel>> getTest() {
		System.out.println("########### OK");
		List<TestModel> modelList = testServiceImpl.getTests();
		return new ResponseEntity<>(modelList,HttpStatus.OK);
	}
	
	@GetMapping("/test/{testId}")
	public ResponseEntity<TestModel> getTests(@PathVariable("testId") String testId) {
		TestModel model = testServiceImpl.getTest(testId).get();
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	@PostMapping("/test")
	public ResponseEntity<TestModel> saveTest(@Valid @RequestBody TestModel model) {
		System.out.println(model);
		TestModel saveModel =testServiceImpl.saveTest(model);
		return new ResponseEntity<>(saveModel,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/test/{testId}",consumes = MediaType.APPLICATION_JSON_VALUE, 
			  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestModel> updateTest(@PathVariable("testId") int testId , @RequestBody TestModel model ) {
		System.out.println("UPDATE TEST for " + testId);
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	@DeleteMapping("/test/{id}")
	public ResponseEntity<String> deleteTest(@PathVariable String id) {
		testServiceImpl.deleteTest(id);
		return new ResponseEntity<>("Deleted model with id = "+id,HttpStatus.NO_CONTENT);
	}
	@GetMapping("/test/nameAndVersion")
	public String testGetNameAndVersion() {
		String id = UUID.randomUUID().toString();
		return "The name of the application is "+appName+" and its version is "+appVersion+" id is "+id;
	}
	
	@GetMapping("/param/getParams/{inputReferenceType}")
	public ResponseEntity<List<TestModel>> getAllParams(@PathVariable String inputReferenceType){
		System.out.println("START%%%%%%%%5555");
		Optional<List<TestModel>> list = testServiceImpl.getAllParamByInputReferenceType(inputReferenceType);
		return new ResponseEntity<>(list.get(),HttpStatus.OK);
	}
	
	@GetMapping("/param/updateReferenceType/{inputReferenceType}")
	public void updateParams(@PathVariable String inputReferenceType){
		System.out.println("START######### go");
		System.out.println("######### Fetching all the input params from DB of WORKFLOW ref type");
		List<TestModel> list = testServiceImpl.getAllParamByInputReferenceType(inputReferenceType).get();
		for(TestModel l : list) {
			String oldRefId = l.getReferenceId();
			if(oldRefId.contains("_")) {
				String newRefId = oldRefId.substring(0, oldRefId.indexOf("_"));
				List<TestModel> refList = paramRepo.findAllByReferenceId(newRefId).get();
				for(TestModel l1 : refList) {
					if(l1.getInputReferenceType().equalsIgnoreCase("GLOBAL")) {
						l.setInputReferenceType("WORKFLOW_GLOBAL");
					}
				}
			}
			System.out.println("######## Updated Param"+ l);
		}
	}
	
}
