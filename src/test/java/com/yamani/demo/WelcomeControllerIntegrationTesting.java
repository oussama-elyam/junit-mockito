package com.yamani.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yamani.WelcomeService.WelcomeService;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//used in integration testing
@WebMvcTest
class WelcomeControllerIntegrationTesting {

    
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService welcomeService;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        when(welcomeService.getWelcomeMessage("oussama")).thenReturn("welcome oussama");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("welcome oussama")));
        
        //WelcomeController welcomeController = new WelcomeController(welcomeService);
        //assertEquals("Welcome oussama!", welcomeController.welcome("oussama"));

        verify(welcomeService).getWelcomeMessage("oussama");
    }
}

		
	