package people.catalog.dto;

import lombok.Data;
import people.catalog.entity.Gender;
import people.catalog.entity.Identification;
import people.catalog.entity.UserProfile;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserProfileDto {
    private Long id;
    private Gender gender;
    private String name;
    private String surname;
    private String patronymic;
    private String birthdate;
    private int age;
    private String residency;
    private String phone;
    private String email;
    private Identification identification;

    public static UserProfileDto toModal(UserProfile userProfile){
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(userProfile.getId());
        userProfileDto.setGender(userProfile.getGender());
        userProfileDto.setName(userProfile.getName());
        userProfileDto.setSurname(userProfile.getSurname());
        userProfileDto.setPatronymic(userProfile.getPatronymic());
        userProfileDto.setBirthdate(userProfile.getBirthdate());
        userProfileDto.setAge(userProfile.getAge());
        userProfileDto.setResidency(userProfile.getResidency());
        userProfileDto.setPhone(userProfile.getPhone());
        userProfileDto.setEmail(userProfile.getEmail());
        userProfileDto.setIdentification(userProfile.getIdentification());
        return userProfileDto;
    }

    public static List<UserProfileDto> toModal(List<UserProfile> userProfiles){
        List<UserProfileDto> userProfileDtoList;
        userProfileDtoList = userProfiles.stream().map(UserProfileDto::toModal).collect(Collectors.toList());
        return userProfileDtoList;
    }
}
