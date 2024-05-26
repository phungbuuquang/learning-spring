package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.api.service.resume.ResumeService;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/resumes")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
}
