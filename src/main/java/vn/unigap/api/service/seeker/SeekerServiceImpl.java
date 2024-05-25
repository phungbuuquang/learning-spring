package vn.unigap.api.service.seeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.in.SeekerDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.SeekerDtoOut;
import vn.unigap.api.entity.Seeker;
import vn.unigap.api.repository.SeekerRepository;
import vn.unigap.common.errorcode.ErrorCode;
import vn.unigap.common.exception.ApiException;


@Service
public class SeekerServiceImpl implements SeekerService {
    @Autowired
    private SeekerRepository seekerRepository;

    @Override
    public PageDtoOut<SeekerDtoOut> list(PageDtoIn pageDtoIn, Integer provinceId) {
        Page<Seeker> seekers = seekerRepository.findAllByProvince(PageRequest.of(
               pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(),
                Sort.by("createdAt").ascending()
        ) ,provinceId);

        return  PageDtoOut.from(pageDtoIn.getPage(),
                                pageDtoIn.getPageSize(),
                                seekers.getTotalElements(),
                seekers.stream().map(SeekerDtoOut::from).toList());
    }

    @Override
    public SeekerDtoOut get(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Seeker not found")
        );
        return SeekerDtoOut.from(seeker);
    }

    @Override
    public SeekerDtoOut create(SeekerDtoIn seekerDtoIn) {
        Seeker seeker = seekerRepository.save(
                Seeker.builder()
                        .name(seekerDtoIn.getName())
                        .birthday(seekerDtoIn.getBirthday())
                        .address(seekerDtoIn.getAddress())
                        .province(seekerDtoIn.getProvinceId())
                        .build()
        );
        return SeekerDtoOut.from(seeker);
    }

    @Override
    public SeekerDtoOut update(Long id, SeekerDtoIn seekerDtoIn) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Seeker not found")
        );
        Seeker res = seekerRepository.save(seekerDtoIn.copy(seeker));
        return SeekerDtoOut.from(res);
    }

    @Override
    public void delete(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                ()-> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Seeker not found")
        );
         seekerRepository.deleteById(id);
    }
}
