package com.hanye.info.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mongo.Seminar;
import com.hanye.info.repository.mongo.SeminarRepository;
import com.hanye.info.vo.SeminarVo;

@Service
public class SeminarService {

	@Autowired
	private SeminarRepository seminarRepository;
	
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

	public SeminarVo findSeminar(String id) {
		var seminar = seminarRepository.findById(id).get();
		var seminarVo = new SeminarVo();
		entityToVo.copy(seminar, seminarVo, new BeanConverter());
		return seminarVo;
	}

	public void saveSeminar(SeminarVo seminarVo) {
		var seminar = new Seminar();
		voToEntity.copy(seminarVo, seminar, null);
		seminarRepository.save(seminar);
	}
	
	public void updateSeminar(SeminarVo seminarVo) {
		var seminar = new Seminar();
		voToEntity.copy(seminarVo, seminar, null);
		seminarRepository.save(seminar);
	}
	
	public void deleteSeminar(String id) {
		seminarRepository.deleteById(id);
	}
}
