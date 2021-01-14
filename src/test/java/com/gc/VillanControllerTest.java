package com.gc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class VillanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    List all hero names  - Get Api which return all heros
        - Table - heros with id and names
     */
    @Test
    public void testGetAllVillanNames() throws Exception {
        mockMvc.perform(get("/villans")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("joker"))
                .andExpect(jsonPath("$[1]").value("thanos"));
    }




/*
    Create Hero Table and Entity POJO
    Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.
     */


    @Test
    public void testHeroByName() throws Exception {
        mockMvc.perform(get("/villans/thanos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.image").value("https://images.app.goo.gl/mvFn194Zko5QZB9s6"))
                .andExpect(jsonPath("$.realName").value("Josh Brolin Damion Poitier"))
                .andExpect(jsonPath("$.villanName").value("thanos"));
    }

    @Test
    public void testHeroByName_thatDoesntExist() throws Exception {
        mockMvc.perform(get("/villans/ofe"))
                //.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("Villain Does Not Found"));
    }



}
