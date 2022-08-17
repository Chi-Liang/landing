package com.hanye.info.model.mongo;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
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
        private Long seqNo = 0L;
        private String name;
        private String email;
        private Long seminarId;
        private String seminarSession;
        private String groupId;
        private Date createDate;
        
}