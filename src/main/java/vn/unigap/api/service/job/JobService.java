package vn.unigap.api.service.job;

import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.JobDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;

public interface JobService {
     PageDtoOut<JobDtoOut> list(PageDtoIn pageDtoIn);
     JobDtoOut get(Long id);
}
