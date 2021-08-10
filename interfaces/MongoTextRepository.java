package com.srccode.interfaces;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.srccode.dto.TextMongoDTO;

@Repository
public interface MongoTextRepository extends MongoRepository<TextMongoDTO, ObjectId> {
}
