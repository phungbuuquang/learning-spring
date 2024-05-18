package vn.unigap.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.service.employer.EmployerService;
import vn.unigap.common.controller.AbstractResponseController;
import vn.unigap.common.exception.ApiException;

import java.util.HashMap;


@RestController // This means that this class is a Controller
@RequestMapping(path="/employers")
public class EmployerController extends AbstractResponseController {

    final private EmployerService employerService;

    EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @PostMapping(path="") // Map ONLY POST Requests
    public ResponseEntity<?> addNewEmployer (@Valid @RequestBody EmployerDtoIn employerDto) {
        try{
            return responseEntity(() -> {
                return this.employerService.create(employerDto);
            }, HttpStatus.CREATED);
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }
    }

    @GetMapping(path="")
    public ResponseEntity<?> list(PageDtoIn pageDtoIn) {
      return  responseEntity(()->{
          return  this.employerService.list(pageDtoIn);
      });
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Integer id) {
        try{
            return  responseEntity(()->{
                return this.employerService.get(id);
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }

    }

    @PutMapping(path="/{id}") // Map ONLY POST Requests
    public ResponseEntity<?> updateEmployer (@PathVariable(value = "id") Integer id, @RequestBody EmployerDtoIn employerDto) {
        try{
            return responseEntity(() -> {
                return this.employerService.update(id,employerDto);
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteEmployer(@PathVariable(value = "id") Integer id){
        try{
            return responseEntity(() -> {
                 this.employerService.delete(id);
                 return new HashMap<>();
            });
        }catch (ApiException e){
            return responseEntity(e::getMessage, e.getHttpStatus());
        }
    }
}
