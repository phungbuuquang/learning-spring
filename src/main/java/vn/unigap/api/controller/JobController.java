package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.service.job.JobService;
import vn.unigap.common.controller.AbstractResponseController;
import vn.unigap.common.exception.ApiException;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(path = "/jobs")
public class JobController extends AbstractResponseController {
    @Autowired
    private JobService jobService;

    @GetMapping(path="")
    ResponseEntity<?> list(PageDtoIn  pageDtoIn){
        return  responseEntity(()->{
          return   jobService.list(pageDtoIn);
        });
    }

    @GetMapping(path="/{id}")
    ResponseEntity<?> get(@PathVariable(name = "id") Long id){
        try{
            return  responseEntity(()->{
                return  jobService.get(id);
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }

    }

}
