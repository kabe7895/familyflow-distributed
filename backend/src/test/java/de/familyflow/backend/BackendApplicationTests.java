package de.familyflow.backend;

import de.familyflow.backend.member.Member;
import de.familyflow.backend.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {


    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private MemberRepository repository;


    @Test
    void shouldGetAllMembers() throws Exception {

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk());
    }


    @Test
    void shouldCreateMember() throws Exception {

        String json = """
                {
                    "name": "Test User",
                    "email": "test@example.com"
                }
                """;


        mockMvc.perform(post("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }


    @Test
    void shouldReturn404ForUnknownMember() throws Exception {

        mockMvc.perform(get("/members/999999"))
                .andExpect(status().isNotFound());
    }
}