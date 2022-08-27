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
        
		public SeminarVo(String groupName, String sessionPlace, String sessionTime) {
			super();
			this.groupName = groupName;
			this.sessionPlace = sessionPlace;
			this.sessionTime = sessionTime;
		}
        
        
        
}