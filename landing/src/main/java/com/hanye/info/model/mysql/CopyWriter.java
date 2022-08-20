package com.hanye.info.model.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class CopyWriter {
	
	@Id
    private Long seqNo;
	
	@Column(length = 1000)
	private String groupName;
	
	@OneToOne(mappedBy = "copyWriter")
	private CopySession copySession;
	
}
