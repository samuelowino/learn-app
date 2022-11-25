package com.owino.learn.services;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TopicService {
    /**
     * Create a topic
     *
     * @param topic Topic
     */
    void create(TopicResource topic);

    /**
     * Fetch all the topics under a subject
     *
     * @param subject Subject
     * @return List of topics
     */
    List<TopicResource> fetchTopicsBySubject(SubjectResource subject);
}
