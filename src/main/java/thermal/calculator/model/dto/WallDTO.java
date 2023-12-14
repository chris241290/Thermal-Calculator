package thermal.calculator.model.dto;

import lombok.Data;

@Data
public class WallDTO {
	
    private double coefficient;
    private double totalSurfaceArea;
    private double thickness;
    private double openingsSurfaceArea;
    private double openingsThickness;
    private double openingsCoefficient;

    public WallDTO(double coefficient, double totalSurfaceArea, double thickness, double openingsSurfaceArea, double openingsThickness, double openingsCoefficient) {
        this.openingsSurfaceArea = openingsSurfaceArea;
        this.openingsThickness = openingsThickness;
        this.openingsCoefficient = openingsCoefficient;

        this.coefficient = coefficient;
        this.totalSurfaceArea = totalSurfaceArea;
        this.thickness = thickness;
    }

    public WallDTO(double coefficient, double totalSurfaceArea, double thickness) {
        this.openingsSurfaceArea = 0;
        this.openingsThickness = 1;
        this.openingsCoefficient = 0;

        this.coefficient = coefficient;
        this.totalSurfaceArea = totalSurfaceArea;
        this.thickness = thickness;
    }

    private double getEffectiveSurfaceArea() {
        return this.totalSurfaceArea - this.openingsSurfaceArea;
    }

    public double calculateHeatDissipation(int time, double deltaT) {
        // Heat dissipation through the main part of the wall
        double mainWallDissipation = (this.coefficient * deltaT * this.getEffectiveSurfaceArea() * time) / this.thickness;

        // Heat dissipation through openings (e.g., windows or doors)
        double openingsDissipation = (this.openingsCoefficient * deltaT * this.openingsSurfaceArea * time) / this.openingsThickness;

        // Total heat dissipation is the sum of dissipation through the main wall and openings
        return mainWallDissipation + openingsDissipation;
    }
    
}