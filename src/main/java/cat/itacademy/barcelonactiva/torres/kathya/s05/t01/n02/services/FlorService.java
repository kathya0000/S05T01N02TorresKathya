package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.services;


import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.models.FlorModel;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.repositories.IFlorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorService {

    @Autowired
    private IFlorRepository florRepository;

    public FlorDTO saveFlor(FlorDTO florDTO){
        florDTO.determinarTipoFlor();
        FlorModel florModel = convertToEntity(florDTO);
        FlorModel savedFlor = florRepository.save(florModel);
        return convertToDTO(savedFlor);


    }

    public List<FlorDTO> getAllFlores(){
        List<FlorModel> florModels = florRepository.findAll();
        return florModels.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public FlorDTO getFlorById(Long id) {
        FlorModel florModel = florRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Flor not found"));
        return convertToDTO(florModel);
    }
    public void deleteFlor(Long id) {

        florRepository.deleteById(id);
    }
    public FlorDTO updateFlor(Long id, FlorDTO florDTO) {
        FlorModel florModelToUpdate = florRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Flor not found"));
        florModelToUpdate.setNameFlor(florDTO.getNameFlor());
        florModelToUpdate.setPaisFlor(florDTO.getPaisFlor());
        florDTO.determinarTipoFlor();
        florModelToUpdate.setTipoFlor(florDTO.getTipoFlor());
        FlorModel updateFlor= florRepository.save(florModelToUpdate);
        return convertToDTO(updateFlor);
    }


    private FlorDTO convertToDTO(FlorModel savedFlor) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setPk_FlorID(savedFlor.getPk_FlorID());
        florDTO.setNameFlor(savedFlor.getNameFlor());
        florDTO.setPaisFlor(savedFlor.getPaisFlor());
        florDTO.setTipoFlor(savedFlor.getTipoFlor());
        return florDTO;
    }

    private FlorModel convertToEntity(FlorDTO florDTO) {
        FlorModel florModel = new FlorModel();
        florModel.setPk_FlorID(florDTO.getPk_FlorID());
        florModel.setNameFlor(florDTO.getNameFlor());
        florModel.setPaisFlor(florDTO.getPaisFlor());
        florModel.setTipoFlor(florDTO.getTipoFlor());
        return florModel;
    }
}

