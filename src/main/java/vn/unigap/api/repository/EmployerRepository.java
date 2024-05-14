package vn.unigap.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.unigap.api.entity.Employer;
import java.util.Optional;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
    Optional<Employer> findByEmail(String email);
    Page<Employer> findAll(Pageable page);


}
