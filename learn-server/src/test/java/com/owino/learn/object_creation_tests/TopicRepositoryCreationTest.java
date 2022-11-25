package com.owino.learn.object_creation_tests;

import com.owino.learn.repository.TopicRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TopicRepositoryCreationTest {

    @Autowired
    private TopicRepository topicRepository;

    @Test
    public void shouldCreateTopicRepository(){
        Assertions.assertThat(topicRepository).isNotNull();
    }
}
