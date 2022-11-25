package com.owino.learn.services.impl;

import com.owino.learn.api.converters.ResourceConverter;
import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.repository.TopicRepository;
import com.owino.learn.services.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    /**
     * Create a topic
     *
     * @param topic Topic
     */
    @Override
    public void create(TopicResource topic) {
        topicRepository.save(ResourceConverter.toEntity(topic));
    }

    /**
     * Fetch all the topics under a subject
     *
     * @param subject Subject
     * @return List of topics
     */
    @Override
    public List<TopicResource> fetchTopicsBySubject(SubjectResource subject) {
        return topicRepository.findBySubject(subject);
    }
}
