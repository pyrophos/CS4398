package com.example.wwjdt.passphrasegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

/**
 * This will bring us back to the login screen when ever we click on the notification.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        startActivity(new Intent(this, Login.class));

    }

}
