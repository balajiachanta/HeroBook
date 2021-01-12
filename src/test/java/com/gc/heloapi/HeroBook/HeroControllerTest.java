package com.gc.heloapi.HeroBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class HeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    List all hero names  - Get Api which return all heros
        - Table - heros with id and names
     */
    @Test
    public void testGetAllHeroNames() throws Exception {
        mockMvc.perform(get("/heros")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("superman"))
                .andExpect(jsonPath("$[1]").value("spiderman"));
    }


    /*
    Create Hero Table and Entity POJO
    Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.


     */

    @Test
    public void testHeroByName() throws Exception {


        mockMvc.perform(get("/heros/{name}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("superman"))
                .andExpect(jsonPath("$.name").value("superman"))
                .andExpect(jsonPath("$.name").value("superman"))
                .andExpect(jsonPath("$.name").value("superman"))
                .andExpect(jsonPath("$.name").value("superman"))
                .andExpect(jsonPath("$.name").value("superman"));

    }


}
