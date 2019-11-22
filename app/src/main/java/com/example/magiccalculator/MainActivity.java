package com.example.magiccalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.magiccalculator.Logic.Calculate;
import com.example.magiccalculator.Logic.InfoCollector;
import com.example.magiccalculator.Logic.ReadAndWrite;




public class MainActivity extends AppCompatActivity {



    private TextView result;
    private String temp;
    private String exp;
    private boolean zeroPressed;
    private boolean dotPressed;
    private boolean clicked;
    private Button btnAc;
    private int presses;
    private int inserterCounter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      String data= ReadAndWrite.readFromFile(this);
       if(data.matches(""))
           load();

       else
       {
           Calculate.setForceNumber(Double.valueOf(data));
       }

        btnAc=findViewById(R.id.button_ac);
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acPressed();
            }
        });



        result=findViewById(R.id.result);
        result.setText("0");


        exp=new String("");
        temp=new String("");

        clicked=true;
        zeroPressed=true;
        dotPressed=false;
        presses=0;
        inserterCounter=0;



    }








    private void load() {




        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);




        final EditText et = new EditText(this);
        final TextView view=new TextView(this);




        et.setPadding(5,5,5,5);
        et.setHint("Force number here");
        et.setGravity(Gravity.CENTER);
        et.setInputType(InputType.TYPE_CLASS_NUMBER );

        et.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(et);
        alertDialogBuilder.setTitle("Add Force Number");

        // set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Calculate.setForceNumber(Double.valueOf(et.getText().toString()));
                showDialogTwo();

            }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

    private void showDialogTwo() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        final EditText et = new EditText(this);
        final TextView view=new TextView(this);




        et.setPadding(5,5,5,5);
        et.setHint("presses number here");
        et.setGravity(Gravity.CENTER);
        et.setInputType(InputType.TYPE_CLASS_NUMBER );

        et.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(et);
        alertDialogBuilder.setTitle("Add presses Number");

        // set dialog message
        alertDialogBuilder.setCancelable(false).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Calculate.setPresses(Integer.valueOf(et.getText().toString()));
               ReadAndWrite.writeToFile(Calculate.getForceNumber(),getApplicationContext());




            }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }



    public void InsertData()
    {

        switch (inserterCounter)
        {
            case 0:
            {
                InfoCollector.setDay(result.getText().toString());
                break;
            }

            case 1:
            {
                InfoCollector.setMonth(result.getText().toString());
                break;
            }

            case 3:
            {
                InfoCollector.setPass(result.getText().toString());
                break;
            }



        }

        ++inserterCounter;


    }






    public void equalPressed(View view){


        if(!exp.matches("")){
            InsertData();
        ++presses;

        if(exp.charAt(exp.length()-1)=='.')
            exp+="0";

        result.setText(Calculate.CalculateExpression(exp,presses));
        zeroPressed=true;
        temp="";


        if(presses>=Calculate.getPresses())
            presses=0;

        }

    }





    public void acPressed()
    {

        result.setText("0");
        btnAc.setText("AC");
        exp="";
        temp="";
        clicked=true;
        zeroPressed=true;
        dotPressed=false;
        presses=0;
        inserterCounter=0;

    }

    public void plusMinusPresses(View view)
    {

        String tempCode=result.getText().toString();
        if(tempCode.matches("22"))
        {
            acPressed();
            Intent intent=new Intent(this,DataViewer.class);
            startActivity(intent);

        }
    }



    public void percentagePressed(View view)
    {
        String tempCode=result.getText().toString();
        if(tempCode.matches("555"))
        {
            acPressed();
            Intent intent=new Intent(this,MenuActivity.class);
            startActivity(intent);

        }

    }

    public void NumberClicked(View view)
    {
        clicked=false;
        btnAc.setText("C");


        if(view.getId()==R.id.button0)
        {
            if(!zeroPressed) {
                exp += "0";
                temp += "0";
              //  zeroPressed=true;

            }
        }

        zeroPressed=false;

         if(view.getId()==R.id.button1)
        {
            exp+="1";
            temp+="1";


        }

        else if(view.getId()==R.id.button2)
        {

            exp+="2";
            temp+="2";
          //  zeroPressed=false;

        }

        else if(view.getId()==R.id.button3)
        {

            exp+="3";
            temp+="3";
           // zeroPressed=false;
        }

        else if(view.getId()==R.id.button4)
        {

            exp+="4";
            temp+="4";
            //zeroPressed=false;

        }
        else if(view.getId()==R.id.button5)
        {

            exp+="5";
            temp+="5";
          // zeroPressed=false;
        }

        else if(view.getId()==R.id.button6)
        {

            exp+="6";
            temp+="6";
          //  zeroPressed=false;
        }


        else if(view.getId()==R.id.button7)
        {

            exp+="7";
            temp+="7";
          //  zeroPressed=false;

        }


        else if(view.getId()==R.id.button8)
        {

            exp+="8";
            temp+="8";
           // zeroPressed=false;
        }

        else if(view.getId()==R.id.button9)
        {

            exp+="9";
            temp+="9";
           // zeroPressed=false;

        }






            if(!temp.matches(""))
         result.setText(Calculate.decimalAdder(temp));



    }

    public void DotPressed(View view)
    {

        if(!dotPressed)
        {
            exp+=".";
            dotPressed=true;
            String tempDot=Calculate.decimalAdder(temp);
            tempDot+=".";
            result.setText(tempDot);
            clicked=true;
            temp+=".";



        }


    }



    public void operationClicked(View view)
    {

        if(!clicked){

            InsertData();

        if(view.getId()==R.id.button_plus)
        {

            exp+="+";
            temp="";
            zeroPressed=true;
            dotPressed=false;
            clicked=true;
        }

        else if(view.getId()==R.id.button_minus) {

            exp+="-";
            temp="";
            zeroPressed=true;
            dotPressed=false;
            clicked=true;

        }
        else if(view.getId()==R.id.button_mult)
        {
            exp+="*";
            temp="";
            zeroPressed=true;
            dotPressed=false;
            clicked=true;

        }

        else if(view.getId()==R.id.button_div)
        {
            exp+="/";
            temp="";
            zeroPressed=true;
            dotPressed=false;
            clicked=true;

        }

        }

    }






}
