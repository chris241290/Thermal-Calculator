package thermal.calculator.model.dto;

import lombok.Data;

@Data
public class BuildingDTO {

    private double[] coefficients;
    private double internalTemperature;
    private double externalTemperature;
    private double[] heights;
    private double[] widths;
    private double[] thicknesses;

    public BuildingDTO(double[] coefficients, double internalTemperature, double externalTemperature, double[] heights, double[] widths, double[] thicknesses) {
        this.coefficients = coefficients;
        this.internalTemperature = internalTemperature;
        this.externalTemperature = externalTemperature;
        this.heights = heights;
        this.widths = widths;
        this.thicknesses = thicknesses;
    }

}