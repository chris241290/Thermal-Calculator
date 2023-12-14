package thermal.calculator.service.in;

import thermal.calculator.model.dto.BuildingDTO;
import thermal.calculator.model.dto.ResultDTO;

public interface DissipationService {
	
    ResultDTO calculateDispersion(BuildingDTO building, int time);
    
}