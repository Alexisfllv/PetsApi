package sora.com.lash.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.mapper.BreedMapper;
import sora.com.lash.mapper.OwnerMapper;
import sora.com.lash.mapper.PetsMapper;
import sora.com.lash.model.Breed;
import sora.com.lash.model.Owner;
import sora.com.lash.model.Pets;
import sora.com.lash.repository.BreedRepository;
import sora.com.lash.repository.OwnerRepository;
import sora.com.lash.repository.PetsRepository;
import sora.com.lash.service.PetsService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetsServiceImpl implements PetsService {

    private final PetsRepository petsRepository;
    private final PetsMapper petsMapper;
    private final BreedRepository breedRepository;
    private final OwnerRepository ownerRepository;

    private final BreedMapper breedMapper;
    private final OwnerMapper ownerMapper;



    @Override
    public List<PetsDTOResponse> listarTodos() {
        List<Pets> petsList = petsRepository.findAll();

        return petsList.stream()
                .map(pets -> {
                    Breed breed = breedRepository.findById(pets.getBreedId())
                            .orElseThrow(() -> new RuntimeException("Breed not found: " + pets.getBreedId()));

                    Owner owner = ownerRepository.findById(pets.getOwnerId())
                            .orElseThrow(() -> new RuntimeException("Owner not found: " + pets.getOwnerId()));

                    BreedDTOResponse breedDTO = breedMapper.toBreedDTOResponse(breed);
                    OwnerDTOResponse ownerDTO = ownerMapper.toOwnerDTOResponse(owner);

                    return petsMapper.toPetsDTOResponse(pets, ownerDTO, breedDTO);
                })
                .collect(Collectors.toList());
    }

    @Override
    public PetsDTOResponse buscarId(String id) {
        Pets pets = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found pet with id: " + id));

        Breed breed = breedRepository.findById(pets.getBreedId())
                .orElseThrow(() -> new RuntimeException("Breed not found: " + pets.getBreedId()));

        Owner owner = ownerRepository.findById(pets.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found: " + pets.getOwnerId()));

        BreedDTOResponse breedDTO = breedMapper.toBreedDTOResponse(breed);
        OwnerDTOResponse ownerDTO = ownerMapper.toOwnerDTOResponse(owner);

        return petsMapper.toPetsDTOResponse(pets, ownerDTO, breedDTO);
    }


    @Override
    public PetsDTOResponse save(PetsDTORequest petsDTORequest) {
        Pets pets = petsMapper.toPets(petsDTORequest);
        // breed
        Breed breed = breedRepository.findById(petsDTORequest.breedId())
                .orElseThrow(() -> new RuntimeException("not found breed : "+petsDTORequest.breedId()));

        Owner owner = ownerRepository.findById(petsDTORequest.ownerId())
                .orElseThrow(() -> new RuntimeException("not found owner : "+petsDTORequest.ownerId()));

        pets = petsRepository.save(pets);

        // Armar respuesta
        BreedDTOResponse breedDTO = breedMapper.toBreedDTOResponse(breed);
        OwnerDTOResponse ownerDTO = ownerMapper.toOwnerDTOResponse(owner);

        return petsMapper.toPetsDTOResponse(pets, ownerDTO, breedDTO);
    }

    @Override
    public PetsDTOResponse update(String id, PetsDTORequest petsDTORequest) {
        Pets petsexist = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found id pet: " + id));

        // Actualizar campos
        petsexist.setPetName(petsDTORequest.petName());
        petsexist.setPetType(petsDTORequest.petType());
        petsexist.setPetImage(petsDTORequest.petImage());
        petsexist.setBreedId(petsDTORequest.breedId());
        petsexist.setOwnerId(petsDTORequest.ownerId());
        petsexist.setBirthDate(petsDTORequest.birthDate());

        petsRepository.save(petsexist);

        // Obtener breed y owner actualizados
        Breed breed = breedRepository.findById(petsexist.getBreedId())
                .orElseThrow(() -> new RuntimeException("Breed not found: " + petsexist.getBreedId()));

        Owner owner = ownerRepository.findById(petsexist.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found: " + petsexist.getOwnerId()));

        BreedDTOResponse breedDTO = breedMapper.toBreedDTOResponse(breed);
        OwnerDTOResponse ownerDTO = ownerMapper.toOwnerDTOResponse(owner);

        return petsMapper.toPetsDTOResponse(petsexist, ownerDTO, breedDTO);
    }


    @Override
    public void delete(String id) {
        Pets petsexist = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id pet : "+id));
        log.warn("eliminando : " + id);
        petsRepository.delete(petsexist);
    }
}
