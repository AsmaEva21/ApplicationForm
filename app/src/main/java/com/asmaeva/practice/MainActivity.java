package com.asmaeva.practice;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Switch simpleSwitch1;
    Switch simpleswitch2;
    Button submit;

    RadioGroup radioSimGroup;
    RadioButton radioSimButton;

    CheckBox ch1, ch2, ch3;
    EditText v_et_name;
    EditText v_et_name10;
    EditText v_et_name11;
    EditText v_et_name12;
    EditText v_et_name13;
    //Double [] proprice ={ 1000.0,280.0,100.0,1050.0,250.0,370.0,900.0};
    // Integer [] proprice ={ 4,12,8,7,12,15,20,12,2};
    ArrayAdapter<Integer> adapater_sp;
    // Spinner sp;
    Integer[] proqnty = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    ArrayAdapter<Integer> adapater_sp2;


    //Character [] stucharcter ={'A','B','C','D','E','F','G','H','I'};
    // ListView b_lv;
    //ArrayAdapter<String> adapter;
    Spinner sp;
    Button btnShowOutput;

    //String[] ctgtana;
    Integer[] proprice = {4, 12, 8, 7, 12, 15, 20, 4, 12}; // Example prices for Spinner

    String selectedListItem;
    Integer selectedPrice;

    String selectedSurah;
    ListView b_lv;
    ListView b_lv2;
    ListView b_lv3;
    ArrayAdapter<String> adapter;

    ArrayAdapter<String> adapter_name;
    String[] ctgtana;
    SearchView search1;

    TextView tx_1;
    TextView tx_2;
    TextView tx_3;

    TextView tx_4;
    Button sb;
    AutoCompleteTextView act;
    MultiAutoCompleteTextView acts;
    String[] stuname = {"Sun, Feb 25, 2024", " Wed, Feb 07, 2024", "Sat, Apr 06, 2024", "Mon, Sep 16, 2024"};
    ArrayAdapter<String> adapter_sp1;
    Spinner sp2;
    EditText edit;
    TextToSpeech textToSpeech;
    TextView textView;
    Button speakButton, stopButton;
    SeekBar seekBar;
    TextInputEditText textInputEditText;
    EditText date_in;
    EditText time_in;
    EditText edt;
    EditText edtime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    int hour, minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//date and time
        edt = findViewById(R.id.edt);
        edtime = findViewById(R.id.time_input);
        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edt.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }

        });

        edtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog= new TimePickerDialog(MainActivity.this, new  TimePickerDialog.OnTimeSetListener()  {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        edtime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }

        });
        //RatingTextInputEditText

        textInputEditText = findViewById(R.id.textInputEditText);

        //RatingBar
        //ee = findViewById(R.id.et);

        RatingBar ratingBar = findViewById(R.id.ratingBar);

        //MultiAutoComplete
        acts = findViewById(R.id.multiAutoCompleteTextView);


        String[] surah = getResources().getStringArray(R.array.surah_array);

        ArrayAdapter<String> adapters1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, surah);
        acts.setAdapter(adapters1);

        acts.setThreshold(1);
        acts.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//AutoComplete
        act = findViewById(R.id.autoCompleteTextView);


        String[] countries = getResources().getStringArray(R.array.countries_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, countries);
        act.setAdapter(adapter);
//2nd Spinner

        sp2 = findViewById(R.id.spinner2);

        adapter_sp1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stuname);
        sp2.setAdapter(adapter_sp1);


// 2nd Spinner
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedSurah = stuname[position];


                Toast.makeText(getApplicationContext(), selectedSurah, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b_lv = findViewById(R.id.iv_one);
        sp = findViewById(R.id.spinner);

        Resources res = getResources();
        ctgtana = res.getStringArray(R.array.productname);
        adapter_name = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, ctgtana);
        b_lv.setAdapter(adapter_name);
        ArrayAdapter<Integer> adapter_sp = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, proprice);
        sp.setAdapter(adapter_sp);




        //search
        search1 = findViewById(R.id.searchView);
        search1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter_name.getFilter().filter(newText);
                return false;
            }
        });

        // ListView item click listener
        b_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String pick = ctgtana[position];


                Toast.makeText(getApplicationContext(), pick + " - Position: " + position, Toast.LENGTH_SHORT).show();


                selectedListItem = pick;
            }
        });


        // Spinner item selection listener
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedPrice = proprice[position];


                String PP = String.valueOf(selectedPrice);


                Toast.makeText(getApplicationContext(), PP, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        // v_et_name = findViewById(R.id.et_name);
        v_et_name10 = findViewById(R.id.edit10);
        v_et_name11 = findViewById(R.id.edit11);
        v_et_name12 = findViewById(R.id.edIf);
        v_et_name13 = findViewById(R.id.edSeh);

        simpleSwitch1 = (Switch) findViewById(R.id.switch1);
        simpleswitch2 = (Switch) findViewById(R.id.switch2);
        radioSimGroup = (RadioGroup) findViewById(R.id.radiosim);
        submit = (Button) findViewById(R.id.submitButton);




        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String statusSwitch1, statusSwitch2;
                CheckBox ch1 = findViewById(R.id.checkBox);
                CheckBox ch2 = findViewById(R.id.checkBox2);
                CheckBox ch3 = findViewById(R.id.checkBox3);
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);


