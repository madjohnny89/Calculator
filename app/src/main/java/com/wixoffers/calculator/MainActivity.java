package com.wixoffers.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private enum OPERATOR {
        PLUS,MINUS,MULTIPLY,DIVIDE,EQUAL
    }
    TextView operationTextview;
    TextView resultTextView;

    private String currentNumber;
    private String numberOntop;
    private String numberRight;
    private String operation;
    private double calculationResult;
    private OPERATOR currentOperator;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentNumber = "";
        operation="";
        calculationResult = 0.0;

        operationTextview = findViewById(R.id.topText);
        resultTextView = findViewById(R.id.ResultText);
    }

    public void OnClick(View view) {
        switch (view.getId()){
            case R.id.buttonZero :
                numberIsTapped(0);
                break;
            case R.id.button1 :
                numberIsTapped(1);
                break;
            case R.id.button2 :
                numberIsTapped(2);
                break;
            case R.id.button3 :
                numberIsTapped(3);
                break;
            case R.id.button4 :
                numberIsTapped(4);
                break;
            case R.id.button5 :
                numberIsTapped(5);
                break;
            case R.id.button6 :
                numberIsTapped(6);
                break;
            case R.id.button7 :
                numberIsTapped(7);
                break;
            case R.id.button8 :
                numberIsTapped(8);
                break;
            case R.id.button9 :
                numberIsTapped(9);
                break;
            case R.id.buttonPlus :

                operatorIsTapped(OPERATOR.PLUS);
                break;
            case R.id.buttonMinus :
                operatorIsTapped(OPERATOR.MINUS);


                break;
            case R.id.buttonMultiplication :
                operatorIsTapped(OPERATOR.MULTIPLY);


                break;
            case R.id.buttonFloat :

                if (count==0 ) {


                    currentNumber = currentNumber + ".";
                    resultTextView.setText(currentNumber);
                    count++;
                }
                break;
            case R.id.buttonEqual :
                operatorIsTapped(OPERATOR.EQUAL);
                operation=numberOntop;
                operationTextview.setText(operation);

                break;
            case R.id.buttonCancel :
                cancelIsTapped();
                break;
            case R.id.divide :
                operatorIsTapped(OPERATOR.DIVIDE);


                break;
        }
    }
    private void numberIsTapped(int number){
        currentNumber=currentNumber+ String.valueOf(number);
        resultTextView.setText(currentNumber);
        operation=currentNumber;
        operationTextview.setText(operation);
    }
    private  void operatorIsTapped(OPERATOR operator){
        count=0;
        if (operator == OPERATOR.PLUS){
            operation=operation+ " + ";
            operationTextview.setText(operation);
        }
        else if (operator == OPERATOR.MINUS){
            operation=operation+ " - ";
            operationTextview.setText(operation);
        }
        else if (operator == OPERATOR.MULTIPLY){
            operation=operation+ " x ";
            operationTextview.setText(operation);
        }
        else if (operator == OPERATOR.DIVIDE){
            operation=operation+ " / ";
            operationTextview.setText(operation);
        }

        if (currentOperator !=null && currentNumber != "" ){
            numberRight =currentNumber;
            currentNumber="";
            switch (currentOperator){
                case PLUS:
                    calculationResult = Double.parseDouble(numberOntop) + Double.parseDouble(numberRight);
                    break;
                case MINUS:
                    calculationResult = Double.parseDouble(numberOntop) - Double.parseDouble(numberRight);
                    break;
                case DIVIDE:
                    calculationResult = Double.parseDouble(numberOntop) / Double.parseDouble(numberRight);
                    break;
                case MULTIPLY:
                    calculationResult = Double.parseDouble(numberOntop) * Double.parseDouble(numberRight);
                    break;




            }
            numberOntop = String.valueOf(calculationResult);
           resultTextView.setText(numberOntop);

        }
        else if (currentOperator== OPERATOR.EQUAL){
            Log.d("App","I'm sorry,Its a bad code");
        }
        else {
            numberOntop = currentNumber;
            currentNumber= "";

        }
        currentOperator = operator;

    }
    private void cancelIsTapped(){
        numberOntop="";
        numberRight="";
        currentOperator=null;
        currentNumber="";
        resultTextView.setText("0");
        operationTextview.setText("");
    }




}
