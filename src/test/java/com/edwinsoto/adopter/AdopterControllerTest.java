package com.edwinsoto.adopter;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@WebMvcTest(controllers = AdopterController.class)
@ContextConfiguration(classes = AdopterController.class)
class AdopterControllerTest {

    @Autowired
    private MockMvc mockMvc;
//
    @MockBean
    private AdopterService adopterService;

    @Test
    void testGetAllAdopters() throws Exception {
        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new Adopter(null, "Fred", "111-222-333", "fred.lname@email.com", false, LocalDateTime.now(), null, null));
        adopters.add(new Adopter(null, "Wilma", "111-222-333", "wilma.lname@email.com", false, LocalDateTime.now(), null, null));

        when(adopterService.getAllAdopters()).thenReturn(adopters);


        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/adopter")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    @Test
    void testGetAllAdoptersEmpty() throws Exception {
//        List<Adopter> adopters = new ArrayList<>();
//        adopters.add(new Adopter(null, "Fred", "111-222-333", "fred.lname@email.com", false, LocalDateTime.now(), null, null));
//        adopters.add(new Adopter(null, "Wilma", "111-222-333", "wilma.lname@email.com", false, LocalDateTime.now(), null, null));
//
//        when(adopterService.getAllAdopters()).thenReturn(adopters);

        when(adopterService.getAllAdopters()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/adopter")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findGetByIdValid() throws Exception {
        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new Adopter(1, "Fred", "111-222-333", "fred.lname@email.com", false, LocalDateTime.now(), null, null));
        adopters.add(new Adopter(2, "Wilma", "111-222-333", "wilma.lname@email.com", false, LocalDateTime.now(), null, null));

        System.out.println(adopters.getFirst());
        when(adopterService.getAdopterById(1)).thenReturn(Optional.ofNullable(adopters.getFirst()));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/adopter/id=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
    @Test
    void findGetByIdInValid() throws Exception {
        List<Adopter> adopters = new ArrayList<>();
        adopters.add(new Adopter(1, "Fred", "111-222-333", "fred.lname@email.com", false, LocalDateTime.now(), null, null));
        adopters.add(new Adopter(2, "Wilma", "111-222-333", "wilma.lname@email.com", false, LocalDateTime.now(), null, null));

        when(adopterService.getAdopterById(1)).thenReturn(Optional.ofNullable(adopters.getFirst()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/adopter/id=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

//    TODO: Need to correct this test
    @Test
    void testAddValidPerson() throws Exception {
//        Adopter adopter = new Adopter(1, "Fred", "111-222-333", "fred.lname@email.com", false, LocalDateTime.now(), null, null);
//
//        when(adopterService.insertAdopter(adopter));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/v1/adopter/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void testAddInvalidPerson() throws Exception {


    }


    @Test
    void testValidupdate() {
    }

    @Test
    void testInValidUpdate(){

    }

    @Test
    void testDeleteByValidID() {
    }

    @Test
    void testDeleteByInValidID(){

    }


}