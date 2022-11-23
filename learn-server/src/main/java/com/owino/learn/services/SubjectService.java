package com.owino.learn.services;

import com.owino.learn.api.resource.SubjectResource;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    /**
     * Create a new subject
     *
     * @param resource SubjectResource
     */
    void create(SubjectResource resource);

    /**
     * Fetch all created subjects
     *
     * @return List of Subjects
     */
    List<SubjectResource> findAll();
}
