package com.hanye.info.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hanye.info.model.mysql.CopySession;

@Repository
public interface CopySessionRepository extends JpaRepository<CopySession, Long> {
	
}
