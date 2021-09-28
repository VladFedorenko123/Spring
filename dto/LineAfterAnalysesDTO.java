package com.srccode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Analyses")
public class LineAfterAnalysesDTO {
    @Id
    private ObjectId id;
    private String str;
    private String vowelsNumber;
    private String consonantsNumber;
    private String timestamp;
    private String requestCounter;


    public LineAfterAnalysesDTO(String vowelsNumber, String consonantsNumber,
                                String timestamp) {
        this.vowelsNumber = vowelsNumber;
        this.consonantsNumber = consonantsNumber;
        this.timestamp = timestamp;
    }
}
