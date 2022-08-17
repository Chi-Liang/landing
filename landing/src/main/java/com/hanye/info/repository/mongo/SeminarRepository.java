package com.hanye.info.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hanye.info.model.mongo.Seminar;

public interface SeminarRepository extends MongoRepository<Seminar, String> {

    
}
