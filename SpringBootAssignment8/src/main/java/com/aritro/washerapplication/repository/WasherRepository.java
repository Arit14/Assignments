package com.aritro.washerapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aritro.washerapplication.model.WasherModel;

public interface  WasherRepository extends MongoRepository<WasherModel,String> {

}
