package sora.com.lash.mapper;

import org.mapstruct.Mapper;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.model.Pets;

@Mapper(componentModel = "spring")
public interface PetsMapper {
    // Request
    Pets toPets(PetsDTORequest petsDTORequest);
    // Response
    PetsDTOResponse toPetsDTOResponse(Pets pets);

}
