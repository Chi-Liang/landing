package com.hanye.info.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mongo.MongoSequence;
import com.hanye.info.model.mongo.Seminar;
import com.hanye.info.repository.mongo.SeminarRepository;
import com.hanye.info.vo.SeminarVo;

@Service
public class SeminarService {

	@Autowired
	private SeminarRepository seminarRepository;
	
	@Autowired
	private MongoSequence mongoSequence;
	
	private static BeanCopier voToEntity = BeanCopier.create(SeminarVo.class, Seminar.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(Seminar.class, SeminarVo.class, true);

	public List<SeminarVo> findAll() {
		
		List<SeminarVo> voList = seminarRepository.findAll().stream().map( seminar -> {
			var seminarVo = new SeminarVo();
			entityToVo.copy(seminar, seminarVo, new BeanConverter());
			return seminarVo;
		}).collect(Collectors.toList());
		return voList;
	}

	public SeminarVo findSeminar(Long seqNo) {
		var seminar = seminarRepository.findById(seqNo).get();
		var seminarVo = new SeminarVo();
		entityToVo.copy(seminar, seminarVo, new BeanConverter());
		return seminarVo;
	}

	public void saveSeminar(SeminarVo seminarVo) {
		var seminar = new Seminar();
		voToEntity.copy(seminarVo, seminar, null);
		seminar.setSeqNo(mongoSequence.getNextId("autoSequence"));
		seminar.setCreateDate(new Date());
		seminarRepository.save(seminar);
	}
	
	public void updateSeminar(SeminarVo seminarVo) {
		var seminar = new Seminar();
		voToEntity.copy(seminarVo, seminar, null);
		seminar.setCreateDate(new Date());
		seminarRepository.save(seminar);
	}
	
	public void deleteSeminar(Long seqNo) {
		seminarRepository.deleteById(seqNo);
	}
}
