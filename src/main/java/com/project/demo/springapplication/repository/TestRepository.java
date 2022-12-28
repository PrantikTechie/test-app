package com.project.demo.springapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.project.demo.springapplication.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, String>, JpaSpecificationExecutor<TestModel> {
}
