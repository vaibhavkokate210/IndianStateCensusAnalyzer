package com.bridgelabz.statecensus;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class IndianStateCode 
{
	ArrayList<CSVStates> scd = new ArrayList<>();
	CSVStates temp;

    public int checkStateData() throws CsvValidationException, IOException, CSVCustomException {
        IndianStateCode asc = new IndianStateCode();
        asc.loadingStateDataFromCSV();
        System.out.println(asc.scd.size());
        return (asc.scd.size());
    }
    public void loadingStateDataFromCSV() throws IOException, CsvValidationException, CSVCustomException {

        FileReader fr = new FileReader("C:\\Users\\Jeeva\\Desktop\\BridgeLabz-java\\IndianStateCensusAnalyzer\\Files\\StateCode.csv");
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReader csvReader = new CSVReaderBuilder(fr).withCSVParser(parser).build();
        String[] nextLine;

        nextLine = csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null) {

            Iterator<String> it = Arrays.stream(nextLine).iterator();
            String state = it.next();
            String population = it.next();
            String areaInSqKm = it.next();
            String DensityPerSqKm = it.next();
            try
            {
               temp = new CSVStates(Integer.parseInt(state), population, Integer.parseInt(areaInSqKm), DensityPerSqKm);
               scd.add(temp);
            }
            catch(Exception e)
            {
            	throw new CSVCustomException("Type incorrect");
            }
        }
        System.out.println();

    }
    public int fileExistsOrNot() throws CSVCustomException {
        File file = new File("C:\\Users\\Jeeva\\Desktop\\BridgeLabz-java\\IndianStateCensusAnalyzer\\Files\\StateCode.csv");
        if (file.exists()){
            return 1;
        }
        else {
            throw new CSVCustomException("File not found");
        }
    }
}
