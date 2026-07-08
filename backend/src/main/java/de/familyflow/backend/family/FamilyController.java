package de.familyflow.backend.family;

import de.familyflow.backend.family.dto.FamilyRequestDTO;
import de.familyflow.backend.family.dto.FamilyResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/families")
public class FamilyController {


    private final FamilyService service;


    public FamilyController(FamilyService service) {
        this.service = service;
    }


    @GetMapping
    public List<FamilyResponseDTO> getAllFamilies() {
        return service.getAllFamilies();
    }


    @GetMapping("/{id}")
    public FamilyResponseDTO getFamilyById(
            @PathVariable Long id
    ) {
        return service.getFamilyById(id);
    }


    @PostMapping
    public FamilyResponseDTO createFamily(
            @RequestBody FamilyRequestDTO request
    ) {
        return service.createFamily(request);
    }


    @PutMapping("/{id}")
    public FamilyResponseDTO updateFamily(
            @PathVariable Long id,
            @RequestBody FamilyRequestDTO request
    ) {
        return service.updateFamily(id, request);
    }


    @DeleteMapping("/{id}")
    public void deleteFamily(
            @PathVariable Long id
    ) {
        service.deleteFamily(id);
    }
}