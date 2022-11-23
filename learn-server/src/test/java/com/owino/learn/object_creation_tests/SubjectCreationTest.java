package com.owino.learn.object_creation_tests;

import com.owino.learn.entities.Subject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubjectCreationTest {

    @Test
    public void shouldCreateSubject(){
        var subject = new Subject(1L,"Physics");
        Assertions.assertThat(subject.getId()).isEqualTo(1L);
        Assertions.assertThat(subject.getName()).isEqualTo("Physics");
    }
}
