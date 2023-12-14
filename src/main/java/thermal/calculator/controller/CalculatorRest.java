package thermal.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import thermal.calculator.model.dto.BuildingDTO;
import thermal.calculator.model.dto.ResultDTO;
import thermal.calculator.service.in.DissipationService;

@RestController
public class CalculatorRest {

    @Autowired
    DissipationService dissipationService;

    @GetMapping("/calculateDispersion")
    public ResponseEntity<ResultDTO> calculateDispersion(@RequestBody BuildingDTO buildingDTO) {
    	
        try {
            ResultDTO resultDTO = dissipationService.calculateDispersion(buildingDTO, 3600); // sono 3600 secondi;
            return ResponseEntity.ok(resultDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    
}