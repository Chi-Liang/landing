package com.hanye.info.model.mysql;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class CopyWriter {
	
	@Id
    private Long seqNo;
	
	@Column(length = 1000)
	private String groupName;
	
	@OneToMany(mappedBy = "copyWriter")
	private List<CopySession> copySessions;
	
}
