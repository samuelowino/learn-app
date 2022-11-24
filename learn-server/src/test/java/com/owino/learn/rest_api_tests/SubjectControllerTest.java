package com.owino.learn.rest_api_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owino.learn.api.SubjectController;
import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.config.WebConfig;
import com.owino.learn.entities.Subject;
import com.owino.learn.services.SubjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebConfig.class})
@Import(SubjectController.class)
@WebMvcTest(SubjectControllerTest.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void shouldCreateSubjectReturnOkTest() throws Exception {
        this.mockMvc.perform(post("/subject/"))
                .andExpect(status().is4xxClientError())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void shouldCreateSubjectWithPayloadTest() throws Exception {
        var subject = new Subject(1L, "Physics");
        var payload = new ObjectMapper().writeValueAsString(subject);

        this.mockMvc.perform(post("/subject/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

//    @Test
//    public void shouldFetchAllSubjectsEndPointTest() throws Exception {
//        this.mockMvc.perform(get("/subject/"))
//                .andExpect(status().isOk());
//    }
}
