package vn.unigap.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.Province;

@Repository
public interface ProvinceRepository extends CrudRepository<Province,Integer> {
}
