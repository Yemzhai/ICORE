package people.catalog.service;

import people.catalog.dto.IdentificationDto;
import people.catalog.entity.Identification;
import java.util.List;

public interface IdentificationService {
    List<IdentificationDto> getAllIdentification();
    IdentificationDto getIdentificationById(Long id);
    IdentificationDto getIdentificationByDocumentNumber(Long documentNumber);
    Identification saveNewIdentification(Identification identification);
    Identification updateIdentification(Long id, Identification identification);
    void deleteIdentification(Long id);
}
