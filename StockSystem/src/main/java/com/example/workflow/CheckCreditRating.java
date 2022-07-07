package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import javax.inject.Named;
import camundajar.impl.scala.util.Random;

@Named
public class CheckCreditRating implements JavaDelegate{

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // TODO Auto-generated method stub
        
        String creditRating = "0";
        boolean passCreditCheck = false;


        int credit = Integer.parseInt(creditRating);
        int baseline = 400;
        
        if (credit < baseline) {
            passCreditCheck = false;
        }
        else if (credit >= baseline) {
            passCreditCheck = true;
        }

        delegateExecution.setVariable("passCreditCheck", passCreditCheck);

    }

}
    

