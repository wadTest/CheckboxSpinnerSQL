package com.prospec.checkboxspinnerlistrediobutton.lands;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.prospec.checkboxspinnerlistrediobutton.R;

public class LandsActivity extends AppCompatActivity {

//    ประกาศตัวแปร
private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lands);

//        get event
        getevrnt();

    }//Method

//    get event
    private void getevrnt() {
        editT1 = (EditText) findViewById(R.id.editT1);
        editT2 = (EditText) findViewById(R.id.editT2);
        editT3 = (EditText) findViewById(R.id.editT3);
        editT4 = (EditText) findViewById(R.id.editT4);
        editT5 = (EditText) findViewById(R.id.editT5);
        editT6 = (EditText) findViewById(R.id.editT6);
        editT7 = (EditText) findViewById(R.id.editT7);
        editT8 = (EditText) findViewById(R.id.editT8);
        editT9 = (EditText) findViewById(R.id.editT9);
        editT10 = (EditText) findViewById(R.id.editT10);
    }// end get event

}//Main Class
