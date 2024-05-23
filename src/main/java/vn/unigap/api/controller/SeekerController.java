package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.SeekerDtoIn;
import vn.unigap.api.service.seeker.SeekerService;
import vn.unigap.common.controller.AbstractResponseController;
import vn.unigap.common.exception.ApiException;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/seekers")
public class SeekerController extends AbstractResponseController {
    @Autowired
    private SeekerService seekerService;

    @GetMapping("")
    ResponseEntity<?> list(PageDtoIn pageDtoIn,
                           @RequestParam Integer provinceId){

        return responseEntity(()->seekerService.list(pageDtoIn, provinceId));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> get(@PathVariable(name = "id") Long id){
        try{
            return responseEntity(
                    ()->  seekerService.get(id)
            );
        }catch (ApiException e){
            return  responseEntity(e::getMessage, e.getHttpStatus());
        }
    }

    @PostMapping("")
    ResponseEntity<?> create(@RequestBody SeekerDtoIn seekerDtoIn){
        return  responseEntity(
                ()->seekerService.create(seekerDtoIn),
                HttpStatus.CREATED
        );
    }
}
