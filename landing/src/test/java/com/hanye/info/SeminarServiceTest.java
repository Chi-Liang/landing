package com.hanye.info;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.hanye.info.vo.SeminarVo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeminarServiceTest extends AbstractTest {

	@Test
	@Order(1)
	public void testSaveSeminar() {
		seminarService.saveSeminar(new SeminarVo(null, "fundodo", "aaa@gmail.com", "不動產", "台北", "2022/11/15 08:00"));

	}

	@Test
	@Order(2)
	public void testFindAll() {
		assertTrue(seminarService.findAll("", "", "").getSeminarVoList().size() > 0);
		assertTrue(seminarService.findAll("", "", "").getGroupNameList().size() > 0);
		assertTrue(seminarService.findAll("", "", "").getSessionPlaceList().size() > 0);
		assertTrue(seminarService.findAll("", "", "").getSessionTimeList().size() > 0);
	}

}
