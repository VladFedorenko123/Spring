package com.srccode.dao;

import com.srccode.model.LineAfterAnalyses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineAfterAnalysesRepository extends MongoRepository<LineAfterAnalyses, ObjectId> {
    LineAfterAnalyses findByStr(String str);
}
