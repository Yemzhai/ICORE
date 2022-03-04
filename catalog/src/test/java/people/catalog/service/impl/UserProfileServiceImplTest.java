package people.catalog.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import people.catalog.dto.UserProfileDto;
import people.catalog.entity.Gender;
import people.catalog.entity.Identification;
import people.catalog.entity.UserProfile;
import people.catalog.exception.NotFoundException;
import people.catalog.repo.UserProfileRepository;

@ContextConfiguration(classes = {UserProfileServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserProfileServiceImplTest {
    @MockBean
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileServiceImpl userProfileServiceImpl;

    @Test
    void testGetAllPeople() {
        when(this.userProfileRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
        verify(this.userProfileRepository).findAll();
    }

    @Test
    void testGetAllPeople2() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findAll()).thenReturn(userProfileList);
        assertEquals(1, this.userProfileServiceImpl.getAllPeople().size());
        verify(this.userProfileRepository).findAll();
    }

    @Test
    void testGetAllPeople3() {
        when(this.userProfileRepository.findAll()).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.userProfileServiceImpl.getAllPeople());
        verify(this.userProfileRepository).findAll();
    }

    @Test
    void testGetAllPeople4() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification2);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification3);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile3);
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findAll()).thenReturn(userProfileList);
        assertEquals(2, this.userProfileServiceImpl.getAllPeople().size());
        verify(this.userProfileRepository).findAll();
    }

    @Test
    void testGetPersonById() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);
        when(this.userProfileRepository.findById((Long) any())).thenReturn(ofResult);
        UserProfileDto actualPersonById = this.userProfileServiceImpl.getPersonById(123L);
        assertEquals(1, actualPersonById.getAge());
        assertEquals("Doe", actualPersonById.getSurname());
        assertEquals("Residency", actualPersonById.getResidency());
        assertEquals("4105551212", actualPersonById.getPhone());
        assertEquals("Patronymic", actualPersonById.getPatronymic());
        assertEquals("Name", actualPersonById.getName());
        assertSame(identification1, actualPersonById.getIdentification());
        assertEquals(123L, actualPersonById.getId());
        assertEquals("2020-03-01", actualPersonById.getBirthdate());
        assertEquals(Gender.MALE, actualPersonById.getGender());
        assertEquals("jane.doe@example.org", actualPersonById.getEmail());
        verify(this.userProfileRepository).findById((Long) any());
    }

    @Test
    void testGetPersonByFullName() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);
        when(this.userProfileRepository.findByNameAndSurnameAndPatronymic((String) any(), (String) any(), (String) any()))
                .thenReturn(ofResult);
        UserProfileDto actualPersonByFullName = this.userProfileServiceImpl.getPersonByFullName("Name", "Doe",
                "Patronymic");
        assertEquals(1, actualPersonByFullName.getAge());
        assertEquals("Doe", actualPersonByFullName.getSurname());
        assertEquals("Residency", actualPersonByFullName.getResidency());
        assertEquals("4105551212", actualPersonByFullName.getPhone());
        assertEquals("Patronymic", actualPersonByFullName.getPatronymic());
        assertEquals("Name", actualPersonByFullName.getName());
        assertSame(identification1, actualPersonByFullName.getIdentification());
        assertEquals(123L, actualPersonByFullName.getId());
        assertEquals("2020-03-01", actualPersonByFullName.getBirthdate());
        assertEquals(Gender.MALE, actualPersonByFullName.getGender());
        assertEquals("jane.doe@example.org", actualPersonByFullName.getEmail());
        verify(this.userProfileRepository).findByNameAndSurnameAndPatronymic((String) any(), (String) any(),
                (String) any());
    }

    @Test
    void testGetPeopleByBirthdate() {
        when(this.userProfileRepository.findByBirthdate((String) any())).thenReturn(new ArrayList<>());
        List<UserProfileDto> actualPeopleByBirthdate = this.userProfileServiceImpl.getPeopleByBirthdate("2020-03-01");
        assertTrue(actualPeopleByBirthdate.isEmpty());
        verify(this.userProfileRepository).findByBirthdate((String) any());
        assertEquals(actualPeopleByBirthdate, this.userProfileServiceImpl.getAllPeople());
    }

    @Test
    void testGetPeopleByBirthdate2() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findByBirthdate((String) any())).thenReturn(userProfileList);
        assertEquals(1, this.userProfileServiceImpl.getPeopleByBirthdate("2020-03-01").size());
        verify(this.userProfileRepository).findByBirthdate((String) any());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
    }

    @Test
    void testGetPeopleByBirthdate3() {
        when(this.userProfileRepository.findByBirthdate((String) any())).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.userProfileServiceImpl.getPeopleByBirthdate("2020-03-01"));
        verify(this.userProfileRepository).findByBirthdate((String) any());
    }

    @Test
    void testGetPeopleByBirthdate4() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification2);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification3);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile3);
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findByBirthdate((String) any())).thenReturn(userProfileList);
        assertEquals(2, this.userProfileServiceImpl.getPeopleByBirthdate("2020-03-01").size());
        verify(this.userProfileRepository).findByBirthdate((String) any());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
    }

    @Test
    void testGetOlderPeople() {
        when(this.userProfileRepository.findByAgeGreaterThan(anyInt())).thenReturn(new ArrayList<>());
        List<UserProfileDto> actualOlderPeople = this.userProfileServiceImpl.getOlderPeople(1);
        assertTrue(actualOlderPeople.isEmpty());
        verify(this.userProfileRepository).findByAgeGreaterThan(anyInt());
        assertEquals(actualOlderPeople, this.userProfileServiceImpl.getAllPeople());
    }

    @Test
    void testGetOlderPeople2() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findByAgeGreaterThan(anyInt())).thenReturn(userProfileList);
        assertEquals(1, this.userProfileServiceImpl.getOlderPeople(1).size());
        verify(this.userProfileRepository).findByAgeGreaterThan(anyInt());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
    }

    @Test
    void testGetOlderPeople3() {
        when(this.userProfileRepository.findByAgeGreaterThan(anyInt())).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.userProfileServiceImpl.getOlderPeople(1));
        verify(this.userProfileRepository).findByAgeGreaterThan(anyInt());
    }

    @Test
    void testGetOlderPeople4() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification2);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification3);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        ArrayList<UserProfile> userProfileList = new ArrayList<>();
        userProfileList.add(userProfile3);
        userProfileList.add(userProfile1);
        when(this.userProfileRepository.findByAgeGreaterThan(anyInt())).thenReturn(userProfileList);
        assertEquals(2, this.userProfileServiceImpl.getOlderPeople(1).size());
        verify(this.userProfileRepository).findByAgeGreaterThan(anyInt());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
    }

    @Test
    void testSaveNewPerson() {
        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(new Identification());
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile1);

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification1);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");
        when(this.userProfileRepository.save((UserProfile) any())).thenReturn(userProfile2);

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(new UserProfile());

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification2);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile3);

        UserProfile userProfile4 = new UserProfile();
        userProfile4.setAge(1);
        userProfile4.setBirthdate("2020-03-01");
        userProfile4.setEmail("jane.doe@example.org");
        userProfile4.setGender(Gender.MALE);
        userProfile4.setId(123L);
        userProfile4.setIdentification(identification3);
        userProfile4.setName("Name");
        userProfile4.setPatronymic("Patronymic");
        userProfile4.setPhone("4105551212");
        userProfile4.setResidency("Residency");
        userProfile4.setSurname("Doe");
        assertSame(userProfile2, this.userProfileServiceImpl.saveNewPerson(userProfile4));
        verify(this.userProfileRepository).save((UserProfile) any());
    }

    @Test
    void testUpdatePerson() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(new Identification());
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification2);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile3);

        UserProfile userProfile4 = new UserProfile();
        userProfile4.setAge(1);
        userProfile4.setBirthdate("2020-03-01");
        userProfile4.setEmail("jane.doe@example.org");
        userProfile4.setGender(Gender.MALE);
        userProfile4.setId(123L);
        userProfile4.setIdentification(identification3);
        userProfile4.setName("Name");
        userProfile4.setPatronymic("Patronymic");
        userProfile4.setPhone("4105551212");
        userProfile4.setResidency("Residency");
        userProfile4.setSurname("Doe");
        when(this.userProfileRepository.save((UserProfile) any())).thenReturn(userProfile4);
        when(this.userProfileRepository.findById((Long) any())).thenReturn(ofResult);

        Identification identification4 = new Identification();
        identification4.setDocumentAuthority("JaneDoe");
        identification4.setDocumentNumber(1L);
        identification4.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setExpirationDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setId(123L);
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setIssueDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setUserProfile(new UserProfile());

        UserProfile userProfile5 = new UserProfile();
        userProfile5.setAge(1);
        userProfile5.setBirthdate("2020-03-01");
        userProfile5.setEmail("jane.doe@example.org");
        userProfile5.setGender(Gender.MALE);
        userProfile5.setId(123L);
        userProfile5.setIdentification(identification4);
        userProfile5.setName("Name");
        userProfile5.setPatronymic("Patronymic");
        userProfile5.setPhone("4105551212");
        userProfile5.setResidency("Residency");
        userProfile5.setSurname("Doe");

        Identification identification5 = new Identification();
        identification5.setDocumentAuthority("JaneDoe");
        identification5.setDocumentNumber(1L);
        identification5.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setExpirationDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setId(123L);
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setIssueDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setUserProfile(userProfile5);

        UserProfile userProfile6 = new UserProfile();
        userProfile6.setAge(1);
        userProfile6.setBirthdate("2020-03-01");
        userProfile6.setEmail("jane.doe@example.org");
        userProfile6.setGender(Gender.MALE);
        userProfile6.setId(123L);
        userProfile6.setIdentification(identification5);
        userProfile6.setName("Name");
        userProfile6.setPatronymic("Patronymic");
        userProfile6.setPhone("4105551212");
        userProfile6.setResidency("Residency");
        userProfile6.setSurname("Doe");
        UserProfile actualUpdatePersonResult = this.userProfileServiceImpl.updatePerson(123L, userProfile6);
        assertSame(userProfile1, actualUpdatePersonResult);
        assertEquals(1, actualUpdatePersonResult.getAge());
        assertEquals("Doe", actualUpdatePersonResult.getSurname());
        assertEquals("Residency", actualUpdatePersonResult.getResidency());
        assertEquals("4105551212", actualUpdatePersonResult.getPhone());
        assertEquals("Patronymic", actualUpdatePersonResult.getPatronymic());
        assertEquals("Name", actualUpdatePersonResult.getName());
        assertEquals("2020-03-01", actualUpdatePersonResult.getBirthdate());
        assertEquals(Gender.MALE, actualUpdatePersonResult.getGender());
        assertEquals("jane.doe@example.org", actualUpdatePersonResult.getEmail());
        verify(this.userProfileRepository).save((UserProfile) any());
        verify(this.userProfileRepository).findById((Long) any());
    }

    @Test
    void testUpdatePerson2() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);
        when(this.userProfileRepository.save((UserProfile) any())).thenThrow(new NotFoundException());
        when(this.userProfileRepository.findById((Long) any())).thenReturn(ofResult);

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification2);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification3);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");
        assertThrows(NotFoundException.class, () -> this.userProfileServiceImpl.updatePerson(123L, userProfile3));
        verify(this.userProfileRepository).save((UserProfile) any());
        verify(this.userProfileRepository).findById((Long) any());
    }

    @Test
    void testDeletePerson() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);
        doNothing().when(this.userProfileRepository).deleteById((Long) any());
        when(this.userProfileRepository.findById((Long) any())).thenReturn(ofResult);
        this.userProfileServiceImpl.deletePerson(123L);
        verify(this.userProfileRepository).findById((Long) any());
        verify(this.userProfileRepository).deleteById((Long) any());
        assertTrue(this.userProfileServiceImpl.getAllPeople().isEmpty());
    }

    @Test
    void testDeletePerson2() {
        Identification identification = new Identification();
        identification.setDocumentAuthority("JaneDoe");
        identification.setDocumentNumber(1L);
        identification.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        identification.setUserProfile(new UserProfile());

        UserProfile userProfile = new UserProfile();
        userProfile.setAge(1);
        userProfile.setBirthdate("2020-03-01");
        userProfile.setEmail("jane.doe@example.org");
        userProfile.setGender(Gender.MALE);
        userProfile.setId(123L);
        userProfile.setIdentification(identification);
        userProfile.setName("Name");
        userProfile.setPatronymic("Patronymic");
        userProfile.setPhone("4105551212");
        userProfile.setResidency("Residency");
        userProfile.setSurname("Doe");

        Identification identification1 = new Identification();
        identification1.setDocumentAuthority("JaneDoe");
        identification1.setDocumentNumber(1L);
        identification1.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setExpirationDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification1.setIssueDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        identification1.setUserProfile(userProfile);

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setAge(1);
        userProfile1.setBirthdate("2020-03-01");
        userProfile1.setEmail("jane.doe@example.org");
        userProfile1.setGender(Gender.MALE);
        userProfile1.setId(123L);
        userProfile1.setIdentification(identification1);
        userProfile1.setName("Name");
        userProfile1.setPatronymic("Patronymic");
        userProfile1.setPhone("4105551212");
        userProfile1.setResidency("Residency");
        userProfile1.setSurname("Doe");
        Optional<UserProfile> ofResult = Optional.of(userProfile1);
        doThrow(new NotFoundException()).when(this.userProfileRepository).deleteById((Long) any());
        when(this.userProfileRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.userProfileServiceImpl.deletePerson(123L));
        verify(this.userProfileRepository).findById((Long) any());
        verify(this.userProfileRepository).deleteById((Long) any());
    }
}

