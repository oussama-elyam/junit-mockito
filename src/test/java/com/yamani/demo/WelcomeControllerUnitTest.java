package com.yamani.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.yamani.WelcomeController.WelcomeController;
import com.yamani.WelcomeService.WelcomeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class WelcomeControllerUnitTest {
	
	/*
	//step1
	@Test
	void shouldWelcome() {
		WelcomeController welcomeController = new WelcomeController();
        assertEquals("welcome", welcomeController.welcome());
	}
	*/
	
	/*
	//step2
	@Test
	void shouldWelcome() {
		WelcomeController welcomeController = new WelcomeController();
	    assertEquals("welcome oussama", welcomeController.welcome("oussama"));
	}
	*/
	
	/*
	//step3.1
		@Test
		void shouldWelcome() {
			//we gonna mock the welcomeService
	        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
	        //lets define the behaviour of welcome service
	        when(welcomeService.getWelcomeMessage("oussama")).thenReturn("welcome oussama");
	        WelcomeController welcomeController = new WelcomeController(welcomeService);
			assertEquals("welcome oussama", welcomeController.welcome("oussama"));
		}
	*/
	
	//step3.2
    WelcomeController welcomeController;

	@BeforeEach
    void setup() {
        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger!");
        when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John!");
        this.welcomeController = new WelcomeController(welcomeService);
    }

    @Test
    void shouldGetDefaultWelcomeMessage() {
        assertEquals("Welcome Stranger!", welcomeController.welcome("Stranger"));
    }

    @Test
    void shouldGetCustomWelcomeMessage() {
        assertEquals("Welcome John!", welcomeController.welcome("John"));
    }
    
}

		
	