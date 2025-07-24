package sora.com.lash.service;

import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.model.Pets;
import sora.com.lash.model.Product;

import java.util.List;

public interface PetsService {

    //list
    List<PetsDTOResponse> listarTodos();
    // findby
    PetsDTOResponse buscarId(String id);
    // save
    PetsDTOResponse save(PetsDTORequest petsDTORequest);
    // modificar
    PetsDTOResponse update(String id, PetsDTORequest petsDTORequest);
    // eliminar
    void delete(String id);
}
