package people.catalog.controller;

import org.springframework.web.bind.annotation.*;
import people.catalog.dto.IdentificationDto;
import people.catalog.entity.Identification;
import people.catalog.service.IdentificationService;
import java.util.List;

@RestController
@RequestMapping("/identification")
public class IdentificationController {
    private final IdentificationService identificationService;

    public IdentificationController(IdentificationService identificationService) {
        this.identificationService = identificationService;
    }

    @GetMapping("/list")
    public List<IdentificationDto> getAllIdentification(){
        return identificationService.getAllIdentification();
    }

    @GetMapping("/get/{id}")
    public IdentificationDto getIdentificationById(@PathVariable("id") Long id){
        return identificationService.getIdentificationById(id);
    }

    @GetMapping("/get/document-number/{documentNumber}")
    public IdentificationDto getIdentificationByDocumentNumber(@PathVariable("documentNumber") Long documentNumber){
        return identificationService.getIdentificationByDocumentNumber(documentNumber);
    }

    @PostMapping("/new")
    public Identification createIdentification(@RequestBody Identification identification){
        return identificationService.saveNewIdentification(identification);
    }

    @PutMapping("/update/{id}")
    public Identification updateIdentification(@PathVariable("id") Long id, @RequestBody Identification identification){
        return identificationService.updateIdentification(id, identification);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteIdentificationById(@PathVariable Long id){
        identificationService.deleteIdentification(id);
    }
}
