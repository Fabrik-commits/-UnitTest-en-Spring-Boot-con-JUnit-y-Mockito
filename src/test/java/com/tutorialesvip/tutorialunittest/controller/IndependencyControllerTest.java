package com.tutorialesvip.tutorialunittest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;

class IndependencyControllerTest {
	
	@Autowired
	CountryResponse countryResponse;
	@Autowired
    Optional<Country> country;
	
    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);
    
    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();
    
    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock, diferenciaEntreFechas);

	@BeforeEach
	void setUp() throws Exception {
		//System.out.println("Antes de la prueba");
		Country mockCountry = new Country();
		mockCountry.setIsoCode("DO");
		mockCountry.setCountryIdependenceDate("23/11/1986");
		mockCountry.setCountryId((long) 1);
		mockCountry.setCountryName("Republica Dominicana");
		mockCountry.setCountryCapital("Santo Domingo");
		
		
		Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(mockCountry);
	}
	
//	@Test
//	void test() {
//		//fail("Not yet implemented");
//		System.out.println("Dentro de la prueba");
//	}
	
	@Test
	void getCountryDetailsWithValidCountryCode() {
		ResponseEntity<CountryResponse> respuestaServicio;
		
		respuestaServicio = independencyController.getCountryDetails("DO");
		//System.out.println(respuestaServicio);
		Assertions.assertEquals("Republica Dominicana", respuestaServicio.getBody().getCountryName());
	}
	
	@Test
	void getCountryDetailsWithInvalidCountryCode() {
		ResponseEntity<CountryResponse> respuestaServicio;
		
		respuestaServicio = independencyController.getCountryDetails("IT");
		//System.out.println(respuestaServicio);
		Assertions.assertNull(respuestaServicio.getBody().getCountryName());
	}

}
