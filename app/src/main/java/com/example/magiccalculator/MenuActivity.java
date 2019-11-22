package com.example.magiccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.magiccalculator.Logic.Calculate;
import com.example.magiccalculator.Logic.ReadAndWrite;

public class MenuActivity extends AppCompatActivity {


    private EditText forceNumber;
    private EditText numberPress;

    private TextView pressView;
    private TextView forceView;

     private double forceNo;
     private int press;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        forceNumber=findViewById(R.id.menu_force);
        numberPress=findViewById(R.id.menu_press);
        forceView=findViewById(R.id.menu_forceNumber);
        pressView=findViewById(R.id.menu_pressesNUmber);


        forceView.setText("Force No.= " +Calculate.getForceNumber());
        pressView.setText("No. of presses= " +String.valueOf(Calculate.getPresses()));


        forceNo=0;
        press=0;

    }

    public void onSaveClicked(View view)
    {

        if(forceNumber.getText().toString().matches("")||numberPress.getText().toString().matches(""))
        {
            Toast toast= Toast.makeText(this,"Enter valid numbers",Toast.LENGTH_SHORT);
            toast.show();
        }

        else
        {
            forceNo=Double.valueOf(forceNumber.getText().toString());
            press=Integer.valueOf(numberPress.getText().toString());

            Calculate.setPresses(press);
            Calculate.setForceNumber(forceNo);
            ReadAndWrite.writeToFile(Calculate.getForceNumber(),this);

            Toast toast =Toast.makeText(this,"Added successfully",Toast.LENGTH_SHORT);
            toast.show();

            finish();

        }






    }




}
