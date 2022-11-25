package com.owino.learn.service_tests;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.repository.TopicRepository;
import com.owino.learn.services.impl.TopicServiceImpl;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TopicServiceTest {

    @InjectMocks
    private TopicServiceImpl topicService;

    @Mock
    private TopicRepository topicRepository;

    @Test
    public void shouldCreateTopicServiceTest(){
        var topicService = new TopicServiceImpl();
        Assertions.assertThat(topicService).isNotNull();
    }

    @Test
    public void shouldCreateTopicTest(){
        var topic = new TopicResource(1L,"Introduction", new SubjectResource(1L,"Physics"));
        topicService.create(topic);
    }

    @Test
    public void shouldFetchTopicsBySubjectTest(){
        var subject = new SubjectResource(1L,"Physics");
        Mockito.when(topicRepository.findBySubject(subject))
                .thenReturn(Collections.singletonList( new TopicResource(1L,"Introduction", new SubjectResource(1L,"Physics"))));

        var topics = topicService.fetchTopicsBySubject(subject);
        Assertions.assertThat(topics).isNotNull();
        Assertions.assertThat(topics.isEmpty()).isFalse();
        Assertions.assertThat(topics.size()).isEqualTo(1);
    }
}
