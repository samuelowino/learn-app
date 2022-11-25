package com.owino.learn.persistence_tests;

import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;
import com.owino.learn.repository.TopicRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void createTopicTest(){
        var topic = new Topic(1L,"Introduction", new Subject(1L,"Physics"));
        var entity = topicRepository.save(topic);
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getName()).isEqualTo("Introduction");
        Assertions.assertThat(entity.getSubject()).isNotNull();
    }
}
