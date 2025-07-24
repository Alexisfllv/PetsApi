package sora.com.lash.dto.pets;

import java.time.LocalDate;

public record PetsDTORequest(
        String petName,
        String petType,
        String petImage,
        String ownerId,
        String breedId,
        LocalDate birthDate
) {
}
