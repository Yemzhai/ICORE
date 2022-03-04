package people.catalog.controller;

import static org.mockito.Mockito.any;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import people.catalog.dto.IdentificationDto;
import people.catalog.entity.Gender;
import people.catalog.entity.Identification;
import people.catalog.entity.UserProfile;
import people.catalog.service.IdentificationService;

@ContextConfiguration(classes = {IdentificationController.class})
@ExtendWith(SpringExtension.class)
class IdentificationControllerTest {
    @Autowired
    private IdentificationController identificationController;

    @MockBean
    private IdentificationService identificationService;

    @Test
    void testCreateIdentification() throws Exception {
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
        when(this.identificationService.saveNewIdentification((Identification) any())).thenReturn(identification2);

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification3);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification4 = new Identification();
        identification4.setDocumentAuthority("JaneDoe");
        identification4.setDocumentNumber(1L);
        identification4.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setExpirationDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setId(123L);
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setIssueDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification4);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification5 = new Identification();
        identification5.setDocumentAuthority("JaneDoe");
        identification5.setDocumentNumber(1L);
        identification5.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setExpirationDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setId(123L);
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setIssueDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setUserProfile(userProfile3);
        String content = (new ObjectMapper()).writeValueAsString(identification5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/identification/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType"
                                        + "\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"Almaty\",\"issueDate\":0,\"expirationDate\":0,"
                                        + "\"userProfile\":{\"id\":null,\"gender\":null,\"name\":null,\"surname\":null,\"patronymic\":null,\"birthdate\":null"
                                        + ",\"age\":0,\"residency\":null,\"phone\":null,\"email\":null,\"identification\":null}}}}}}"));
    }

    @Test
    void testGetAllIdentification() throws Exception {
        when(this.identificationService.getAllIdentification()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/identification/list");
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllIdentification2() throws Exception {
        when(this.identificationService.getAllIdentification()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/identification/list");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetIdentificationById() throws Exception {
        IdentificationDto identificationDto = new IdentificationDto();
        identificationDto.setDocumentAuthority("JaneDoe");
        identificationDto.setDocumentNumber(1L);
        identificationDto.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identificationDto.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identificationDto.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identificationDto.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        when(this.identificationService.getIdentificationById((Long) any())).thenReturn(identificationDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/identification/get/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0}"));
    }

    @Test
    void testGetIdentificationByDocumentNumber() throws Exception {
        IdentificationDto identificationDto = new IdentificationDto();
        identificationDto.setDocumentAuthority("JaneDoe");
        identificationDto.setDocumentNumber(1L);
        identificationDto.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        identificationDto.setExpirationDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        identificationDto.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identificationDto.setIssueDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        when(this.identificationService.getIdentificationByDocumentNumber((Long) any())).thenReturn(identificationDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/identification/get/document-number/{documentNumber}", 1L);
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0}"));
    }

    @Test
    void testUpdateIdentification() throws Exception {
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
        when(this.identificationService.updateIdentification((Long) any(), (Identification) any()))
                .thenReturn(identification2);

        Identification identification3 = new Identification();
        identification3.setDocumentAuthority("JaneDoe");
        identification3.setDocumentNumber(1L);
        identification3.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setExpirationDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setId(123L);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification3.setIssueDate(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        identification3.setUserProfile(new UserProfile());

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setAge(1);
        userProfile2.setBirthdate("2020-03-01");
        userProfile2.setEmail("jane.doe@example.org");
        userProfile2.setGender(Gender.MALE);
        userProfile2.setId(123L);
        userProfile2.setIdentification(identification3);
        userProfile2.setName("Name");
        userProfile2.setPatronymic("Patronymic");
        userProfile2.setPhone("4105551212");
        userProfile2.setResidency("Residency");
        userProfile2.setSurname("Doe");

        Identification identification4 = new Identification();
        identification4.setDocumentAuthority("JaneDoe");
        identification4.setDocumentNumber(1L);
        identification4.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setExpirationDate(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setId(123L);
        LocalDateTime atStartOfDayResult9 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification4.setIssueDate(Date.from(atStartOfDayResult9.atZone(ZoneId.of("UTC")).toInstant()));
        identification4.setUserProfile(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setAge(1);
        userProfile3.setBirthdate("2020-03-01");
        userProfile3.setEmail("jane.doe@example.org");
        userProfile3.setGender(Gender.MALE);
        userProfile3.setId(123L);
        userProfile3.setIdentification(identification4);
        userProfile3.setName("Name");
        userProfile3.setPatronymic("Patronymic");
        userProfile3.setPhone("4105551212");
        userProfile3.setResidency("Residency");
        userProfile3.setSurname("Doe");

        Identification identification5 = new Identification();
        identification5.setDocumentAuthority("JaneDoe");
        identification5.setDocumentNumber(1L);
        identification5.setDocumentType("Document Type");
        LocalDateTime atStartOfDayResult10 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setExpirationDate(Date.from(atStartOfDayResult10.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setId(123L);
        LocalDateTime atStartOfDayResult11 = LocalDate.of(1970, 1, 1).atStartOfDay();
        identification5.setIssueDate(Date.from(atStartOfDayResult11.atZone(ZoneId.of("UTC")).toInstant()));
        identification5.setUserProfile(userProfile3);
        String content = (new ObjectMapper()).writeValueAsString(identification5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/identification/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate"
                                        + "\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic"
                                        + "\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency\":\"Residency\",\"phone\":\"4105551212\",\"email\""
                                        + ":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType\":\"Document Type\",\"documentNumber\":1"
                                        + ",\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,\"userProfile\":{\"id\":123,\"gender\":\"MALE"
                                        + "\",\"name\":\"Name\",\"surname\":\"Doe\",\"patronymic\":\"Patronymic\",\"birthdate\":\"2020-03-01\",\"age\":1,\"residency"
                                        + "\":\"Residency\",\"phone\":\"4105551212\",\"email\":\"jane.doe@example.org\",\"identification\":{\"id\":123,\"documentType"
                                        + "\":\"Document Type\",\"documentNumber\":1,\"documentAuthority\":\"JaneDoe\",\"issueDate\":0,\"expirationDate\":0,"
                                        + "\"userProfile\":{\"id\":null,\"gender\":null,\"name\":null,\"surname\":null,\"patronymic\":null,\"birthdate\":null"
                                        + ",\"age\":0,\"residency\":null,\"phone\":null,\"email\":null,\"identification\":null}}}}}}"));
    }

    @Test
    void testDeleteIdentificationById() throws Exception {
        doNothing().when(this.identificationService).deleteIdentification((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/identification/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteIdentificationById2() throws Exception {
        doNothing().when(this.identificationService).deleteIdentification((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/identification/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.identificationController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

