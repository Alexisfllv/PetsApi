package sora.com.lash.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sora.com.lash.dto.breed.BreedDTORequest;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.mapper.BreedMapper;
import sora.com.lash.model.Breed;
import sora.com.lash.repository.BreedRepository;
import sora.com.lash.service.BreedService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreedServiceImpl implements BreedService {

    private final BreedMapper breedMapper;
    private final BreedRepository breedRepository;

    //


    @Override
    public List<BreedDTOResponse> listarTodos() {
        List<Breed> breeds = breedRepository.findAll();
        return breeds.stream()
                .map(breed -> breedMapper.toBreedDTOResponse(breed))
                .toList();
    }

    @Override
    public BreedDTOResponse buscarId(String id) {
        Breed breed = breedRepository.findById(id).orElse(null);
        return breedMapper.toBreedDTOResponse(breed);
    }

    @Override
    public BreedDTOResponse save(BreedDTORequest breedDTORequest) {
        Breed breed = breedMapper.toBreed(breedDTORequest);
        breedRepository.save(breed);
        return breedMapper.toBreedDTOResponse(breed);
    }

    @Override
    public BreedDTOResponse update(String id, BreedDTORequest breedDTORequest) {
        Breed breed = breedRepository.findById(id).orElse(null);
        breed.setBreedName(breedDTORequest.breedName());
        breed.setBreedSpecies(breedDTORequest.breedSpecies());
        breedRepository.save(breed);
        return breedMapper.toBreedDTOResponse(breed);
    }

    @Override
    public void delete(String id) {
        Breed breed = breedRepository.findById(id).orElse(null);
        breedRepository.delete(breed);
    }
}
