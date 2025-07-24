package sora.com.lash.mapper;

import org.mapstruct.Mapper;
import sora.com.lash.dto.owner.OwnerDTORequest;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.model.Owner;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    Owner toOwner(OwnerDTORequest dto);
    OwnerDTOResponse toOwnerDTOResponse(Owner owner);
}