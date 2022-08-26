package com.hanye.info.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hanye.info.model.mysql.CopyWriter;

@Repository
public interface CopyWriterRepository extends JpaRepository<CopyWriter, Long> {
	
	@Query(nativeQuery = true, value = "select ifnull(max(seq_no),0) + 1 from copy_writer")
	public Long getMaxSeqNo();
	
	@Query(nativeQuery = true, value = "select group_name from copy_writer where seq_no = :seqNo ")
	public String getGroupName(Long seqNo);
	
	
}
