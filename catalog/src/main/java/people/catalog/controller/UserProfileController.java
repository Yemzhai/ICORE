package people.catalog.controller;

import org.springframework.web.bind.annotation.*;
import people.catalog.dto.UserProfileDto;
import people.catalog.entity.UserProfile;
import people.catalog.service.UserProfileService;
import java.util.List;

@RestController
@RequestMapping("/person")
public class UserProfileController {
    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/list")
    public List<UserProfileDto> getAllPeople(){
        return userProfileService.getAllPeople();
    }

    @GetMapping("/get/{id}")
    public UserProfileDto findPersonById(@PathVariable("id") Long id){
        return userProfileService.getPersonById(id);
    }

    @GetMapping("")
    public UserProfileDto findPersonByFullName(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname,
                                         @RequestParam("patronymic") String patronymic){
        return userProfileService.getPersonByFullName(name, surname, patronymic);
    }

    @GetMapping("/birth")
    public List<UserProfileDto> findPersonByBirthdate(@RequestParam("date") String birthdate){
        return userProfileService.getPeopleByBirthdate(birthdate);
    }

    @GetMapping("/older-than/{age}")
    public List<UserProfileDto> getPeopleByAge(@PathVariable("age") int age){
        return userProfileService.getOlderPeople(age);
    }

    @PostMapping("/new")
    public UserProfile createPerson(@RequestBody UserProfile person){
        return userProfileService.saveNewPerson(person);
    }

    @PutMapping("/update/{id}")
    public UserProfile updatePerson(@PathVariable("id") Long id, @RequestBody UserProfile person){
        return userProfileService.updatePerson(id, person);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id){
        userProfileService.deletePerson(id);
    }
}
