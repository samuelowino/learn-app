package com.owino.learn.api;

import com.owino.learn.api.resource.TopicResource;
import com.owino.learn.exception.BadRequestException;
import com.owino.learn.services.SubjectService;
import com.owino.learn.services.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public void createTopic(@RequestBody TopicResource topicResource){
        topicService.create(topicResource);
    }

    @GetMapping(value = "/subject/{subjectId}")
    public List<TopicResource> fetchTopics(@PathVariable("subjectId") long subjectId) throws BadRequestException {
        var optionalSubject = subjectService.findBySubjectId(subjectId);
        var subject = optionalSubject.orElseThrow(() -> new BadRequestException("Subject with id does not exist"));
        return topicService.fetchTopicsBySubject(subject);
    }
}
