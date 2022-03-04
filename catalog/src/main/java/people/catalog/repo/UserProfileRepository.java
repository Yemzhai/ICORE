package people.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import people.catalog.entity.UserProfile;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    List<UserProfile> findByAgeGreaterThan(int age);
    Optional<UserProfile> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
    List<UserProfile> findByBirthdate(String birthdate);
}
