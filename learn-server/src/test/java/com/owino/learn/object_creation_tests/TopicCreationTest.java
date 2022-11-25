package com.owino.learn.object_creation_tests;

import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopicCreationTest {

    @Test
    public void shouldCreateTopicTest(){
        var topic = new Topic(1L, "Introduction", new Subject(1L, "Physics"));
        Assertions.assertThat(topic).isNotNull();
        Assertions.assertThat(topic.getId()).isEqualTo(1L);
        Assertions.assertThat(topic.getName()).isEqualTo("Introduction");
        Assertions.assertThat(topic.getSubject()).isNotNull();
        Assertions.assertThat(topic.getSubject().getId()).isEqualTo(1L);
        Assertions.assertThat(topic.getSubject().getName()).isEqualTo("Physics");
    }
}
