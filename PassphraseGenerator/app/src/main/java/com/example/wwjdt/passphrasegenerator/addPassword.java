package com.example.wwjdt.passphrasegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class addPassword extends AppCompatActivity implements View.OnClickListener{
    private RadioButton caseSensitive, alphanumeric, specialCharacters;
    private Button saveBtn, exitBtn, generateBtn;
    private EditText passwordName, minChar, maxChar;
    private TextView passwordDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        //Radio Buttons
        caseSensitive = (RadioButton) findViewById(R.id.caseSensitive);
        alphanumeric = (RadioButton) findViewById(R.id.alphanumeric);
        specialCharacters = (RadioButton) findViewById(R.id.specialCharacters);
        //Buttons
        saveBtn = (Button) findViewById(R.id.saveBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        generateBtn = (Button) findViewById(R.id.generateBtn);
        //Edit Text Fields
        passwordName = (EditText) findViewById(R.id.passwordName);
        minChar = (EditText) findViewById(R.id.minChar);
        maxChar = (EditText) findViewById(R.id.maxChar);
        //Text Display
        passwordDisplay = (TextView) findViewById(R.id.passwordDisplay);
    }
}
