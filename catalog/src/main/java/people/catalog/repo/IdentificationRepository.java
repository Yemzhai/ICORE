package people.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import people.catalog.entity.Identification;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Long> {
    Identification findByDocumentNumber(Long documentNumber);
}
