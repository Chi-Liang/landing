package com.hanye.info;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.javafaker.Faker;
import com.hanye.info.model.mongo.MongoSequence;
import com.hanye.info.vo.SeminarVo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testSeminar extends AbstractTest {

//	private static final Faker faker = Faker.instance();
//	
//
//	@Test
//	@Order(1)
//	public void testSaveSeminar() {
//		seminarService.saveSeminar(
//				new SeminarVo(null, faker.name().fullName(), "aaa@gmail.com", 1L, "平日場", "1", null));
//	}
//
//	@Test
//	@Order(2)
//	public void testFindSeminar() {
//		var seminar = seminarService.findSeminar(6L);
//		assertEquals(seminar.getSeqNo(), 6L);
//	}
//
//	@Test
//	@Order(3)
//	public void testUpdateSeminar() {
//		seminarService.updateSeminar(
//				new SeminarVo(null, faker.name().fullName(), "bbb@gmail.com", 1L, "平日場", "1", null));
//	}
//
//	@Test
//	@Order(4)
//	public void testDeleteSeminar() {
//		seminarService.deleteSeminar(6L);
//	}
//
//	@Test
//	@Order(5)
//	public void testFindAll() {
//		seminarService.findAll().stream().forEach(seminar -> {
//			assertNotEquals(seminar.getSeqNo(), 6L);
//		});
//	}

}
