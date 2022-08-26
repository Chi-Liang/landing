package com.hanye.info.model.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class MongoSequence {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Long getNextId(String collName) {
		return query(collName);

	}

	private long query(String collName) {
		collName = collName.toLowerCase();
		var query = new Query(Criteria.where("id").is(collName));
		var update = new Update();
		update.inc("nextId", 1);
		var options = new FindAndModifyOptions();
		options.returnNew(true);
		options.upsert(true);
		var seqId = mongoTemplate.findAndModify(query, update, options, AutoSequence.class,
				collName + ".nextId");

		return seqId.getNextId();

	}

}
