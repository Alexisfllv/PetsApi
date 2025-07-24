package sora.com.lash.service;

import sora.com.lash.dto.owner.OwnerDTORequest;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;

import java.util.List;

public interface OwnerService {
    //list
    List<OwnerDTOResponse> listarTodos();
    // findby
    OwnerDTOResponse buscarId(String id);
    // save
    OwnerDTOResponse save(OwnerDTORequest ownerDTORequest);
    // modificar
    OwnerDTOResponse update(String id, OwnerDTORequest ownerDTORequest);
    // eliminar
    void delete(String id);
}
