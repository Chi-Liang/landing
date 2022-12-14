package com.hanye.info.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CopySession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqNo;
	
	@Column(length = 100)
	private String groupName;
	
	@Column(length = 100)
	private String sessionPlace;
	
	@Column(length = 100)
	private String sessionTime;
	
}
