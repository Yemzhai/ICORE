package people.catalog.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import people.catalog.dto.UserProfileDto;
import people.catalog.entity.Gender;
import people.catalog.entity.Identification;
import people.catalog.entity.UserProfile;
import people.catalog.service.UserProfileService;

@ContextConfiguration(classes = {UserProfileController.class})
@ExtendWith(SpringExtension.class)
class UserProfileControllerTest {
    @Autowired
    private UserProfileController userProfileController;

    @MockBean
    private UserProfileService userProfileService;

    @Test
    void testCreatePerson() throws Exception {
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
        when(this.userProfileService.saveNewPerson((UserProfile) any())).thenReturn(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(new Identification());
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(userProfile3);

        UserProfile userProfile4 = new UserProfile();
        userProfile4.setAge(1);
        userProfile4.setBirthdate("2020-03-01");
        userProfile4.setEmail("jane.doe@example.org");
        userProfile4.setGender(Gender.MALE);
        userProfile4.setId(123L);
        userProfile4.setIdentification(identification2);
        userProfile4.setName("Name");
        userProfile4.setPatronymic("Patronymic");
        userProfile4.setPhone("4105551212");
        userProfile4.setResidency("Residency");
        userProfile4.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile4);

        UserProfile userProfile5 = new UserProfile();
        userProfile5.setAge(1);
        userProfile5.setBirthdate("2020-03-01");
        userProfile5.setEmail("jane.doe@example.org");
        userProfile5.setGender(Gender.MALE);
        userProfile5.setId(123L);
        userProfile5.setIdentification(identification3);
        userProfile5.setName("Name");
        userProfile5.setPatronymic("Patronymic");
        userProfile5.setPhone("4105551212");
        userProfile5.setResidency("Residency");
        userProfile5.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(userProfile5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020"
                                        + "-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification"
                                        + "\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":null,"
                                        + "\"documentType\":null,\"documentNumber\":null,\"documentAuthority\":null,\"issueDate\":null,\"expirationDate\""
                                        + ":null,\"userProfile\":null}}}}}}"));
    }

    @Test
    void testGetAllPeople() throws Exception {
        when(this.userProfileService.getAllPeople()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person/list");
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdatePerson() throws Exception {
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
        when(this.userProfileService.updatePerson((Long) any(), (UserProfile) any())).thenReturn(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(new Identification());
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification2 = new Identification();
        identification2.setDocumentAuthority("JaneDoe");
        identification2.setDocumentNumber(1L);
        identification2.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setExpirationDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setId(123L);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification2.setIssueDate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        identification2.setUserProfile(userProfile3);

        UserProfile userProfile4 = new UserProfile();
        userProfile4.setAge(1);
        userProfile4.setBirthdate("2020-03-01");
        userProfile4.setEmail("jane.doe@example.org");
        userProfile4.setGender(Gender.MALE);
        userProfile4.setId(123L);
        userProfile4.setIdentification(identification2);
        userProfile4.setName("Name");
        userProfile4.setPatronymic("Patronymic");
        userProfile4.setPhone("4105551212");
        userProfile4.setResidency("Residency");
        userProfile4.setSurname("Doe");

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(userProfile4);

        UserProfile userProfile5 = new UserProfile();
        userProfile5.setAge(1);
        userProfile5.setBirthdate("2020-03-01");
        userProfile5.setEmail("jane.doe@example.org");
        userProfile5.setGender(Gender.MALE);
        userProfile5.setId(123L);
        userProfile5.setIdentification(identification3);
        userProfile5.setName("Name");
        userProfile5.setPatronymic("Patronymic");
        userProfile5.setPhone("4105551212");
        userProfile5.setResidency("Residency");
        userProfile5.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(userProfile5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/person/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020"
                                        + "-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification"
                                        + "\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":null,"
                                        + "\"documentType\":null,\"documentNumber\":null,\"documentAuthority\":null,\"issueDate\":null,\"expirationDate\""
                                        + ":null,\"userProfile\":null}}}}}}"));
    }

    @Test
    void testDeletePersonById() throws Exception {
        doNothing().when(this.userProfileService).deletePerson((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/person/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeletePersonById2() throws Exception {
        doNothing().when(this.userProfileService).deletePerson((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/person/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testFindPersonByBirthdate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person/birth")
                .param("birthdate", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testFindPersonByFullName() throws Exception {
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

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setAge(1);
        userProfileDto.setBirthdate("2020-03-01");
        userProfileDto.setEmail("jane.doe@example.org");
        userProfileDto.setGender(Gender.MALE);
        userProfileDto.setId(123L);
        userProfileDto.setIdentification(identification1);
        userProfileDto.setName("Name");
        userProfileDto.setPatronymic("Patronymic");
        userProfileDto.setPhone("4105551212");
        userProfileDto.setResidency("Residency");
        userProfileDto.setSurname("Doe");
        when(this.userProfileService.getPersonByFullName((String) any(), (String) any(), (String) any()))
                .thenReturn(userProfileDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person")
                .param("name", "foo")
                .param("patronymic", "foo")
                .param("surname", "foo");
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020"
                                        + "-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification"
                                        + "\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":null,"
                                        + "\"documentType\":null,\"documentNumber\":null,\"documentAuthority\":null,\"issueDate\":null,\"expirationDate\""
                                        + ":null,\"userProfile\":null}}}}}}"));
    }

    @Test
    void testFindPersonById() throws Exception {
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

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setAge(1);
        userProfileDto.setBirthdate("2020-03-01");
        userProfileDto.setEmail("jane.doe@example.org");
        userProfileDto.setGender(Gender.MALE);
        userProfileDto.setId(123L);
        userProfileDto.setIdentification(identification1);
        userProfileDto.setName("Name");
        userProfileDto.setPatronymic("Patronymic");
        userProfileDto.setPhone("4105551212");
        userProfileDto.setResidency("Residency");
        userProfileDto.setSurname("Doe");
        when(this.userProfileService.getPersonById((Long) any())).thenReturn(userProfileDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person/get/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020"
                                        + "-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification"
                                        + "\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":null,"
                                        + "\"documentType\":null,\"documentNumber\":null,\"documentAuthority\":null,\"issueDate\":null,\"expirationDate\""
                                        + ":null,\"userProfile\":null}}}}}}"));
    }

    @Test
    void testGetPeopleByAge() throws Exception {
        when(this.userProfileService.getOlderPeople(anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/person/older-than/{age}", 1);
        MockMvcBuilders.standaloneSetup(this.userProfileController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

