package com.tutorialesvip.tutorialunittest.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DiferenciaEntreFechasTest {
	
	@Autowired
	private DiferenciaEntreFechas diferenciaEntreFechas;

	@Test
	void testCalculateYearsOfIndependency() {
		//fail("Not yet implemented");
		
		LocalDate today = LocalDate.now();
		String fechaIndependencia = "27/02/1844";
		diferenciaEntreFechas = new DiferenciaEntreFechas();
		Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);
		System.out.println(resultado.getMonths());
		System.out.println(resultado.getDays());
		System.out.println(resultado.getYears());
		Assertions.assertEquals(2, resultado.getMonths());
		Assertions.assertEquals(16, resultado.getDays());
		Assertions.assertEquals(178, resultado.getYears());		
	}

}
