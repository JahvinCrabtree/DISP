package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import javax.inject.Named;
import camundajar.impl.scala.util.Random;

@Named
public class CheckStockSystem implements JavaDelegate{

    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;
    
        return randomNum;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // TODO Auto-generated method stub

        String drink = "Vodka and Coke";
        String drinkQuantity = "1";
        boolean ingredientsAvailable = null != null;

        drinkQuantity = (String) delegateExecution.getVariable("drinkQuantity");
        int drinkQuantityNum = Integer.parseInt(drinkQuantity);
        int stockQuantity = randInt(1,10);
        
        if (drinkQuantityNum > stockQuantity) {
            ingredientsAvailable = false;
        }
        else if (drinkQuantityNum <= stockQuantity) {
            ingredientsAvailable = true;
        }

        delegateExecution.setVariable("ingredientsAvailable", ingredientsAvailable);

    }
    
}
