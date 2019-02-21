package com.prospec.checkboxspinnerlistrediobutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private TextInputEditText txtName;
    private CheckBox chkTechnologyExists;
    private Spinner spPropellant;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "send email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//      get event
        this.initializeViews();

//        จัดการเหตุการณ์
        this.handleClickEvents();

        populatePropellants();

    }

//        get event
    private void initializeViews()
    {
        txtName= (TextInputEditText) findViewById(R.id.nameTxt);
        chkTechnologyExists= (CheckBox) findViewById(R.id.techExists);
        spPropellant= (Spinner) findViewById(R.id.sp);
        btnAdd= (Button) findViewById(R.id.addBtn);
    }// end initializeViews

//    คลิกจัดการเหตุการณ์
    private void handleClickEvents()
    {
//        EVENTS : ADD
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                GET VALUES
                String name=txtName.getText().toString();
                String propellant=spPropellant.getSelectedItem().toString();
                Boolean technologyexists=chkTechnologyExists.isChecked();

//              การตรวจสอบด้านลูกค้าขั้นพื้นฐาน
                if((name.length()<1 || propellant.length()<1  ))
                {
                    Toast.makeText(MainActivity.this, "กรุณากรอกทุกช่อง", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //SAVE

                    Spacecraft s=new Spacecraft();
                    s.setName(name);
                    s.setPropellant(propellant);
                    s.setTechnologyExists(technologyexists ? 1 : 0);

                    new MySQLClient(MainActivity.this).add(s,txtName,spPropellant);
                }
            }
        });



    }

    private void populatePropellants()
    {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter.add("None");
        adapter.add("Chemical Energy");
        adapter.add("Nuclear Energy");
        adapter.add("Laser Beam");
        adapter.add("Anti-Matter");
        adapter.add("Plasma Ions");
        adapter.add("Warp Drive");

        spPropellant.setAdapter(adapter);
        spPropellant.setSelection(0);

    }

}
