package people.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.catalog.dto.UserProfileDto;
import people.catalog.entity.UserProfile;
import people.catalog.exception.NotFoundException;
import people.catalog.repo.UserProfileRepository;
import people.catalog.service.UserProfileService;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfileDto> getAllPeople() {
        return UserProfileDto.toModal(userProfileRepository.findAll());
    }

    @Override
    public UserProfileDto getPersonById(Long id) {
        return UserProfileDto.toModal(userProfileRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public UserProfileDto getPersonByFullName(String name, String surname, String patronymic) {
        return UserProfileDto.toModal(userProfileRepository.findByNameAndSurnameAndPatronymic(name, surname, patronymic).orElseThrow(NotFoundException::new));
    }

    @Override
    public List<UserProfileDto> getPeopleByBirthdate(String birthdate) {
        return UserProfileDto.toModal(userProfileRepository.findByBirthdate(birthdate));
    }

    @Override
    public List<UserProfileDto> getOlderPeople(int age) {
        return UserProfileDto.toModal(userProfileRepository.findByAgeGreaterThan(age));
    }

    @Override
    public UserProfile saveNewPerson(UserProfile user) {
        return userProfileRepository.save(user);
    }

    @Override
    public UserProfile updatePerson(Long id, UserProfile user) {
        UserProfile personUpdate = userProfileRepository.findById(id).orElseThrow(NotFoundException::new);

        personUpdate.setGender(user.getGender());
        personUpdate.setName(user.getName());
        personUpdate.setSurname(user.getSurname());
        personUpdate.setPatronymic(user.getPatronymic());
        personUpdate.setBirthdate(user.getBirthdate());
        personUpdate.setAge(user.getAge());
        personUpdate.setResidency(user.getResidency());
        personUpdate.setPhone(user.getPhone());
        personUpdate.setEmail(user.getEmail());

        userProfileRepository.save(personUpdate);
        return personUpdate;
    }

    @Override
    public void deletePerson(Long id) {
        UserProfile personDelete = userProfileRepository.findById(id).orElseThrow(NotFoundException::new);
        if (personDelete != null){
            userProfileRepository.deleteById(id);
        }
    }
}
