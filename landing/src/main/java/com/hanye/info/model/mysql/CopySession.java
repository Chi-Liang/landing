package com.hanye.info.model.mysql;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import lombok.Data;

@Entity
@Data
public class CopySession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqNo;
	
	@Column(length = 100)
	private Long groupNameId;
	
	@Column(length = 100)
	private String sessionPlace;
	
	@Column(length = 100)
	private String sessionTime;
	
	@ManyToOne
	@JoinColumn(name="groupNameId", referencedColumnName="seqNo",insertable = false, updatable = false)
	private CopyWriter copyWriter;
	
}
