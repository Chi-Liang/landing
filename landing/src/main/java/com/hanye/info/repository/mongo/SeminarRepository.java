package com.hanye.info.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.hanye.info.model.mongo.Seminar;

@Repository
public interface SeminarRepository extends MongoRepository<Seminar, Long> {
	
	
}
