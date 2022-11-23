package com.owino.learn.service_operations_tests;

import com.owino.learn.entities.Subject;
import com.owino.learn.repository.SubjectRepository;
import com.owino.learn.services.impl.SubjectServiceImpl;
import java.util.Arrays;
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
        subjectServiceImpl.create( new Subject());
    }

    @Test
    public void shouldFindAllSubjects(){
        Mockito.when(subjectRepository.findAll())
                .thenReturn(Arrays.asList( new Subject(1L, "Physics")));
        var subjects = subjectServiceImpl.findAll();
        Assertions.assertThat(subjects.isEmpty()).isFalse();
        Assertions.assertThat(subjects.size()).isEqualTo(1L);
    }
}
