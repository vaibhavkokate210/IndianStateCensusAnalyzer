package com.bridgelabz.statecensus;

public class CSVStateCensus 
{
	public String state;
    public long population;
    public long areaInSqKm;
    public int DensityPerSqKm;

    public CSVStateCensus(String state, long population, long areaInSqKm, int densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.DensityPerSqKm = densityPerSqKm;
    }

    public CSVStateCensus() {
    }
}
