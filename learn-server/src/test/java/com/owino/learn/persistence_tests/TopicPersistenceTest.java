package com.owino.learn.persistence_tests;

import com.owino.learn.entities.Subject;
import com.owino.learn.entities.Topic;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TopicPersistenceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @Transactional
    public void shouldPersistTopicTest(){
        var entity = this.testEntityManager.persistAndFlush( new Topic(1L,"Introduction", new Subject(1L, "Physics")));
        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getName()).isEqualTo("Introduction");
        Assertions.assertThat(entity.getSubject()).isNotNull();
        Assertions.assertThat(entity.getSubject().getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getSubject().getName()).isEqualTo("Physics");
    }
}
