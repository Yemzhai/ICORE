package people.catalog.service;

import people.catalog.dto.UserProfileDto;
import people.catalog.entity.UserProfile;
import java.util.List;

public interface UserProfileService {
    List<UserProfileDto> getAllPeople();
    UserProfileDto getPersonById(Long id);
    UserProfileDto getPersonByFullName(String name, String surname, String patronymic);
    List<UserProfileDto> getPeopleByBirthdate(String birthdate);
    List<UserProfileDto> getOlderPeople(int age);
    UserProfile saveNewPerson(UserProfile user);
    UserProfile updatePerson(Long id, UserProfile user);
    void deletePerson(Long id);
}
