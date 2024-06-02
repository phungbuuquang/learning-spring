package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.Resume;

@Repository
public interface ResumeRepository extends CrudRepository<Resume,Long> {
    Page<Resume> findAllBySeekerId(Long seekerId, Pageable pageable);
}
