package com.hanye.info.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mysql.CopySession;
import com.hanye.info.repository.mysql.CopySessionRepository;
import com.hanye.info.vo.CopySessionVo;

@Service
public class CopySessionService {
	
	@Autowired
	private CopySessionRepository copySessionRepository;

	private static BeanCopier voToEntity = BeanCopier.create(CopySessionVo.class, CopySession.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(CopySession.class, CopySessionVo.class, true);
	
	public List<CopySessionVo> findAll() {
		var voList = copySessionRepository.findAll().stream()
				.map(copywriter -> {
					var vo = new CopySessionVo();
					entityToVo.copy(copywriter, vo, new BeanConverter());
					vo.setGroupName(copywriter.getCopyWriter().getGroupName());
					return vo;
				}).collect(Collectors.toList());
		
		return voList;
	}
	
	public CopySessionVo findCopywriter(Long seqNo) {
		
		var copySession = copySessionRepository.findById(seqNo).get();
		var copySessionVo = new CopySessionVo();
		entityToVo.copy(copySession, copySessionVo, new BeanConverter());
		return copySessionVo;
		
	}
	
	public void saveCopySession(CopySessionVo copySessionVo) {
		
		var copySession = new CopySession();
		voToEntity.copy(copySessionVo, copySession, null);
		copySessionRepository.save(copySession);
		
	}
	
	public void deleteCopySession(Long seqNo) {
		copySessionRepository.deleteById(seqNo);	
	}
	
}
