package com.owino.learn.object_creation_tests;

import com.owino.learn.api.resource.SubjectResource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubjectResourceCreationTest {

    @Test
    public void shouldCreateSubjectResource(){
        var subjectResource = new SubjectResource(1L,"Physics");
        Assertions.assertThat(subjectResource.id()).isEqualTo(1L);
        Assertions.assertThat(subjectResource.name()).isEqualTo("Physics");
    }
}
