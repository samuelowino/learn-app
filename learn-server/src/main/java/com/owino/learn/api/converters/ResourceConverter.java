package com.owino.learn.api.converters;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;

public class ResourceConverter {
    public static Subject toEntity(SubjectResource resource) {
        return new Subject(resource.id(), resource.name());
    }

    public static SubjectResource toResource(Subject entity) {
        return new SubjectResource(entity.getId(), entity.getName());
    }

    public static Topic toEntity(TopicResource topicResource) {
        var subjectEntity= ResourceConverter.toEntity(topicResource.subject());
        return new Topic(topicResource.id(), topicResource.name(), subjectEntity);
    }

    public static TopicResource toResource(Topic entity) {
        var subjectResource = ResourceConverter.toResource(entity.getSubject());
        return new TopicResource(entity.getId(), entity.getName(), subjectResource);
    }
}
