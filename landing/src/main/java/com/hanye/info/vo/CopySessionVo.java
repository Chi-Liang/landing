package com.hanye.info.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CopySessionVo {
	
	private Long seqNo;
	private Long groupId;
	private String groupName;
	private String sessionPlace;
	private String sessionTime;
	
}
