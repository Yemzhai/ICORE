package people.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import people.catalog.dto.IdentificationDto;
import people.catalog.entity.Identification;
import people.catalog.exception.NotFoundException;
import people.catalog.repo.IdentificationRepository;
import people.catalog.service.IdentificationService;
import java.util.List;

@Service
public class IdentificationServiceImpl implements IdentificationService {

    @Autowired
    private IdentificationRepository identificationRepository;

    @Override
    public List<IdentificationDto> getAllIdentification() {
        return IdentificationDto.toModal(identificationRepository.findAll());
    }

    @Override
    public IdentificationDto getIdentificationById(Long id) {
        return IdentificationDto.toModal(identificationRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public IdentificationDto getIdentificationByDocumentNumber(Long documentNumber) {
        return IdentificationDto.toModal(identificationRepository.findById(documentNumber).orElseThrow(NotFoundException::new));
    }

    @Override
    public Identification saveNewIdentification(Identification identification) {
        return identificationRepository.save(identification);
    }

    @Override
    public Identification updateIdentification(Long id, Identification identification) {
        Identification identificationUpdate = identificationRepository.findById(id).orElseThrow(NotFoundException::new);

        identificationUpdate.setId(identification.getId());
        identificationUpdate.setDocumentType(identification.getDocumentType());
        identificationUpdate.setDocumentNumber(identification.getDocumentNumber());
        identificationUpdate.setDocumentAuthority(identification.getDocumentAuthority());
        identificationUpdate.setIssueDate(identification.getIssueDate());
        identificationUpdate.setExpirationDate(identification.getExpirationDate());

        identificationRepository.save(identificationUpdate);
        return identificationUpdate;    }

    @Override
    public void deleteIdentification(Long id) {
        Identification identificationDelete = identificationRepository.findById(id).orElseThrow(NotFoundException::new);
        if (identificationDelete != null){
            identificationRepository.deleteById(id);
        }
    }
}
