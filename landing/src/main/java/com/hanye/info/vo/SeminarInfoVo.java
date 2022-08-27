package com.hanye.info.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeminarInfoVo {

	private List<SeminarVo> seminarVoList;
	private List<String> groupNameList;
	private List<String> sessionPlaceList;
	private List<String> sessionTimeList;
	private SeminarVo seminarVo;
	
	
}
