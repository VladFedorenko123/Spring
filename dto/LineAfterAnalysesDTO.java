package com.srccode.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
