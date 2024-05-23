package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.Seeker;

@Repository
public interface SeekerRepository extends CrudRepository<Seeker, Long> {
    Page<Seeker> findAllByProvince(Pageable pageable,Integer provinceId);
}
