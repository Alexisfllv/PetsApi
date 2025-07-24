package sora.com.lash.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.model.Breed;
import sora.com.lash.model.Owner;
import sora.com.lash.model.Pets;

@Mapper(componentModel = "spring")
public interface PetsMapper {
    // Request
    Pets toPets(PetsDTORequest petsDTORequest);

    // Response
//    @Mapping(target = "owner", source = "ownerDTOResponse")
//    @Mapping(target = "breed", source = "breedDTOResponse")
    PetsDTOResponse toPetsDTOResponse(Pets pets, OwnerDTOResponse ownerDTOResponse, BreedDTOResponse breedDTOResponse);

}
