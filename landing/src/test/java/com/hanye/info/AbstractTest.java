package com.hanye.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hanye.info.service.SeminarService;
import com.hanye.info.sequence.MongoSequence;
import com.hanye.info.service.MailJobService;

@SpringBootTest
//@AutoConfigureMockMvc
public class AbstractTest {
	
	@Autowired
	protected MailJobService mailJobService;
	
	@Autowired
	protected SeminarService seminarService;
	
	@Autowired
	protected MongoSequence mongoSequence;
	
//	@Autowired
//	protected MockMvc mockMvc;
	
}
