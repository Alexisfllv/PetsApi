package sora.com.lash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sora.com.lash.dto.pets.PetsDTORequest;
import sora.com.lash.dto.pets.PetsDTOResponse;
import sora.com.lash.service.PetsService;

import java.util.List;

@RestController
@RequestMapping("/mongodb/pets")
@RequiredArgsConstructor
public class PetsController {

    private final PetsService petsService;

    @GetMapping
    public ResponseEntity<List<PetsDTOResponse>> listado(){
        List<PetsDTOResponse> listado = petsService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetsDTOResponse> findById(@PathVariable String id) {
        PetsDTOResponse petsDTOResponse = petsService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(petsDTOResponse);
    }

    @PostMapping
    public ResponseEntity<PetsDTOResponse> insert(@RequestBody PetsDTORequest petsDTORequest) {
        PetsDTOResponse petsDTOResponse = petsService.save(petsDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(petsDTOResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetsDTOResponse> update(@PathVariable String id, @RequestBody PetsDTORequest petsDTORequest) {
        PetsDTOResponse petsDTOResponse = petsService.update(id, petsDTORequest);
        return ResponseEntity.status(HttpStatus.OK).body(petsDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletee(@PathVariable String id) {
        petsService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
