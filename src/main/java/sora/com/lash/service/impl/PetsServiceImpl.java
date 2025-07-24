package sora.com.lash.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.mapper.PetsMapper;
import sora.com.lash.model.Pets;
import sora.com.lash.repository.PetsRepository;
import sora.com.lash.service.PetsService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PetsServiceImpl implements PetsService {

    private final PetsRepository petsRepository;
    private final PetsMapper petsMapper;

    @Autowired
    public PetsServiceImpl(PetsRepository petsRepository, PetsMapper petsMapper) {
        this.petsRepository = petsRepository;
        this.petsMapper = petsMapper;
    }


    @Override
    public List<PetsDTOResponse> listarTodos() {
        List<Pets> petsList = petsRepository.findAll();

        return petsList.stream()
                .map(pets -> petsMapper.toPetsDTOResponse(pets))
                .collect(Collectors.toList());
    }

    @Override
    public PetsDTOResponse buscarId(String id) {
        Pets pets = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id pet : "+id));
        return petsMapper.toPetsDTOResponse(pets);
    }

    @Override
    public PetsDTOResponse save(PetsDTORequest petsDTORequest) {
        Pets pets = petsMapper.toPets(petsDTORequest);
        pets = petsRepository.save(pets);
        return petsMapper.toPetsDTOResponse(pets);
    }

    @Override
    public PetsDTOResponse update(String id, PetsDTORequest petsDTORequest) {
        Pets petsexist = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id pet : "+id));

        petsexist.setPetName(petsDTORequest.petName());
        petsexist.setPetType(petsDTORequest.petType());
        petsexist.setPetImage(petsDTORequest.petImage());
        petsRepository.save(petsexist);
        return petsMapper.toPetsDTOResponse(petsexist);
    }

    @Override
    public void delete(String id) {
        Pets petsexist = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found id pet : "+id));
        log.warn("eliminando : " + id);
        petsRepository.delete(petsexist);
    }
}
