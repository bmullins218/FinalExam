package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;
import java.text.DecimalFormat;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {
	@FXML
		TextField txtIncome;
	@FXML
		TextField txtExpense;
	@FXML
		TextField txtCreditScore;
	@FXML
		TextField txtHouseCost;
	@FXML
		ComboBox<String> cbLoanTerm;
	@FXML
		Label lblPayment;
	@FXML
		Button btnMortgagePayment;
	@FXML
		Label lblError;
	@FXML
		public void initialize(){
			ObservableList<String> ComboBox = FXCollections.observableArrayList("15 Years","30 Years");
			cbLoanTerm.setItems(ComboBox);
	}
	public MainApp mainApp;
	public MainApp getMainApp() {
		return mainApp;
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;

		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		a.setLoanRequest(lq);
		
		double Income = Double.parseDouble(txtIncome.getText());
			lq.setIncome(Income);
		double Expenses = Double.parseDouble(txtExpense.getText());
			lq.setExpenses(Expenses);
		int creditScore = (int)Double.parseDouble(txtCreditScore.getText());
			lq.setiCreditScore(creditScore);
		double houseCosts = Double.parseDouble(txtHouseCost.getText());
			lq.setdAmount(houseCosts);
		int term = 0;
			if (cbLoanTerm.getValue()=="15 Years"){
				term = 15;
			}
			else{
				term = 30;
			}
		mainApp.messageSend(lq);
	}
	
	@FXML
	public void HandleLoanRequestDetails(LoanRequest lRequest) {
		
	}
}
