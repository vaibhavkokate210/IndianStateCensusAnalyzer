package com.bridgelabz.statecensustest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.bridgelabz.statecensus.CSVCustomException;
import com.bridgelabz.statecensus.StateCensusAnalyzer;
import com.opencsv.exceptions.CsvValidationException;

public class IndianStateCensusTest 
{
	 @Test
	 public void checksState_NumberOfState() throws CsvValidationException, IOException, CSVCustomException 
	 {
		 StateCensusAnalyzer sca = new StateCensusAnalyzer();
		 int count=sca.checkState();
		 System.out.println(count);
		 assertEquals((long)29,(long)count);
	 }
	 
	 @Test
	 public void checkCensus_IsCorrect() throws CSVCustomException
	 {
		    StateCensusAnalyzer isc = new StateCensusAnalyzer();
	        assertTrue(isc.checkFileIfExists());
	 }
	 
	 @Test
	    public void checking_If_FileCorrect_ButTypeIncorrect(){
	        try {
	        	StateCensusAnalyzer isc = new StateCensusAnalyzer();
	            isc.loadingCSVData();
	            assertEquals(29,isc.checkState());
	        }
	        catch (Exception e){
	            e.getMessage();
	        }
	    }
	 
	 @Test
	    public void check_ForDelimiter(){
	        try {
	        	StateCensusAnalyzer isc = new StateCensusAnalyzer();
	            isc.loadingCSVData();
	            assertEquals(29,isc.checkState());
	        }
	        catch (Exception e)
	        {
	            e.getMessage();
	        }
	    }
}
