package sora.com.lash.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sora.com.lash.dto.owner.OwnerDTORequest;
import sora.com.lash.dto.owner.OwnerDTOResponse;
import sora.com.lash.mapper.OwnerMapper;
import sora.com.lash.model.Owner;
import sora.com.lash.repository.OwnerRepository;
import sora.com.lash.service.OwnerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerMapper ownerMapper;
    private final OwnerRepository ownerRepository;

    //


    @Override
    public List<OwnerDTOResponse> listarTodos() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream()
                .map(owner -> ownerMapper.toOwnerDTOResponse(owner))
                .toList();
    }

    @Override
    public OwnerDTOResponse buscarId(String id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        return ownerMapper.toOwnerDTOResponse(owner);
    }

    @Override
    public OwnerDTOResponse save(OwnerDTORequest ownerDTORequest) {
        Owner owner = ownerMapper.toOwner(ownerDTORequest);
        ownerRepository.save(owner);
        return ownerMapper.toOwnerDTOResponse(owner);
    }

    @Override
    public OwnerDTOResponse update(String id, OwnerDTORequest ownerDTORequest) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        owner.setOwnerName(ownerDTORequest.ownerName());
        owner.setOwnerPhone(ownerDTORequest.ownerPhone());
        ownerRepository.save(owner);
        return ownerMapper.toOwnerDTOResponse(owner);
    }

    @Override
    public void delete(String id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        ownerRepository.delete(owner);
    }

}
