package com.hanye.info.vo;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

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
        private Long seminarId;
        private String seminarSession;
        private String groupId;
        private String createDate;
        
}