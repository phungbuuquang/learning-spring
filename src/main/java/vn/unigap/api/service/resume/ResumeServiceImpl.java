package vn.unigap.api.service.resume;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.api.repository.ResumeRepository;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService{
    @Autowired
    private ResumeRepository resumeRepository;
}
