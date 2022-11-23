package com.owino.learn.services.impl;

import com.owino.learn.entities.Subject;
import com.owino.learn.repository.SubjectRepository;
import com.owino.learn.services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    /**
     * Create a new subject
     *
     * @param subject Subject
     */
    @Override
    public void create(Subject subject) {
        repository.save(subject);
    }

    /**
     * Fetch all created subjects
     *
     * @return List of Subjects
     */
    @Override
    public List<Subject> findAll() {
        return repository.findAll();
    }
}
