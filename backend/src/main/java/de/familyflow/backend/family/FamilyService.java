package de.familyflow.backend.family;

import de.familyflow.backend.family.dto.FamilyRequestDTO;
import de.familyflow.backend.family.dto.FamilyResponseDTO;
import de.familyflow.backend.notification.NotificationClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {

    private final FamilyRepository repository;
    private final NotificationClient notificationClient;


    public FamilyService(
            FamilyRepository repository,
            NotificationClient notificationClient
    ) {
        this.repository = repository;
        this.notificationClient = notificationClient;
    }


    public List<FamilyResponseDTO> getAllFamilies() {

        return repository.findAll()
                .stream()
                .map(family -> new FamilyResponseDTO(
                        family.getId(),
                        family.getFamilyName(),
                        family.getCreatedAt()
                ))
                .toList();
    }


    public FamilyResponseDTO getFamilyById(Long id) {

        Family family = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Family not found")
                );


        return new FamilyResponseDTO(
                family.getId(),
                family.getFamilyName(),
                family.getCreatedAt()
        );
    }


    public FamilyResponseDTO createFamily(
            FamilyRequestDTO request
    ) {

        Family family = new Family();

        family.setFamilyName(request.getFamilyName());


        Family saved = repository.save(family);


        // Kommunikation mit eigenständigem Notification-Service
        notificationClient.sendNotification(
                "FAMILY_CREATED",
                "Family created: " + saved.getFamilyName()
        );


        return new FamilyResponseDTO(
                saved.getId(),
                saved.getFamilyName(),
                saved.getCreatedAt()
        );
    }


    public FamilyResponseDTO updateFamily(
            Long id,
            FamilyRequestDTO request
    ) {

        Family family = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Family not found")
                );


        family.setFamilyName(request.getFamilyName());


        Family saved = repository.save(family);


        return new FamilyResponseDTO(
                saved.getId(),
                saved.getFamilyName(),
                saved.getCreatedAt()
        );
    }


    public void deleteFamily(Long id) {

        Family family = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Family not found")
                );


        repository.delete(family);
    }
}