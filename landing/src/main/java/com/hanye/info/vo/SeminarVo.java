package com.hanye.info.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeminarVo {
	
	    private Long seqNo;
        private String name;
        private String email;
        private String groupName;
        private String sessionPlace;
        private String sessionTime;
        
}