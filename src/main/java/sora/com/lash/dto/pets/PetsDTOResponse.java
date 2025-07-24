package sora.com.lash.dto.pets;

import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.dto.owner.OwnerDTOResponse;

import java.time.LocalDate;

public record PetsDTOResponse(
        String petId,
        String petName,
        String petType,
        String petImage,
        OwnerDTOResponse ownerDTOResponse,
        BreedDTOResponse breedDTOResponse,
        LocalDate birthDate
) {
}
