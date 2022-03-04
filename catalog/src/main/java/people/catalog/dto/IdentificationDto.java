package people.catalog.dto;

import lombok.Data;
import people.catalog.entity.Identification;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class IdentificationDto {
    private Long id;
    private String documentType;
    private Long documentNumber;
    private String documentAuthority;
    private Date issueDate;
    private Date expirationDate;

    public static IdentificationDto toModal(Identification identification){
        IdentificationDto identificationDto = new IdentificationDto();
        identificationDto.setId(identification.getId());
        identificationDto.setDocumentType(identification.getDocumentType());
        identificationDto.setDocumentNumber(identification.getDocumentNumber());
        identificationDto.setDocumentAuthority(identification.getDocumentAuthority());
        identificationDto.setIssueDate(identification.getIssueDate());
        identificationDto.setExpirationDate(identification.getExpirationDate());
        return identificationDto;
    }

    public static List<IdentificationDto> toModal(List<Identification> identificationList){
        List<IdentificationDto> identificationDtoList;
        identificationDtoList = identificationList.stream().map(IdentificationDto::toModal).collect(Collectors.toList());
        return identificationDtoList;
    }
}
