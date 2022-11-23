package com.owino.learn.api.converters;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.entities.Subject;

public class ResourceConverter {
    public static Subject toEntity(SubjectResource resource) {
        return new Subject(resource.id(), resource.name());
    }

    public static SubjectResource toResource(Subject entity) {
        return new SubjectResource(entity.getId(), entity.getName());
    }
}
