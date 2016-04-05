package com.example.wwjdt.passphrasegenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wwjdt.utils.Constants;

public class addRegister extends AppCompatActivity implements View.OnClickListener {
    private Button registerButton, backButton;
    private EditText editUsername, editPassword, textView;
    private static final String MyPREFERENCES= "MyPrefs";
    static Context context;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_register);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        backButton = (Button) findViewById(R.id.backButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        backButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
      pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
      addRegister.context = getApplicationContext();

    }

  public static Context getAppContext() {
    return addRegister.context;
  }

  @Override
  public void onClick(View v) {

      switch (v.getId()) {

          case R.id.backButton:
              startActivity(new Intent(this, Login.class));
              break;
          case R.id.registerButton:
              String usernameText = editUsername.getText().toString().trim();
              String passwordText = editPassword.getText().toString().trim();

              if (usernameText.length() == 0) {
                  editUsername.setError("Enter username");

              } else if (passwordText.length() == 0) {
                  editPassword.setError("Enter password");
              } else {

                  SharedPreferences.Editor edit = pref.edit();
                  edit.putString(Constants.KEY_UNM, usernameText);
                  edit.putString(Constants.KEY_PWD, passwordText);
                  edit.commit();
                  finish();
                  Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();

              }
              break;

      }

  }

}

