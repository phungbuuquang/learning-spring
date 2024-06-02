package vn.unigap.api.service.resume;

import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.ResumeDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.ResumeDtoOut;

public interface ResumeService {
    PageDtoOut<ResumeDtoOut> list(Long seekerId, PageDtoIn pageDtoIn);
    ResumeDtoOut create(ResumeDtoIn resumeDtoIn);
}
