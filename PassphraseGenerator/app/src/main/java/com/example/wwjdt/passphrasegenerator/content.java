package com.example.wwjdt.passphrasegenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class content extends AppCompatActivity {

    ListView accountList;
    EditText accountNameTxt;
    Button addButton, deleteButton, editAndViewButton, logoutButton;
    ArrayList<String> accountnames = new ArrayList<String>();
    ArrayList<String> accountPass = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public String MyPREFERENCES;
    SharedPreferences pref;
    SharedPreferences.Editor spEditor;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        MyPREFERENCES = intent.getStringExtra("user");

        pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        accountList = (ListView) findViewById(R.id.ListView1);
        accountNameTxt = (EditText) findViewById(R.id.accountNameTxt);
        addButton = (Button) findViewById(R.id.addButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        editAndViewButton = (Button) findViewById(R.id.editAndViewButton);
        logoutButton = (Button) findViewById(R.id.logoutButton);


        spEditor = pref.edit();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, accountnames);

        String ActName;
        String ActPass;
        for (int i = 0; i <= pref.getAll().size(); i++) {

            ActName = pref.getString("AcctName[" + i + "]", "empty");
            ActPass = pref.getString("AcctPass[" + i + "]", "empty");
            if (ActName != "empty" && ActPass != "empty")
                accountnames.add(ActName + " \n" + ActPass);
        }

        //DEBUGGING
        Map<String, ?> entries = pref.getAll();
        Set<String> keys = entries.keySet();
        for (String key : keys) {
            Log.i(String.format("Shared Preference : %s - %s", MyPREFERENCES, key),
                    pref.getString(key, "error!"));
        }
        accountList.setAdapter(adapter);

        accountNameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        adapter.notifyDataSetChanged();


        accountList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                //accountNameTxt.setText(accountnames.get(position));
            }

        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(content.this, PasswordCreator.class);
                intent.putExtra("user", MyPREFERENCES);
                startActivity(intent);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                Intent intent = new Intent(content.this, content.class);
                intent.putExtra("user", MyPREFERENCES);
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(content.this, Login.class);
                startActivity(intent);
            }
        });
        editAndViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(content.this, PasswordCreator.class);
                intent.putExtra("user", MyPREFERENCES);
                startActivity(intent);
            }
        });
    }


    private void delete() {
        int pos = accountList.getCheckedItemPosition();
        if (pos > -1) {
            adapter.remove(accountnames.get(pos));

            pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            spEditor = pref.edit();


            for (int i = pos; i < pref.getAll().size() - 1; i++) {

                int prefCount = (pref.getAll().size() - 1)/2;


                String newActName = pref.getString("AcctName[" + (i + 1) + "]", "");
                Log.i("acctName", String.format("%s", newActName));
                String PassActName = pref.getString("AcctPass[" + (i + 1) + "]", "");
                if (newActName != "" && PassActName != "") {
                    spEditor.remove("AcctName[" + (i + 1) + "]");
                    spEditor.remove("AcctPass[" + (i + 1) + "]");
                    spEditor.putString("AcctName[" + i + "]", newActName);
                    Log.i("acctName", String.format("%s", newActName));
                    spEditor.putString("AcctPass[" + i + "]", PassActName);
                    //spEditor.apply();
                } else if (i == 0 || i == prefCount -1) {
                    spEditor.remove("AcctName[" + i + "]");
                    //spEditor.apply();
                }else{
                    spEditor.remove("AcctPass[" + (i + 1) + "]");
                }

            }

            spEditor.commit();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Account Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No account to Delete ", Toast.LENGTH_SHORT).show();
        }

    }

}
