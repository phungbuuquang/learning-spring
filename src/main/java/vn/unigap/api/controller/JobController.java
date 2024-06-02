package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.JobDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.service.job.JobService;
import vn.unigap.common.controller.AbstractResponseController;
import vn.unigap.common.exception.ApiException;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(path = "/jobs")
public class JobController extends AbstractResponseController {
    @Autowired
    private JobService jobService;

    @GetMapping(path="")
    ResponseEntity<?> list(PageDtoIn pageDtoIn){
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

    @PostMapping(path="")
    ResponseEntity<?> create(@RequestBody JobDtoIn jobDtoIn){
        try{
            return  responseEntity(
                ()->  jobService.create(jobDtoIn)
            , HttpStatus.CREATED);
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }

    }

    @PutMapping(path="/{id}")
    ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody JobDtoIn jobDtoIn){
        try{
            return  responseEntity(()->{
                return  jobService.update(id,jobDtoIn);
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }

    }

    @DeleteMapping(path="/{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        try{
            return  responseEntity(()->{
                jobService.delete(id);
                return new HashMap<>();
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }

    }

}
