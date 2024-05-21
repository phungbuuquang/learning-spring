package vn.unigap.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.service.seeker.SeekerService;
import vn.unigap.common.controller.AbstractResponseController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/seekers")
public class SeekerController extends AbstractResponseController {
    @Autowired
    private SeekerService seekerService;

    @GetMapping("/{provinceId}")
    ResponseEntity<?> list(PageDtoIn pageDtoIn,
                           @PathVariable(name = "provinceId") Integer provinceId){

        return responseEntity(()->seekerService.list(pageDtoIn, provinceId));
    }
}
