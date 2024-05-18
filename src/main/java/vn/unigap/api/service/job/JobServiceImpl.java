package vn.unigap.api.service.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.JobDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Jobs;
import vn.unigap.api.repository.JobRepository;
import vn.unigap.common.errorcode.ErrorCode;
import vn.unigap.common.exception.ApiException;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public PageDtoOut<JobDtoOut> list(PageDtoIn pageDtoIn) {
        Page<Jobs> jobs = jobRepository.findAll(PageRequest.of(
                pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(),
                Sort.by("createdDate").ascending()
        ));
        return PageDtoOut.from(
                pageDtoIn.getPage(),
                pageDtoIn.getPageSize(),
                jobs.getTotalElements(),
                jobs.stream().map(JobDtoOut::from).toList()
        );
    }

    @Override
    public JobDtoOut get(Long id) {
        Jobs job = jobRepository.findById(id).orElseThrow(
                ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Job not found")
        );

        return  JobDtoOut.from(job);
    }
}
