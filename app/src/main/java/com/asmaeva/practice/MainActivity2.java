package com.asmaeva.practice;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText v_et_show1;
    EditText v_et_price;

    EditText ex1;
    EditText ex2;
    EditText ex3;

    EditText ex4;
    EditText ex5;
    EditText ex7;
    EditText v_et_show;
    EditText v_et_show10;
    EditText v_et_show11;
    EditText v_et_show12;
    EditText v_et_show13;
    EditText ex8;
    EditText ex9;
    EditText ex10;

    EditText ex11;

    EditText ex12;

    EditText exdate;

    EditText extime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        v_et_show1 = findViewById(R.id.et_name_show1);
        String pickedItem = getIntent().getStringExtra("picked_item");
        v_et_show1.setText(pickedItem);

        v_et_price = findViewById(R.id.et_price_show2);
        int selectedPrice = getIntent().getIntExtra("selected_price", 0);
        v_et_price.setText(String.valueOf(selectedPrice));




//EditText
       // v_et_show = findViewById(R.id.et_name_show);

        //String value_names = getIntent().getExtras().getString("key_name5");

        //v_et_show.setText(value_names);


        v_et_show10 = findViewById(R.id.et10);

       String value_names10= getIntent().getExtras().getString("key_name10");

        v_et_show10.setText(value_names10);



        v_et_show11 = findViewById(R.id.et11);

        String value_names11 = getIntent().getExtras().getString("key_name11");

        v_et_show11.setText(value_names11);



        v_et_show12 = findViewById(R.id.etIf);

        String value_names12= getIntent().getExtras().getString("key_name12");

        v_et_show12.setText(value_names12);



        v_et_show13 = findViewById(R.id.etSeh);

        String value_names13 = getIntent().getExtras().getString("key_name13");

        v_et_show13.setText(value_names13);

//Switch
        ex1 = (EditText)findViewById(R.id.et1);
        ex2 = (EditText)findViewById(R.id.et2);

        String value1 = getIntent().getExtras().getString("toggButtondata1");
        ex1.setText(value1);


        String value2 = getIntent().getExtras().getString("toggButtondata2");
        ex2.setText(value2);


//RadioButton
        ex3=findViewById(R.id.et3);


        String value3 = getIntent().getExtras().getString("keyrdata");
        ex3.setText(value3);


//CheckBox
        ex4=findViewById(R.id.et_1);
        ex5=findViewById(R.id.et_2);
        ex7=findViewById(R.id.et_7);
        String value4 = getIntent().getExtras().getString("grade1");
        ex4.setText(value4);


        String value5 = getIntent().getExtras().getString("grade2");
        ex5.setText(value5);

        String value7 = getIntent().getExtras().getString("grade3");
        ex7.setText(value7);
//AutoComplete

        ex8=findViewById(R.id.et8);
        String value8 = getIntent().getExtras().getString("selectedText");
        ex8.setText(value8);

 //2ns spinner

        ex9=findViewById(R.id.et9);
        String value9 = getIntent().getExtras().getString("selected_surah");
        ex9.setText(value9);


        //MultiAutoComplete

        ex10=findViewById(R.id.et12);
        String value10= getIntent().getExtras().getString("selectedthesurah");
        ex10.setText(value10);

        //Rating
        ex11=findViewById(R.id.etRate);
        String value11= getIntent().getExtras().getString("RATING");
        ex11.setText(value11);

        //RatingTextViewInput
        ex12=findViewById(R.id.etHint);
        String value12= getIntent().getExtras().getString("RatingText");
        ex12.setText(value12);

        //date and time
        exdate = (EditText)findViewById(R.id.etdate);
        //extime = (EditText)findViewById(R.id.ettime);

        String valuedate = getIntent().getExtras().getString("date");
        exdate.setText(valuedate);

        extime = (EditText)findViewById(R.id.ettime);
       String valuetime = getIntent().getExtras().getString("time");
        extime.setText(valuetime);
    }
}