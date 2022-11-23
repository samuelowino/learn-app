package com.owino.learn.service_tests;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.entities.Subject;
import com.owino.learn.repository.SubjectRepository;
import com.owino.learn.services.impl.SubjectServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class SubjectServicesTests {

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectServiceImpl;

    @Test
    public void shouldCreateSubjectTest(){
        subjectServiceImpl.create( new SubjectResource(1L,"Physics"));
    }

    @Test
    public void shouldFindAllSubjects(){
        Mockito.when(subjectRepository.findAll())
                .thenReturn(List.of(new Subject(1L, "Physics")));
        var subjects = subjectServiceImpl.findAll();
        Assertions.assertThat(subjects.get(0) != null).isTrue();
        Assertions.assertThat(subjects.size()).isEqualTo(1L);
    }
}
