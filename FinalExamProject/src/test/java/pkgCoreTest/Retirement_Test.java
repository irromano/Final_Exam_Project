package pkgCoreTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class Retirement_Test {

	//This test compares the return values of TotalAmountSaved() and AmountToSave() to pre-calculated values
	@Test
	public void RetirementCoreMethods_Test1() {
		double dExpectedPV = 1454485.55;
		double dExpectedtoSave = 554.13;
		
		Retirement ret = new Retirement();
		ret.setiYearsToWork(40);
		ret.setdAnnualReturnWorking(0.07);
		ret.setiYearsRetired(20);
		ret.setdAnnualReturnRetired(0.02);
		ret.setdRequiredIncome(-10000);
		ret.setdMonthlySSI(-2642);
		
		assertEquals(dExpectedPV, ret.TotalAmountSaved(), 0.01);
		assertEquals(dExpectedtoSave, ret.AmountToSave(), 0.01);
	}

}
