package com.hanye.info;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.github.javafaker.Faker;
import com.hanye.info.vo.SeminarVo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testSeminar extends AbstractTest {
	
	private static String id;
	
	private static final Faker faker = Faker.instance();
	
	@BeforeAll
	public static void InitId(){
		id = faker.idNumber().invalid();
	}
	
	@Test
	@Order(1)
	public void testSaveSeminar() {
		seminarService.saveSeminar(new SeminarVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	@Order(2)
	public void testFindSeminar() {
		var seminar = seminarService.findSeminar(id);
		assertEquals(seminar.getId(),id);
	}
	
	@Test
	@Order(3)
	public void testUpdateSeminar() {
		seminarService.updateSeminar(new SeminarVo(id,faker.name().fullName(),faker.code().asin()));
	}
	
	@Test
	@Order(4)
	public void testDeleteSeminar() {
		seminarService.deleteSeminar(id);
	}
	
	@Test
	@Order(5)
	public void testFindAll() {
		seminarService.findAll().stream().forEach( seminar -> {
			 assertNotEquals(seminar.getId(),id);
		});
	}

}
