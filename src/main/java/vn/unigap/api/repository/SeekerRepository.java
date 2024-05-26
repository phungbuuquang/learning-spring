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
    @Query("SELECT *, jp.name AS provinceName FROM Seeker s LEFT JOIN job_province jp On jp.id = s.province WHERE jp.id = :provinceId")
    Page<Seeker> findSeekersByProvinceId(Integer provinceId, Pageable pageable);
}
