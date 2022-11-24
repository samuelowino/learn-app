package com.owino.learn.api;

import com.owino.learn.api.resource.SubjectResource;
import com.owino.learn.services.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/")
    public void createSubject(@RequestBody SubjectResource resource){
        subjectService.create(resource);
    }

    @GetMapping("/")
    public List<SubjectResource> getAllSubjects(){
        return subjectService.findAll();
    }

}
