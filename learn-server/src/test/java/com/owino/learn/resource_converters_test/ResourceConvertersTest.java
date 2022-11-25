package com.owino.learn.resource_converters_test;

import com.owino.learn.api.converters.ResourceConverter;
import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourceConvertersTest {

    @Test
    public void shouldCreateResourceConverterTest(){
        var converter = new ResourceConverter();
        Assertions.assertThat(converter).isNotNull();
    }

    @Test
    public void shouldConvertSubjectResourceToSubjectEntityTest(){
        var resource = new SubjectResource(1L, "Physics");
        var entity = ResourceConverter.toEntity(resource);
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getName()).isEqualTo("Physics");
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
    }

    @Test
    public void shouldConvertSubjectEntityToResourceTest(){
        var entity = new Subject(1L, "Physics");
        var resource = ResourceConverter.toResource(entity);
        Assertions.assertThat(resource).isNotNull();
        Assertions.assertThat(resource.name()).isEqualTo("Physics");
        Assertions.assertThat(resource.id()).isEqualTo(1L);
    }

    @Test
    public void shouldConvertTopicResourceToEntityTest(){
        var topicResource = new TopicResource(1L, "Introduction", new SubjectResource(1L, "Physics"));
        var entity = ResourceConverter.toEntity(topicResource);
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getSubject()).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getName()).isEqualTo("Introduction");
        Assertions.assertThat(entity.getSubject().getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getSubject().getName()).isEqualTo("Physics");
    }

    @Test
    public void shouldConvertTopicEntityToResourceTest(){
        var topicEntity = new Topic(1L, "Introduction", new Subject(1L,"Physics"));
        var resource = ResourceConverter.toResource(topicEntity);
        Assertions.assertThat(resource).isNotNull();

        Assertions.assertThat(resource.subject()).isNotNull();
        Assertions.assertThat(resource.id()).isEqualTo(1L);
        Assertions.assertThat(resource.name()).isEqualTo("Introduction");
        Assertions.assertThat(resource.subject().id()).isEqualTo(1L);
        Assertions.assertThat(resource.subject().name()).isEqualTo("Physics");
    }
}
