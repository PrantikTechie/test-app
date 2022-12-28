package com.project.demo.springapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;


import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "test_param")
public class TestModel {
	
	/**
     * Serial UID
     */
    private static final long serialVersionUID = -7430239588044572851L;
    
    @Id
    @Column(name = "param_id", nullable = false)
    private String paramId;

    //flow id , schedular id , datasource id
    @Column(name = "REFERENCE_ID", nullable = true)
    private String referenceId;        //

    //INPUT,CALCULATED,SQL,SYSTEM,
    @Column(name = "INPUT_PARAMETER_TYPE", nullable = false)
    private String inputParameterType;

    //Integer, Float, Date, String, Boolean
    @Column(name = "INPUT_PARAMETER_DATA_TYPE", nullable = false)
    private String inputParameterDataType;

    @Column(name = "PARAMETER_NAME", nullable = false)
    private String inputParameterName;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "PARAMETER_VALUE", nullable = false)
    private String parameterValue;

    @Column(name = "INPUT_REFERENCE_TYPE", nullable = false)
    private String inputReferenceType;

    @Column(name = "VERSION")
    private String version;


    @Column(name = "PROJECT_ID")
    private String projectId;
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
	
}
