package com.owino.learn.object_creation_tests;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopicResourceTest {

    @Test
    public void shouldCreateTopicResource(){
        var topicResource = new TopicResource(1L, "Introduction", new SubjectResource(1L, "Physics"));
        Assertions.assertThat(topicResource).isNotNull();
        Assertions.assertThat(topicResource.id()).isEqualTo(1L);
        Assertions.assertThat(topicResource.name()).isEqualTo("Introduction");
        Assertions.assertThat(topicResource.subject()).isNotNull();
        Assertions.assertThat(topicResource.subject().id()).isEqualTo(1L);
        Assertions.assertThat(topicResource.subject().name()).isEqualTo("Physics");
    }
}
