package thermal.calculator.service.impl;

import org.springframework.stereotype.Service;
import thermal.calculator.model.dto.BuildingDTO;
import thermal.calculator.model.dto.ResultDTO;
import thermal.calculator.model.dto.WallDTO;
import thermal.calculator.service.in.DissipationService;

@Service
public class DissipationServiceImpl implements DissipationService {

	@Override
	public ResultDTO calculateDispersion(BuildingDTO building, int time) {

		double mainWallDissipation = 0.0;
		double openingsDissipation = 0.0;
		double totalDissipation = 0.0;

		try{
			for (int i = 0; i < building.getCoefficients().length; i++) {
				WallDTO wallDTO = new WallDTO(building.getCoefficients()[i], building.getHeights()[i] * building.getWidths()[i], building.getThicknesses()[i]);
				double wallDissipation = wallDTO.calculateHeatDissipation(time, building.getInternalTemperature() - building.getExternalTemperature());

				if (i < 4) {
					mainWallDissipation += wallDissipation;
				} else {
					openingsDissipation += wallDissipation;
				}

				totalDissipation += wallDissipation;
			}

		}catch(Exception e){

			e.printStackTrace();

		}

		return new ResultDTO(mainWallDissipation, openingsDissipation, totalDissipation);
	}

}