package pkgCore;

import org.apache.poi.ss.formula.functions.*;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	

	/**
	 * No-arg constructor as per the assignment
	 */
	public Retirement() {
		
	}
	
	// Getters and Setters for each attribute.
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}
	//Converts a whole percentage number into a decimal
	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking * 0.01;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}
	//Converts a whole percentage number into a decimal
	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired * 0.01;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
	//-------------------- End of Getters and Setters



	/**
	 * 
	 * AmountToSave() - This method determines the amount of money to save per month for retirement.
	 * 
	 * @return double payment
	 */
	public double AmountToSave()
	{
		return FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, (-1) * TotalAmountSaved(), false);
	}
	
	/**
	 * 
	 * TotalAmountSaved() - This method determines the amount of money needed for retirement.
	 * 
	 * @return double retirement present-value
	 */
	public double TotalAmountSaved()
	{
		return FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, dRequiredIncome - dMonthlySSI, 0, false);
	}
}
