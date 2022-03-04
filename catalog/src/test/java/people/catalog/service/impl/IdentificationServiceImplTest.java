package people.catalog.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import people.catalog.dto.IdentificationDto;
import people.catalog.entity.Gender;
import people.catalog.entity.Identification;
import people.catalog.entity.UserProfile;
import people.catalog.exception.NotFoundException;
import people.catalog.repo.IdentificationRepository;

@ContextConfiguration(classes = {IdentificationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class IdentificationServiceImplTest {
    @MockBean
    private IdentificationRepository identificationRepository;

    @Autowired
    private IdentificationServiceImpl identificationServiceImpl;

    @Test
    void testGetAllIdentification() {
        when(this.identificationRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(this.identificationServiceImpl.getAllIdentification().isEmpty());
        verify(this.identificationRepository).findAll();
    }

    @Test
    void testGetAllIdentification2() {
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

        ArrayList<Identification> identificationList = new ArrayList<>();
        identificationList.add(identification1);
        when(this.identificationRepository.findAll()).thenReturn(identificationList);
        assertEquals(1, this.identificationServiceImpl.getAllIdentification().size());
        verify(this.identificationRepository).findAll();
    }

    @Test
    void testGetAllIdentification3() {
        when(this.identificationRepository.findAll()).thenThrow(new NotFoundException());
        assertThrows(NotFoundException.class, () -> this.identificationServiceImpl.getAllIdentification());
        verify(this.identificationRepository).findAll();
    }

    @Test
    void testGetAllIdentification4() {
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

        ArrayList<Identification> identificationList = new ArrayList<>();
        identificationList.add(identification3);
        identificationList.add(identification1);
        when(this.identificationRepository.findAll()).thenReturn(identificationList);
        assertEquals(2, this.identificationServiceImpl.getAllIdentification().size());
        verify(this.identificationRepository).findAll();
    }

    @Test
    void testGetIdentificationById() {
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
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        identification1.setExpirationDate(fromResult);
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        identification1.setIssueDate(fromResult1);
        identification1.setUserProfile(userProfile1);
        Optional<Identification> ofResult = Optional.of(identification1);
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);
        IdentificationDto actualIdentificationById = this.identificationServiceImpl.getIdentificationById(123L);
        assertEquals("JaneDoe", actualIdentificationById.getDocumentAuthority());
        assertSame(fromResult1, actualIdentificationById.getIssueDate());
        assertEquals(123L, actualIdentificationById.getId().longValue());
        assertSame(fromResult, actualIdentificationById.getExpirationDate());
        assertEquals("Document Type", actualIdentificationById.getDocumentType());
        assertEquals(1L, actualIdentificationById.getDocumentNumber().longValue());
        verify(this.identificationRepository).findById((Long) any());
        assertTrue(this.identificationServiceImpl.getAllIdentification().isEmpty());
    }

    @Test
    void testGetIdentificationByDocumentNumber() {
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
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        identification1.setExpirationDate(fromResult);
        identification1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        identification1.setIssueDate(fromResult1);
        identification1.setUserProfile(userProfile1);
        Optional<Identification> ofResult = Optional.of(identification1);
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);
        IdentificationDto actualIdentificationByDocumentNumber = this.identificationServiceImpl
                .getIdentificationByDocumentNumber(1L);
        assertEquals("JaneDoe", actualIdentificationByDocumentNumber.getDocumentAuthority());
        assertSame(fromResult1, actualIdentificationByDocumentNumber.getIssueDate());
        assertEquals(123L, actualIdentificationByDocumentNumber.getId().longValue());
        assertSame(fromResult, actualIdentificationByDocumentNumber.getExpirationDate());
        assertEquals("Document Type", actualIdentificationByDocumentNumber.getDocumentType());
        assertEquals(1L, actualIdentificationByDocumentNumber.getDocumentNumber().longValue());
        verify(this.identificationRepository).findById((Long) any());
        assertTrue(this.identificationServiceImpl.getAllIdentification().isEmpty());
    }

    @Test
    void testSaveNewIdentification() {
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
        identification2.setUserProfile(userProfile1);
        when(this.identificationRepository.save((Identification) any())).thenReturn(identification2);

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

        Identification identification4 = new Identification();
        identification4.setDocumentAuthority("JaneDoe");
        identification4.setDocumentNumber(1L);
        identification4.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setExpirationDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setId(123L);
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setIssueDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setUserProfile(userProfile3);
        assertSame(identification2, this.identificationServiceImpl.saveNewIdentification(identification4));
        verify(this.identificationRepository).save((Identification) any());
    }

    @Test
    void testUpdateIdentification() {
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
        Optional<Identification> ofResult = Optional.of(identification1);

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

        Identification identification4 = new Identification();
        identification4.setDocumentAuthority("JaneDoe");
        identification4.setDocumentNumber(1L);
        identification4.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setExpirationDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setId(123L);
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setIssueDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setUserProfile(userProfile3);
        when(this.identificationRepository.save((Identification) any())).thenReturn(identification4);
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);

        UserProfile userProfile4 = new UserProfile();
        userProfile4.setAge(1);
        userProfile4.setBirthdate("2020-03-01");
        userProfile4.setEmail("jane.doe@example.org");
        userProfile4.setGender(Gender.MALE);
        userProfile4.setId(123L);
        userProfile4.setIdentification(new Identification());
        userProfile4.setName("Name");
        userProfile4.setPatronymic("Patronymic");
        userProfile4.setPhone("4105551212");
        userProfile4.setResidency("Residency");
        userProfile4.setSurname("Doe");

        Identification identification5 = new Identification();
        identification5.setDocumentAuthority("JaneDoe");
        identification5.setDocumentNumber(1L);
        identification5.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setExpirationDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setId(123L);
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setIssueDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setUserProfile(userProfile4);

        UserProfile userProfile5 = new UserProfile();
        userProfile5.setAge(1);
        userProfile5.setBirthdate("2020-03-01");
        userProfile5.setEmail("jane.doe@example.org");
        userProfile5.setGender(Gender.MALE);
        userProfile5.setId(123L);
        userProfile5.setIdentification(identification5);
        userProfile5.setName("Name");
        userProfile5.setPatronymic("Patronymic");
        userProfile5.setPhone("4105551212");
        userProfile5.setResidency("Residency");
        userProfile5.setSurname("Doe");

        Identification identification6 = new Identification();
        identification6.setDocumentAuthority("JaneDoe");
        identification6.setDocumentNumber(1L);
        identification6.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult12 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult12.atZone(ZoneId.of("UTC")).toInstant());
        identification6.setExpirationDate(fromResult);
        identification6.setId(123L);
        LocalDateTime atStartOfDayResult13 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult13.atZone(ZoneId.of("UTC")).toInstant());
        identification6.setIssueDate(fromResult1);
        identification6.setUserProfile(userProfile5);
        Identification actualUpdateIdentificationResult = this.identificationServiceImpl.updateIdentification(123L,
                identification6);
        assertSame(identification1, actualUpdateIdentificationResult);
        assertEquals("JaneDoe", actualUpdateIdentificationResult.getDocumentAuthority());
        assertSame(fromResult1, actualUpdateIdentificationResult.getIssueDate());
        assertEquals(1L, actualUpdateIdentificationResult.getDocumentNumber().longValue());
        assertSame(fromResult, actualUpdateIdentificationResult.getExpirationDate());
        assertEquals(123L, actualUpdateIdentificationResult.getId().longValue());
        assertEquals("Document Type", actualUpdateIdentificationResult.getDocumentType());
        verify(this.identificationRepository).save((Identification) any());
        verify(this.identificationRepository).findById((Long) any());
    }

    @Test
    void testUpdateIdentification2() {
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
        Optional<Identification> ofResult = Optional.of(identification1);
        when(this.identificationRepository.save((Identification) any())).thenThrow(new NotFoundException());
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);

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
        assertThrows(NotFoundException.class,
                () -> this.identificationServiceImpl.updateIdentification(123L, identification3));
        verify(this.identificationRepository).save((Identification) any());
        verify(this.identificationRepository).findById((Long) any());
    }

    @Test
    void testDeleteIdentification() {
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
        Optional<Identification> ofResult = Optional.of(identification1);
        doNothing().when(this.identificationRepository).deleteById((Long) any());
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);
        this.identificationServiceImpl.deleteIdentification(123L);
        verify(this.identificationRepository).findById((Long) any());
        verify(this.identificationRepository).deleteById((Long) any());
        assertTrue(this.identificationServiceImpl.getAllIdentification().isEmpty());
    }

    @Test
    void testDeleteIdentification2() {
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
        Optional<Identification> ofResult = Optional.of(identification1);
        doThrow(new NotFoundException()).when(this.identificationRepository).deleteById((Long) any());
        when(this.identificationRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(NotFoundException.class, () -> this.identificationServiceImpl.deleteIdentification(123L));
        verify(this.identificationRepository).findById((Long) any());
        verify(this.identificationRepository).deleteById((Long) any());
    }
}

