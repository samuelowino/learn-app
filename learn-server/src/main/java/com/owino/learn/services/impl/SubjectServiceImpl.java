package com.owino.learn.services.impl;

import com.owino.learn.api.converters.ResourceConverter;
import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.repository.SubjectRepository;
import com.owino.learn.services.SubjectService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    /**
     * Create a new subject
     *
     * @param resource Subject
     */
    @Override
    public void create(SubjectResource resource) {
        repository.save(ResourceConverter.toEntity(resource));
    }

    /**
     * Fetch all created subjects
     *
     * @return List of Subjects
     */
    @Override
    public List<SubjectResource> findAll() {
        var subjects = repository.findAll();
        return subjects.stream()
                .map(ResourceConverter::toResource)
                .collect(Collectors.toList());
    }

    /**
     * Find subject by it\'s id
     *
     * @param id Database id for this subject
     * @return Optional Subject Resource
     */
    @Override
    public Optional<SubjectResource> findBySubjectId(long id) {
        var optionalSubject = repository.findById(id);
        if (optionalSubject.isEmpty()) return Optional.empty();
        else {
            var subject = optionalSubject.get();
            var subjectResource = ResourceConverter.toResource(subject);
            return Optional.of(subjectResource);
        }
    }
}
