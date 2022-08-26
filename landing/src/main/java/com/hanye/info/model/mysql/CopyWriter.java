package com.hanye.info.model.mysql;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CopyWriter {
	
	@Id
    private Long seqNo;
	
	@Column(length = 100)
	private String groupName;
	
}
