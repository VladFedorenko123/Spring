package com.srccode.interfaces;

import com.srccode.dto.TextMongoDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoTextRepository extends MongoRepository<TextMongoDTO, ObjectId> {
}