//EditText1
                //String value = v_et_name.getText().toString().trim();
                //intent.putExtra("key_name5", value);

                String value10 = v_et_name10.getText().toString().trim();
                intent.putExtra("key_name10", value10);
//EditText2
                String value11 = v_et_name11.getText().toString().trim();
                intent.putExtra("key_name11", value11);
//EditText3

                String valueIf = v_et_name12.getText().toString().trim();
                intent.putExtra("key_name12", valueIf);
//EditText4
                String valueSeh = v_et_name13.getText().toString().trim();
                intent.putExtra("key_name13", valueSeh);

                //Switch
                if (simpleSwitch1.isChecked())
                    statusSwitch1 = simpleSwitch1.getTextOn().toString();
                else
                    statusSwitch1 = simpleSwitch1.getTextOff().toString();

                if (simpleswitch2.isChecked())
                    statusSwitch2 = simpleswitch2.getTextOn().toString();
                else
                    statusSwitch2 = simpleswitch2.getTextOff().toString();

                intent.putExtra("toggButtondata1", statusSwitch1);
                intent.putExtra("toggButtondata2", statusSwitch2);
//RadioButton
                int selectedId = radioSimGroup.getCheckedRadioButtonId();
                radioSimButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(getApplicationContext(), radioSimButton.getText(), Toast.LENGTH_SHORT).show();
                String rbdata = radioSimButton.getText().toString().trim();
                intent.putExtra("keyrdata", rbdata);
//CheckBox
                if (ch1.isChecked()) {
                    String result = "It is SHAB E QADAR";
                    intent.putExtra("grade1", result);
                }
                if (ch2.isChecked()) {
                    String result2 = "It is not SHAB E QADAR";
                    intent.putExtra("grade2", result2);
                }
                if (ch3.isChecked()) {
                    String result3 = "It is SHAB E QADAR";
                    intent.putExtra("grade3", result3);
                }
                //AutoComplete
                String text =act.getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                //Intent text = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("selectedText", text);

                //MultiAutoComplete
                String surah =acts.getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

                intent.putExtra("selectedthesurah",surah);
//RatingTextInputEditText

                TextInputEditText editText = findViewById(R.id.textInputEditText);

                String ratingText = editText.getText().toString();
                intent.putExtra("RatingText", ratingText);
//date and time
                String dateText = edt.getText().toString();


                intent.putExtra("date", dateText);

                String timeText = edtime.getText().toString();


                intent.putExtra("time", timeText);




//Rating
                RatingBar ratingBar = findViewById(R.id.ratingBar);
                String msg = String.valueOf(ratingBar.getRating());
                intent.putExtra("RATING", msg);

//Listview
              /*  String valuess = tx_1.getText().toString().trim();
                intent.putExtra("key_name",valuess);


//Price
                String valuer = tx_2.getText().toString();
                Integer pp =Integer.valueOf(valuer);
                String value2 =String.valueOf(pp);
                intent.putExtra("key_name1",value2);

                startActivity(intent);
            }

        });*/

                //2nd spinner
                intent.putExtra("selected_surah", selectedSurah);

//Listview and price
                intent.putExtra("picked_item", selectedListItem);
                intent.putExtra("selected_price", selectedPrice);
                startActivity(intent);
            }

        });

//texttospeech

        textView = findViewById(R.id.textView4);
        speakButton = findViewById(R.id.button);
        stopButton = findViewById(R.id.stopbutton);
        seekBar = findViewById(R.id.seekBar);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.UK);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(MainActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = textView.getText().toString();
                if (toSpeak.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nothing to speak", Toast.LENGTH_SHORT).show();
                    return;
                }

                float speed = (float) seekBar.getProgress() / 50;
                if (speed < 0.5) speed = 0.5f;

                textToSpeech.setSpeechRate(speed);
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textToSpeech != null && textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                } else {
                    Toast.makeText(MainActivity.this, "Not speaking", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }



    }





