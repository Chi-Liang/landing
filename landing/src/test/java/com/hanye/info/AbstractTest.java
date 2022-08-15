package com.hanye.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hanye.info.service.GroceryService;
import com.hanye.info.service.MailJobService;

@SpringBootTest
//@AutoConfigureMockMvc
public class AbstractTest {
	
	@Autowired
	protected MailJobService mailJobService;
	
	@Autowired
	protected GroceryService groceryService;
	
//	@Autowired
//	protected MockMvc mockMvc;
	
}
