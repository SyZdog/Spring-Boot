package com.cy.pj.activity.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.activity.pojo.Activity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Activity_Test {
	@Test
	public void testLombok() {
		Activity act = new Activity();
		act.setId(9L);
		act.setTitle("A_Title");
		System.out.println(act.getId());
		System.out.println(act.getTitle());
		//System.out.println(toString());
		log.info(act.toString());
	}
}
