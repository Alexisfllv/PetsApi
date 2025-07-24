package sora.com.lash.mapper;

import org.mapstruct.Mapper;
import sora.com.lash.dto.breed.BreedDTORequest;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.model.Breed;

@Mapper(componentModel = "spring")
public interface BreedMapper {
    Breed toBreed(BreedDTORequest dto);
    BreedDTOResponse toBreedDTOResponse(Breed breed);
}
