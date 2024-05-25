package vn.unigap.api.service.seeker;

import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.SeekerDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.SeekerDtoOut;

public interface SeekerService {
    PageDtoOut<SeekerDtoOut> list(PageDtoIn pageDtoIn, Integer provinceId);
    SeekerDtoOut get(Long id);
    SeekerDtoOut create(SeekerDtoIn seekerDtoIn);
    SeekerDtoOut update(Long id, SeekerDtoIn seekerDtoIn);
    void delete(Long id);
}
