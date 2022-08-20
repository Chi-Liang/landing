package com.hanye.info.model.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("seminar")
public class Seminar {
	
	@Id
	private Long seqNo;
    private String name;
    private String email;
    private String groupName;
    private String sessionPlace;
    private String sessionTime;
        
}