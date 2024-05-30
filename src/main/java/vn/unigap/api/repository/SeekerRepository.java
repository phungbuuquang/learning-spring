package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.unigap.api.dto.out.SeekerDtoOut;
import vn.unigap.api.entity.Seeker;

import java.util.List;
import java.util.Map;

@Repository
public interface SeekerRepository extends CrudRepository<Seeker, Long> {


    Page<Seeker> findAllByProvinceId(Integer provinceId, Pageable pageable);

    @Query(value = "SELECT s.*, jp.name AS provinceName FROM Seeker s LEFT JOIN job_province jp On jp.id = s.province WHERE jp.id = :provinceId",
            nativeQuery = true)
    List<Map<String, Object>> findSeekersByProvinceIdRaw(Integer provinceId);
}
