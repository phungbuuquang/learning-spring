package vn.unigap.api.service.resume;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.ResumeDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.ResumeDtoOut;
import vn.unigap.api.entity.Resume;
import vn.unigap.api.entity.Seeker;
import vn.unigap.api.repository.ResumeRepository;
import vn.unigap.api.repository.SeekerRepository;
import vn.unigap.common.Common;
import vn.unigap.common.errorcode.ErrorCode;
import vn.unigap.common.exception.ApiException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService{
    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private SeekerRepository seekerRepository;

    @Override
    public PageDtoOut<ResumeDtoOut> list(Long seekerId, PageDtoIn pageDtoIn) {
        Page<Resume> resumes = resumeRepository.findAllBySeekerId(seekerId, PageRequest.of(
                pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(),
                Sort.by("createdAt")
        ));

        return PageDtoOut.from(pageDtoIn.getPage(),
                                pageDtoIn.getPageSize(),
                                resumes.getTotalElements(),
                resumes.stream().map(ResumeDtoOut::from).toList());
    }

    @Override
    public ResumeDtoOut create(ResumeDtoIn resumeDtoIn) {
        Seeker seeker = seekerRepository.findById(resumeDtoIn.getSeekerId()).orElseThrow(
                ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Seeker not found")
        );
        Resume resume = resumeRepository.save(Resume.builder()
                        .seeker(seeker)
                        .careerObj(resumeDtoIn.getCareerObj())
                        .title(resumeDtoIn.getTitle())
                        .salary(resumeDtoIn.getSalary())
                        .fields(Common.listIntToString(resumeDtoIn.getFieldIds()))
                        .createdAt(Common.currentTime())
                        .updatedAt(Common.currentTime())
                        .provinces(Common.listIntToString(resumeDtoIn.getProvinceIds()))
                .build());
        return ResumeDtoOut.from(resume);
    }
}
