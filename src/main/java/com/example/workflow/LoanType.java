package com.example.workflow;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class LoanType implements JavaDelegate{

	@Override
	public void execute(DelegateExecution delegateExecution) throws Exception {
		String uds = "0";
		String loanType = "akiba loan";
		
		uds = (String) delegateExecution.getVariable("uds");
		double udsDouble = Double.parseDouble(uds);
		
		if(udsDouble >= 20000) {
			loanType = "development Loan";
		}else if(udsDouble >=10000 ) {
			loanType="educational Loan";
		}else if(udsDouble >= 5000 ) {
			loanType ="akiba loan";
		}
		delegateExecution.setVariable("loanType", loanType);
	}
	

}
