package com.owino.learn.services;

import com.owino.learn.entities.Subject;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SubjectService {
    /**
     * Create a new subject
     *
     * @param subject Subject
     */
    void create(Subject subject);

    /**
     * Fetch all created subjects
     *
     * @return List of Subjects
     */
    List<Subject> findAll();
}
