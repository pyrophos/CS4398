package com.example.wwjdt.passphrasegenerator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.edmodo.rangebar.RangeBar;

import java.util.Random;

public class PasswordCreator extends AppCompatActivity implements View.OnClickListener{
    private CheckBox caseSensitive, alphanumeric, specialCharacters;
    private Button saveBtn, exitBtn, generateBtn, shuffleBtn;
    private EditText passwordName, minWords, maxWords;
    private TextView passwordDisplay, minChar, maxChar, numWordsText, numWordsDisplay;
    private WordModel wordModel = new WordModel();
    private Credential credential;
    private RangeBar minMaxCharBar;
    private SeekBar numWordsBar;
    private int minWordLength = 3, maxWordLength = 10, numWords = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_password);

        //load words from text file
        wordModel.loadWords(this);

        //CheckBoxes
        caseSensitive = (CheckBox) findViewById(R.id.caseSensitive);
        alphanumeric = (CheckBox) findViewById(R.id.alphanumeric);
        specialCharacters = (CheckBox) findViewById(R.id.specialCharacters);

        //Buttons
        saveBtn = (Button) findViewById(R.id.saveBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        generateBtn = (Button) findViewById(R.id.generateBtn);
        shuffleBtn = (Button) findViewById(R.id.shuffleBtn);

        //Edit Text Fields
        passwordName = (EditText) findViewById(R.id.passwordName);

        //Text Display
        passwordDisplay = (TextView) findViewById(R.id.passwordDisplay);
        minChar = (TextView) findViewById(R.id.minChar);
        maxChar = (TextView) findViewById(R.id.maxChar);
        numWordsText = (TextView) findViewById(R.id.numWordsText);
        numWordsDisplay = (TextView) findViewById(R.id.numWordsDisplay);

        //Range Bar
        minMaxCharBar = (RangeBar) findViewById(R.id.wordLengthBar);

        //Seek Bar
        numWordsBar = (SeekBar) findViewById(R.id.numWordsBar);

        //Set listeners for buttons
        generateBtn.setOnClickListener(this);
        shuffleBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);

        //Bar listeners
        minMaxCharBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onIndexChangeListener(RangeBar rangeBar, int leftThumbIndex, int rightThumbIndex) {
                minWordLength = leftThumbIndex + 3;
                maxWordLength = rightThumbIndex + 3;

                minChar.setText(String.valueOf(minWordLength));
                maxChar.setText(String.valueOf(maxWordLength));
            }
        });

        numWordsBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numWords = progress + 3;
                numWordsDisplay.setText(String.valueOf(numWords));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generateBtn: credential = generatePassword(); break;
            case R.id.shuffleBtn: shuffle(); break;
            case R.id.saveBtn: break;
            case R.id.exitBtn: break;
        }
    }

    public Credential generatePassword(){


        Credential credential = new Credential(numWords, maxWordLength, minWordLength, wordModel);

        for(int i = 0; i < numWords; i++){
            credential.addWord();
        }

        if(caseSensitive.isChecked()){
            credential.makeCaseSensitive();
        }

        if(alphanumeric.isChecked()){
            credential.appendNumber();
        }

        if(specialCharacters.isChecked()){
            credential.appendSpecialCharacter();
        }
        passwordDisplay.setText(credential.toString());

        return credential;
    }

    public Credential shuffle(){
        credential.shuffleCredential();
        passwordDisplay.setText(credential.toString());

        return credential;
    }
}


