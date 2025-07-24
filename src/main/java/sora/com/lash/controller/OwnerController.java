package sora.com.lash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sora.com.lash.dto.owner.OwnerDTORequest;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/mongodb/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<OwnerDTOResponse>> listado(){
        List<OwnerDTOResponse> listado = ownerService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTOResponse> findById(@PathVariable String id) {
        OwnerDTOResponse ownerDTOResponse = ownerService.buscarId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ownerDTOResponse);
    }

    @PostMapping
    public ResponseEntity<OwnerDTOResponse> insert(@RequestBody OwnerDTORequest ownerDTORequest) {
        OwnerDTOResponse ownerDTOResponse = ownerService.save(ownerDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerDTOResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTOResponse> update(@PathVariable String id, @RequestBody OwnerDTORequest ownerDTORequest) {
        OwnerDTOResponse ownerDTOResponse = ownerService.update(id, ownerDTORequest);
        return ResponseEntity.status(HttpStatus.OK).body(ownerDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletee(@PathVariable String id) {
        ownerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
