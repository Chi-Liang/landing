package com.hanye.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanye.info.constant.RoleEnum;
import com.hanye.info.convert.BeanConverter;
import com.hanye.info.model.mysql.CopyWriter;
import com.hanye.info.model.mysql.Role;
import com.hanye.info.model.mysql.User;
import com.hanye.info.repository.mysql.CopyWriterRepository;
import com.hanye.info.vo.CopyWriterVo;

@Service
public class CopyWriterService {

	@Autowired
	private CopyWriterRepository copywriterRepository;

	private static BeanCopier voToEntity = BeanCopier.create(CopyWriterVo.class, CopyWriter.class, false);
	private static BeanCopier entityToVo = BeanCopier.create(CopyWriter.class, CopyWriterVo.class, true);

	public List<CopyWriterVo> findAll() {
		var voList = copywriterRepository.findAll().stream()
				.map(copywriter -> {
					var vo = new CopyWriterVo();
					entityToVo.copy(copywriter, vo, new BeanConverter());
					return vo;
				}).collect(Collectors.toList());
		
		return voList;
	}
	
	public Long getMaxSeqNo() {
		return copywriterRepository.getMaxSeqNo();
	}
	
	public CopyWriterVo findCopywriter(Long seqNo) {
		
		var copywriter = copywriterRepository.findById(seqNo).get();
		var copywriterVo = new CopyWriterVo();
		entityToVo.copy(copywriter, copywriterVo, new BeanConverter());
		return copywriterVo;
		
	}
	
	public void saveCopywriter(CopyWriterVo copywriterVo) {
		
		var copywriter = new CopyWriter();
		voToEntity.copy(copywriterVo, copywriter, null);
		copywriterRepository.save(copywriter);
		
	}
	
	public void deleteCopywriter(Long seqNo) {
		copywriterRepository.deleteById(seqNo);	
	}

}
