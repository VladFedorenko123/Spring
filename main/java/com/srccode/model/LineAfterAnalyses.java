package com.srccode.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@Document(collection = "Analyses")
public class LineAfterAnalyses {
    @Id
    private ObjectId id;
    private String str;
    private String vowelsNumber;
    private String consonantsNumber;
    private String timestamp;
    private String requestCounter;
}
