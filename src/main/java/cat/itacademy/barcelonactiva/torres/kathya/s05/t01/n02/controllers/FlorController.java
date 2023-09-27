package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FlorController {
    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> addFlor(@RequestBody FlorDTO florDTO) {
        FlorDTO savedFlor = florService.saveFlor(florDTO);
        return new ResponseEntity<>(savedFlor, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FlorDTO> updateFlor(@PathVariable Long id, @RequestBody FlorDTO florDTO) {
        FlorDTO updatedFlor = florService.updateFlor(id,florDTO);
        return new ResponseEntity<>(updatedFlor, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Long id) {
        florService.deleteFlor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getOneFlor(@PathVariable Long id) {
        FlorDTO florDTO = florService.getFlorById(id);
        return new ResponseEntity<>(florDTO, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlores() {
        List<FlorDTO> flores = florService.getAllFlores();
        return new ResponseEntity<>(flores, HttpStatus.OK);
    }
}

