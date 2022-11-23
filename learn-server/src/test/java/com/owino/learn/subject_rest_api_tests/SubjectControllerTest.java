package com.owino.learn.subject_rest_api_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateSubjectReturnOkTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/subject/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
