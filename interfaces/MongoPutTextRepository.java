package com.srccode.interfaces;


import com.srccode.dto.LineAfterAnalysesDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPutTextRepository extends MongoRepository<LineAfterAnalysesDTO, ObjectId> {
    LineAfterAnalysesDTO findByStr(String str);
}
