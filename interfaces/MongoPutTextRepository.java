package com.srccode.interfaces;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.srccode.dto.LineAfterAnalysesDTO;

public interface MongoPutTextRepository extends MongoRepository<LineAfterAnalysesDTO, ObjectId> {
    LineAfterAnalysesDTO findByStr(String str);
}
