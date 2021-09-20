package com.bridgelabz.statecensus;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyzer 
{
	 ArrayList<CSVStateCensus> csc = new ArrayList<>();
	 CSVStateCensus temp;

	public void loadingCSVData() throws IOException, CsvValidationException, CSVCustomException
	{
        FileReader fr = new FileReader("C:\\Users\\Jeeva\\Desktop\\BridgeLabz-java\\IndianStateCensusAnalyzer\\Files\\IndiaStateCensusData.csv");
        CSVReader csvReader = new CSVReader(fr);
        String[] nextLine;

        nextLine = csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null) 
        {
            Iterator<String> it = Arrays.stream(nextLine).iterator();
            String state = it.next();
            String population = it.next();
            String areaInSqKm = it.next();
            String DensityPerSqKm = it.next();
            try
            {
            temp = new CSVStateCensus(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(DensityPerSqKm));
            csc.add(temp);
            }
            catch(Exception e)
            {
            	throw new CSVCustomException("Incorrect type");
            }
        }
        System.out.println();
    }
	
	
	    public int checkState() throws CsvValidationException, IOException, CSVCustomException 
	    {
	    	    StateCensusAnalyzer sca = new StateCensusAnalyzer();
	            sca.loadingCSVData();
	            return (sca.csc.size());
	    }
	    
	    public boolean checkFileIfExists() throws CSVCustomException
	    {
	        File file = new File("C:\\Users\\Jeeva\\Desktop\\BridgeLabz-java\\IndianStateCensusAnalyzer\\Files\\IndiaStateCensusData.csv");
	        if (file.exists()){
	                return true;
	        }
	        else
	        {
	        	throw new CSVCustomException("CSV file not found");
	        }
	    }
}
