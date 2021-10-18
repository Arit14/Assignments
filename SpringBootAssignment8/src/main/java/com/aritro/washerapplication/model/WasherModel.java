package com.aritro.washerapplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washer")
public class WasherModel {
	
	@Id
    private String washerId;
    private String washerName;
    private Long washerContactNo;
    private String city;
	private String location;
    private String packages;
 
    public WasherModel(){

    }
    public WasherModel(String washerId, String washerName, Long washerContactNo, String city, String location,String packages) {
        this.washerId = washerId;
        this.washerName = washerName;
        this.washerContactNo = washerContactNo;
        this.city = city;
        this.location = location;
        this.packages=packages;
    }

    public String getWasherId() {
        return washerId;
    }

    public void setWasherId(String washerId) {
        this.washerId = washerId;
    }

    public String getWasherName() {
        return washerName;
    }

    public void setWasherName(String washerName) {
        this.washerName = washerName;
    }

    public Long getWasherContactNo() {
        return washerContactNo;
    }

    public void setWasherContactNo(Long washerContactNo) {
        this.washerContactNo = washerContactNo;
    }

    
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
    
    

    

}
