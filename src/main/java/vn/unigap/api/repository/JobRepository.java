package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.Jobs;

@Repository
public interface JobRepository extends CrudRepository<Jobs, Long> {
    Page<Jobs> findAll(Pageable page);
}
