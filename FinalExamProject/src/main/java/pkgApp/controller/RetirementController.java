package pkgApp.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblSaveTotal;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		//Clear all textviews and labels on right column when the clear button is pressed.
		System.out.println("Clear pressed");
		txtYearsToWork.setText("");
		txtAnnualReturn.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		lblSaveEachMonth.setText("");
		lblSaveTotal.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		//Creates a formatter to remove non-significant decimal places
		DecimalFormat format = new DecimalFormat("#0.00");
		
		boolean errorFlag = false;
		//Creates new instance of Retirement
		Retirement ret = new Retirement();
		//Set holder variables for ret setters
		//Verify years worked is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Integer.parseInt(txtYearsToWork.getText()) > 0) {
	    			int yearsToWork = Integer.parseInt(txtYearsToWork.getText());
	    			ret.setiYearsToWork(yearsToWork);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Years");
	            alert.setHeaderText("Invalid amount of years entered");
	            alert.setContentText("Please enter the amount of years to work.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Years");
            alert.setHeaderText("Invalid amount of years entered");
            alert.setContentText("Please enter the amount of years to work.");
            alert.showAndWait();
            errorFlag = true;
		}
		//Verify annual return is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Double.parseDouble(txtAnnualReturn.getText()) >= 0.0 && Double.parseDouble(txtAnnualReturn.getText()) <= 0.20) {
	    			double annualReturn = Double.parseDouble(txtAnnualReturn.getText());
	    			ret.setdAnnualReturnWorking(annualReturn);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Annual Return");
	            alert.setHeaderText("Invalid annual return entered");
	            alert.setContentText("Please enter a working annual return between 0 and 20 percent.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Annual Return");
            alert.setHeaderText("Invalid annual return entered");
            alert.setContentText("Please enter a working annual return between 0 and 20 percent.");
            alert.showAndWait();
            errorFlag = true;
		}
		//Verify years retired is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Integer.parseInt(txtYearsRetired.getText()) > 0) {
	    			int yearsRetired = Integer.parseInt(txtYearsRetired.getText());
				ret.setiYearsRetired(yearsRetired);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Years Retired");
	            alert.setHeaderText("Invalid amount of planned retired years entered");
	            alert.setContentText("Please enter the amount of years to retire.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Years Retired");
            alert.setHeaderText("Invalid amount of planned retired years entered");
            alert.setContentText("Please enter the amount of years to retire.");
            alert.showAndWait();
            errorFlag = true;
		}
		//Verify annual return retired is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Double.parseDouble(txtAnnualReturnRetired.getText()) >= 0.0 && Double.parseDouble(txtAnnualReturnRetired.getText()) <= 0.03) {
	    			double annualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
	    			ret.setdAnnualReturnRetired(annualReturnRetired);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Annual Return Retired");
	            alert.setHeaderText("Invalid annual return for retirement entered");
	            alert.setContentText("Please enter a retired annual return between 0 and 3 percent.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Annual Return Retired");
            alert.setHeaderText("Invalid annual return for retirement entered");
            alert.setContentText("Please enter a retired annual return between 0 and 3 percent.");
            alert.showAndWait();
            errorFlag = true;
		}
		//Verify set required income is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Double.parseDouble(txtRequiredIncome.getText()) > 0.0 ) {
	    			double requiredIncome = Double.parseDouble(txtRequiredIncome.getText());
	    			ret.setdRequiredIncome(requiredIncome);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Required Income Entered");
	            alert.setHeaderText("Invalid required retirement income entered");
	            alert.setContentText("Please enter a monthly retirement income greater than 0.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Required Income Entered");
            alert.setHeaderText("Invalid required retirement income entered");
            alert.setContentText("Please enter a monthly retirement income greater than 0.");
            alert.showAndWait();
            errorFlag = true;
		}
		//Verify monthly SSI check is a valid number. If it is, plug it in the equation. Else, pop-up warning.
		try {
	        if (Double.parseDouble(txtMonthlySSI.getText()) >= 0.0 ) {
	    			double monthlySSI = Double.parseDouble(txtMonthlySSI.getText());
	    			ret.setdMonthlySSI(monthlySSI);
	        } else {

	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Invalid Monthly SSI Entered");
	            alert.setHeaderText("Invalid Monthly SSI amount entered");
	            alert.setContentText("Please enter a number for monthly Social Secuirity Income.");
	            alert.showAndWait();
	            errorFlag = true;
	        }
		} catch (Exception e) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Monthly SSI Entered");
            alert.setHeaderText("Invalid Monthly SSI amount entered");
            alert.setContentText("Please enter a number for monthly Social Secuirity Income.");
            alert.showAndWait();
            errorFlag = true;
		}
        // if no error flag from inputs, calculate total amount to save and monthly amount to save. Print the 
		//		results on the labels in the application.
		if (!errorFlag) {
			
			lblSaveTotal.setText(String.valueOf(format.format((-1) * ret.TotalAmountSaved())));
			lblSaveEachMonth.setText(String.valueOf(format.format((-1) * ret.AmountToSave())));
		}
		errorFlag = false;
		
		
	}
	
}
