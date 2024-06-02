package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.ResumeDtoIn;
import vn.unigap.api.service.resume.ResumeService;
import vn.unigap.common.controller.AbstractResponseController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/resumes")
public class ResumeController extends AbstractResponseController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping("")
    ResponseEntity<?> list(Long seekerId, PageDtoIn pageDtoIn){
        return  responseEntity(
                ()-> resumeService.list(seekerId, pageDtoIn)
        );
    }

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody ResumeDtoIn resumeDtoIn){
        return  responseEntity(
                ()-> resumeService.create(resumeDtoIn),
                HttpStatus.CREATED
        );
    }
}
