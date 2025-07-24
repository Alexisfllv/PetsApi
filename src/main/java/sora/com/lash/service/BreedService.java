package sora.com.lash.service;

import sora.com.lash.dto.breed.BreedDTORequest;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.dto.owner.OwnerDTORequest;
import sora.com.lash.dto.owner.OwnerDTOResponse;

import java.util.List;

public interface BreedService {
    //list
    List<BreedDTOResponse> listarTodos();
    // findby
    BreedDTOResponse buscarId(String id);
    // save
    BreedDTOResponse save(BreedDTORequest breedDTORequest);
    // modificar
    BreedDTOResponse update(String id, BreedDTORequest breedDTORequest);
    // eliminar
    void delete(String id);
}
