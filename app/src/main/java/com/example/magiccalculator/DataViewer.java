package com.example.magiccalculator;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.magiccalculator.Logic.InfoCollector;

public class DataViewer extends AppCompatActivity {


    private TextView day;
    private TextView horoscope;
    private TextView pass;
    private ListView listLeft;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_viewer);


        day=findViewById(R.id.data_day_month);
        horoscope=findViewById(R.id.data_horoscope);
        pass=findViewById(R.id.data_pass);


        Load();

    }

    private void Load() {

        day.setText(InfoCollector.getDay()+"/"+ InfoCollector.getMonth());
        horoscope.setText(InfoCollector.getHorscope());
        pass.setText(InfoCollector.getPass());



    }

    public void OkPressed(View view)
    {
        InfoCollector.clearAll();
        finish();
    }








}
