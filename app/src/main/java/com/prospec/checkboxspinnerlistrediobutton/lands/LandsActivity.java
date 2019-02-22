package com.prospec.checkboxspinnerlistrediobutton.lands;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.prospec.checkboxspinnerlistrediobutton.MainActivity;
import com.prospec.checkboxspinnerlistrediobutton.MySQLClient;
import com.prospec.checkboxspinnerlistrediobutton.R;
import com.prospec.checkboxspinnerlistrediobutton.Spacecraft;

public class LandsActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10, editT11;
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
    private Spinner spinnerEka, sp, spinnerP, imgTitle;
    private AutoCompleteTextView address;
    private TextView tv_name;
    private ImageView add_field_button;
    private CardView card1;
    private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lands);

//        get event
        getevrnt();

        ClickEvents();

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
        editT11 = (EditText) findViewById(R.id.editT11);
        add_field_button = (ImageView) findViewById(R.id.add_field_button);
        card1 = (CardView) findViewById(R.id.card1);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkbox5 = (CheckBox) findViewById(R.id.checkbox5);
        checkbox6 = (CheckBox) findViewById(R.id.checkbox6);
        spinnerEka = (Spinner) findViewById(R.id.spinnerEka);
        sp = (Spinner) findViewById(R.id.sp);
        spinnerP = (Spinner) findViewById(R.id.spinnerP);
        imgTitle = (Spinner) findViewById(R.id.imgTitle);
        tv_name = (TextView) findViewById(R.id.tv_name);
        btnAdd = (Button) findViewById(R.id.btnAdd);

    }// end get event

    //        จัดการเหตุการณ์
    private void ClickEvents() {
//        EVENTS : ADD
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                GET VALUES
//                กรอกข้อมูล
                String numbers = editT1.getText().toString().trim();
                String conversion = editT2.getText().toString().trim();
                String number = editT3.getText().toString().trim();
                String area = editT4.getText().toString().trim();
                String all = editT5.getText().toString().trim();
                String road = editT6.getText().toString().trim();
                String soi = editT7.getText().toString().trim();
                String project = editT8.getText().toString().trim();
                String name1 = editT9.getText().toString().trim();
                String address = editT10.getText().toString().trim();
                String telephone = editT11.getText().toString().trim();
//                spinner
                String document = spinnerEka.getSelectedItem().toString();
                String roads = sp.getSelectedItem().toString();
                String category = spinnerP.getSelectedItem().toString();
                String image = imgTitle.getSelectedItem().toString();
//                ติ๊ก checkbox
                Boolean straight = checkbox1.isChecked();
                Boolean names = checkbox2.isChecked();
                Boolean no1 = checkbox3.isChecked();
                Boolean person = checkbox4.isChecked();
                Boolean niti = checkbox5.isChecked();
                Boolean no2 = checkbox6.isChecked();


//                 การตรวจสอบด้านลูกค้าขั้นพื้นฐาน
//                EditText ความยาว <1 || Spinner ความยาว ก็ต้อง <1
//                || ความหมายคือ ถ้าทั้งสองค่าเป้นเท็จ ผลลัพธ์จะเป็นเท็จ
                if ((editT1.length() < 1 || propellant.length() < 1)) {

                    Toast.makeText(LandsActivity.this, "กรุณากรอกทุกช่อง", Toast.LENGTH_SHORT).show();
                } else {
//                    SAVE
                    GetSetLands s = new GetSetLands();
//                    EditText
                    s.setNumbers(numbers);
                    s.setConversion(conversion);
                    s.setNumber(number);
                    s.setArea(area);
                    s.setAll(all);
                    s.setRoad(road);
                    s.setSoi(soi);
                    s.setProject(project);
                    s.setName1(name1);
                    s.setAddress(address);
                    s.setTelephone(telephone);
//                    Spinner
                    s.setDocument(document);
                    s.setRoads(roads);
                    s.setCategory(category);
                    s.setImage(image);
//                    CheckBox
                    s.setStraigh(straight ? 1 : 0);// Checkbox t=1, f=0
                    s.setNames(names ? 1 : 0);
                    s.setNo1(no1 ? 1 : 0);
                    s.setPerson(person ? 1 : 0);
                    s.setNiti(niti ? 1 : 0);
                    s.setNo2(no2 ? 1 : 0);

                    new MySQLLands(LandsActivity.this).add(s, editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10, editT11,
                            checkbox1,  checkbox2,  checkbox3,  checkbox4,  checkbox5,  checkbox6);
                }
            }
        });
    }// end ClickEvents


    //    ส่วนของการทำ spinner
    private void populatePropellants() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

//        รายการที่แสดงใน spinner
        adapter.add("None");
        adapter.add("Chemical Energy");
        adapter.add("Nuclear Energy");
        adapter.add("Laser Beam");
        adapter.add("Anti-Matter");
        adapter.add("Plasma Ions");
        adapter.add("Warp Drive");

        spPropellant.setAdapter(adapter);
        spPropellant.setSelection(0);

    }// end spinner

    //    ส่วนของการทำ spinner
    private void populatePropellants() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

//        รายการที่แสดงใน spinner
        adapter.add("None");
        adapter.add("Chemical Energy");
        adapter.add("Nuclear Energy");
        adapter.add("Laser Beam");
        adapter.add("Anti-Matter");
        adapter.add("Plasma Ions");
        adapter.add("Warp Drive");

        spPropellant.setAdapter(adapter);
        spPropellant.setSelection(0);

    }// end spinner

    //    ส่วนของการทำ spinner
    private void populatePropellants() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

//        รายการที่แสดงใน spinner
        adapter.add("None");
        adapter.add("Chemical Energy");
        adapter.add("Nuclear Energy");
        adapter.add("Laser Beam");
        adapter.add("Anti-Matter");
        adapter.add("Plasma Ions");
        adapter.add("Warp Drive");

        spPropellant.setAdapter(adapter);
        spPropellant.setSelection(0);

    }// end spinner

    //    ส่วนของการทำ spinner
    private void populatePropellants() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

//        รายการที่แสดงใน spinner
        adapter.add("None");
        adapter.add("Chemical Energy");
        adapter.add("Nuclear Energy");
        adapter.add("Laser Beam");
        adapter.add("Anti-Matter");
        adapter.add("Plasma Ions");
        adapter.add("Warp Drive");

        spPropellant.setAdapter(adapter);
        spPropellant.setSelection(0);

    }// end spinner



}// Main Class
