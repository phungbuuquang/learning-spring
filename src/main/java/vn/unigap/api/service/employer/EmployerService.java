package vn.unigap.api.service.employer;

import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;

public interface EmployerService {
    EmployerDtoOut create(EmployerDtoIn userDtoIn);
    PageDtoOut<EmployerDtoOut> list(PageDtoIn pageDtoIn);
    EmployerDtoOut get(Integer id);
    EmployerDtoOut update(Integer id, EmployerDtoIn employerDtoIn);
    void delete(Integer id);
}
