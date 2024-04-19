package com.edwinsoto.adopter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static net.minidev.asm.BeansAccess.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AdopterControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AdopterService adopterService;

    @Test
    void testgetAll() {
//        List<Adopter> adopters = new ArrayList<>();
//        when(adopterService.getAllAdopters()).thenReturn(adopters);

//        this.mockMvc.perform(get("/api/v1/adopter")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

//        this.mockMvc.perform(get("/api/v1/adopter")).andDo(
//                .contentType(MediaType.APPLICATION_JSON)
//                .andExpect(MockMvcRequestBuilders.head().headers().);
//        )


//        this.mockMvc.perform(get("/api/v1/adopter")).andDo(
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findById() {
    }

    @Test
    void addPerson() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}