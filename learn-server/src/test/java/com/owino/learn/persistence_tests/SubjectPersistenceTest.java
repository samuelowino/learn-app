package com.owino.learn.persistence_tests;

import com.owino.learn.entities.Subject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SubjectPersistenceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void shouldPersistSubject(){
        var entity = testEntityManager.persistAndFlush( new Subject(1L,"Physics"));
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getName()).isEqualTo("Physics");
    }
}
