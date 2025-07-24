package sora.com.lash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sora.com.lash.dto.breed.BreedDTORequest;
import sora.com.lash.dto.breed.BreedDTOResponse;
import sora.com.lash.service.BreedService;

import java.util.List;

@RestController
@RequestMapping("/mongodb/breed")
@RequiredArgsConstructor
public class BreedController {

    private final BreedService breedService;

    @GetMapping
    public ResponseEntity<List<BreedDTOResponse>> listado(){
        List<BreedDTOResponse> listado = breedService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreedDTOResponse> findById(@PathVariable String id) {
        BreedDTOResponse breedDTOResponse = breedService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(breedDTOResponse);
    }

    @PostMapping
    public ResponseEntity<BreedDTOResponse> insert(@RequestBody BreedDTORequest breedDTORequest) {
        BreedDTOResponse breedDTOResponse = breedService.save(breedDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(breedDTOResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BreedDTOResponse> update(@PathVariable String id, @RequestBody BreedDTORequest breedDTORequest) {
        BreedDTOResponse breedDTOResponse = breedService.update(id, breedDTORequest);
        return ResponseEntity.status(HttpStatus.OK).body(breedDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletee(@PathVariable String id) {
        breedService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
