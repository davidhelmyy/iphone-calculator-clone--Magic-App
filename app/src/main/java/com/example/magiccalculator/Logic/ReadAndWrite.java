package com.example.magiccalculator.Logic;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {


    public static void writeToFile(String data, Context context) {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
        }
        catch (IOException e) {
            Toast toast=Toast.makeText(context,"error writing file",Toast.LENGTH_SHORT);
            toast.show();

        }
    }



    public static String readFromFile(Context context) {


        String ret="";
        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);

                }


                ret=stringBuilder.toString();
                inputStream.close();

            }
        }
        catch (FileNotFoundException e) {

            Toast toast=Toast.makeText(context,"File not found",Toast.LENGTH_SHORT);
            toast.show();


        } catch (IOException e) {
            Toast toast=Toast.makeText(context,"Error reading file",Toast.LENGTH_SHORT);
            toast.show();
        }

        return ret;
    }
}
