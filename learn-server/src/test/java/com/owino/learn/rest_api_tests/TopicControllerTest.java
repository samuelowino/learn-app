package com.owino.learn.rest_api_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owino.learn.api.TopicController;
import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;
import com.owino.learn.services.SubjectService;
import com.owino.learn.services.TopicService;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TopicController.class)
@Import(TopicController.class)
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void shouldCreateTopicTest() throws Exception {
        var topicResource = new Topic(1L,"Introduction", new Subject(1L,"Physics"));
        var payload = new ObjectMapper().writeValueAsString(topicResource);

        this.mockMvc.perform(post("/topic/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void shouldFetchTopicsBySubjectTest() throws Exception {
        Mockito.when(subjectService.findBySubjectId(1L))
                .thenReturn(Optional.of(new SubjectResource(1L, "Physics")));

        Mockito.when(topicService.fetchTopicsBySubject(new SubjectResource(1L, "Physics")))
                .thenReturn(Collections.singletonList( new TopicResource(1L,"Introduction", new SubjectResource(1L, "Physics"))));

        this.mockMvc.perform(get("/topic/subject/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void shouldFetchTopicsBySubjectPayloadTest() throws Exception {
        Mockito.when(subjectService.findBySubjectId(1L))
                .thenReturn(Optional.of(new SubjectResource(1L, "Physics")));

        Mockito.when(topicService.fetchTopicsBySubject(new SubjectResource(1L, "Physics")))
                .thenReturn(Collections.singletonList( new TopicResource(1L,"Introduction", new SubjectResource(1L, "Physics"))));

        this.mockMvc.perform(get("/topic/subject/1"))
                .andExpect(jsonPath("@.[0].id").isNumber())
                .andExpect(jsonPath("@.[0].id").value(1L))
                .andExpect(jsonPath("@.[0].name").value("Introduction"))
                .andExpect(jsonPath("@.[0].subject.id").value(1L))
                .andExpect(jsonPath("@.[0].subject.name").value("Physics"))
                .andDo(print())
                .andReturn();
    }
}
