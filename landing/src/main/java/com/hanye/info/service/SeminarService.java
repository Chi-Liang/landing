package com.hanye.info.service;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.function.SeminarPredicate;
import com.hanye.info.model.mongo.Seminar;
import com.hanye.info.repository.mongo.SeminarRepository;
import com.hanye.info.sequence.MongoSequence;
import com.hanye.info.vo.SeminarInfoVo;
import com.hanye.info.vo.SeminarVo;

@Service
public class SeminarService {

	@Autowired
	private SeminarRepository seminarRepository;

	@Autowired
	private MongoSequence mongoSequence;

	@Autowired
	private MongoTemplate mongoTemplate;

	private static BeanCopier voToEntity = BeanCopier.create(SeminarVo.class, Seminar.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(Seminar.class, SeminarVo.class, true);

	public SeminarInfoVo findAll(String groupName, String sessionPlace, String sessionTime) {

		SeminarPredicate<String, String, String> predicate = findAllfilter(groupName, sessionPlace, sessionTime);

		List<SeminarVo> voList = seminarRepository.findAll().stream().filter(
				seminar -> predicate.test(seminar.getGroupName(), seminar.getSessionPlace(), seminar.getSessionTime()))
				.map(seminar -> {
					var seminarVo = new SeminarVo();
					entityToVo.copy(seminar, seminarVo, new BeanConverter());
					return seminarVo;
				}).collect(Collectors.toList());

		var groupNameList = mongoTemplate.query(Seminar.class).distinct("groupName").as(String.class).all();

		var sessionPlaceList = mongoTemplate.query(Seminar.class).distinct("sessionPlace").as(String.class).all();

		var sessionTimeList = mongoTemplate.query(Seminar.class).distinct("sessionTime").as(String.class).all();

		return new SeminarInfoVo(voList, groupNameList, sessionPlaceList, sessionTimeList,
				new SeminarVo(groupName, sessionPlace, sessionTime));
	}

	public void saveSeminar(SeminarVo seminarVo) {
		var seminar = new Seminar();
		voToEntity.copy(seminarVo, seminar, null);
		seminar.setSeqNo(mongoSequence.getNextId("autoSequence"));
		seminarRepository.save(seminar);
	}

	private SeminarPredicate<String, String, String> findAllfilter(String groupName, String sessionPlace,
			String sessionTime) {

		SeminarPredicate<String, String, String> predicate = (t, s, r) -> {

			boolean groupNameResult = false;
			boolean sessionPlaceResult = false;
			boolean sessionTimeResult = false;

			if (StringUtils.isBlank(groupName)) {
				groupNameResult = true;
			} else if (StringUtils.equals(groupName, t)) {
				groupNameResult = true;
			}
			if (StringUtils.isBlank(sessionPlace)) {
				sessionPlaceResult = true;
			} else if (StringUtils.equals(sessionPlace, s)) {
				sessionPlaceResult = true;
			}
			if (StringUtils.isBlank(sessionTime)) {
				sessionTimeResult = true;
			} else if (StringUtils.equals(sessionTime, r)) {
				sessionTimeResult = true;
			}
			return groupNameResult && sessionPlaceResult && sessionTimeResult;
		};

		return predicate;

	}

}
