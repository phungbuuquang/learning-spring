package vn.unigap.api.service.employer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.Employer;
import vn.unigap.api.repository.EmployerRepository;
import vn.unigap.common.Common;
import vn.unigap.common.errorcode.ErrorCode;
import vn.unigap.common.exception.ApiException;

@Service
public class EmployerServiceImpl implements EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public EmployerDtoOut create(EmployerDtoIn employerDtoIn) {
        employerRepository.findByEmail(employerDtoIn.getEmail()).ifPresent(e -> {
            throw new ApiException(ErrorCode.BAD_REQUEST, HttpStatus.BAD_REQUEST, "email already existed");
        });
        Employer employer = this.employerRepository.save(Employer.builder()
                .email(employerDtoIn.getEmail())
                .name(employerDtoIn.getName())
                .province(employerDtoIn.getProvince())
                .description(employerDtoIn.getDescription())
                .build());
        return EmployerDtoOut.from(employer);
    }

    @Override
    public PageDtoOut<EmployerDtoOut> list(PageDtoIn pageDtoIn) {
        Page<Employer> employers = this.employerRepository.findAll(PageRequest.of(
                pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(),
                Sort.by("createdDate").ascending()
        ));
        return  PageDtoOut.from(pageDtoIn.getPage(),
                                pageDtoIn.getPageSize(),
                                employers.getTotalElements(),
                                employers.stream().map(EmployerDtoOut::from).toList());
    }

    @Override
    public EmployerDtoOut get(Integer id) {
      Employer employer =  this.employerRepository.findById(id).orElseThrow(
              ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Employer not found")
        );
      return EmployerDtoOut.from(employer);
    }

    @Override
    public EmployerDtoOut update(Integer id, EmployerDtoIn employerDtoIn) {
       Employer employer = employerRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "employer not found"));
       employer.setName(employerDtoIn.getName());
       if(employerDtoIn.getDescription() != null){
           employer.setDescription(employerDtoIn.getDescription());
       }

       if(employerDtoIn.getProvince() != null){
           employer.setProvince(employerDtoIn.getProvince());
       }

       if(employer.getProvince() == null){
           employer.setProvince(1);
       }

       employer.setUpdatedDate(Common.currentTime());
       employer = this.employerRepository.save(employer);
       return EmployerDtoOut.from(employer);
    }

    @Override
    public void delete(Integer id) {
        employerRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "user not found"));
        employerRepository.deleteById(id);
    }
}
