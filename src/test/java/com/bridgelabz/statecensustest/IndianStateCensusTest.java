package com.bridgelabz.statecensustest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.bridgelabz.statecensus.StateCensusAnalyzer;
import com.opencsv.exceptions.CsvValidationException;

public class IndianStateCensusTest 
{
	 @Test
	 public void checksState_NumberOfState() throws CsvValidationException, IOException 
	 {
		 StateCensusAnalyzer sca = new StateCensusAnalyzer();
		 int count=sca.checkState();
		 System.out.println(count);
		 assertEquals((long)29,(long)count);
	 }
}