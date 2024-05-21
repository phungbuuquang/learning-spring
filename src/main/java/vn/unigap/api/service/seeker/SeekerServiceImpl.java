package vn.unigap.api.service.seeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.PageDtoIn;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.dto.out.SeekerDtoOut;
import vn.unigap.api.entity.Seeker;
import vn.unigap.api.repository.SeekerRepository;


@Service
public class SeekerServiceImpl implements SeekerService {
    @Autowired
    private SeekerRepository seekerRepository;

    @Override
    public PageDtoOut<SeekerDtoOut> list(PageDtoIn pageDtoIn, Integer provinceId) {
        Page<Seeker> seekers = seekerRepository.findAllByProvince(PageRequest.of(
               pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize()
        ) ,provinceId);

        return  PageDtoOut.from(pageDtoIn.getPage(),
                                pageDtoIn.getPageSize(),
                                seekers.getTotalElements(),
                seekers.stream().map(SeekerDtoOut::from).toList());
    }
}
