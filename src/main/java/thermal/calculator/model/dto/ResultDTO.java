package thermal.calculator.model.dto;

import lombok.Data;

@Data
public class ResultDTO {
	
    private double mainWallDissipation;
    private double openingsDissipation;
    private double totalDissipation;

    public ResultDTO(double mainWallDissipation, double openingsDissipation, double totalDissipation) {
        this.mainWallDissipation = mainWallDissipation;
        this.openingsDissipation = openingsDissipation;
        this.totalDissipation = totalDissipation;
    }
}