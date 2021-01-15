package com.gc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gc.data.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FanIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void testFanCreateEmptyList() throws Exception {
        mockMvc.perform(post("/user/add")
                .content(objectMapper.writeValueAsString(addUser(false)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/fan/favlist/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist());
    }


    @Test
    public void testAdd_New_UserAndFav() throws Exception {
        mockMvc.perform(post("/user/add")
                .content(objectMapper.writeValueAsString(addUser(true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/fan/favlist/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].image").value("https://images.app.goo.gl/EgiM5wmHhu1hXRQ2A"))
                .andExpect(jsonPath("$[0].realName").value("Clark Joseph Kent"))
                .andExpect(jsonPath("$[0].heroName").value("superman"));
    }


    @Test
    public void testAdd_New_UserAndFav_Remove() throws Exception {
        mockMvc.perform(post("/user/add")
                .content(objectMapper.writeValueAsString(addUser(true)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mockMvc.perform(delete("/deleterFav/1"))
                .andExpect(status().isOk());

    }




    private User addUser(boolean addFav) {
        User user = new User();
        user.setId("1");
        user.setName("bala");
        if(addFav){
            user.setFavStarId("h01");
        }
        return user;
    }


}
