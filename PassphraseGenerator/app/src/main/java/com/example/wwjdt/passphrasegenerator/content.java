package com.example.wwjdt.passphrasegenerator;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class content extends AppCompatActivity {

    ListView accountList;
    EditText accountNameTxt;
    Button addButton, logoutButton;
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


        logoutButton = (Button) findViewById(R.id.logoutButton);


        spEditor = pref.edit();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, accountnames);

        String ActName;
        String ActPass;
        for (int i = 0; i <= pref.getAll().size(); i++) {

            ActName = pref.getString("AcctName[" + i + "]", "empty");
            //ActPass = pref.getString("AcctPass[" + i + "]", "empty");
            if (ActName != "empty")
                accountnames.add(ActName);
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

        logoutButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(content.this, Login.class);
                        startActivity(intent);

                    }
                }
        );
        addButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(content.this, PasswordCreator.class);
                        Bundle acctAdd = new Bundle();
                        acctAdd.putString("user", MyPREFERENCES);
                        acctAdd.putString("mode", "add");
                        intent.putExtras(acctAdd);
                        startActivity(intent);

                    }
                }
        );


        accountList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, final int position, long id) {

                String dialogName = pref.getString("AcctName[" + position + "]", "");
                final String dialogPass = pref.getString("AcctPass[" + position + "]", "");

                final Dialog dialog = new Dialog(content.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.content_dialog_box);
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                // set the custom dialog components - text, image and button
                TextView text1 = (TextView) dialog.findViewById(R.id.text_view3);
                text1.setText( "Password: ");
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText( dialogPass);
                TextView text_view2 = (TextView) dialog.findViewById(R.id.text_view2);
                //text_view2.setText(dialogName);
                SpannableString spanString = new SpannableString(dialogName);
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                text_view2.setText(spanString);


                Button editButton = (Button) dialog.findViewById(R.id.btn_edit);
                Button copyButton = (Button) dialog.findViewById(R.id.btn_copy);
                Button deleteButton = (Button) dialog.findViewById(R.id.btn_delete);
                Button cancelButton = (Button) dialog.findViewById(R.id.btn_cancel);
                // if button is clicked, close the custom dialog
                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(content.this, PasswordCreator.class);
                        Bundle acctEdit = new Bundle();
                        acctEdit.putString("user", MyPREFERENCES);
                        acctEdit.putInt("pos", position);
                        acctEdit.putString("mode", "edit");
                        intent.putExtras(acctEdit);
                        startActivity(intent);

                    }

                });
                copyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        putText(dialogPass);

                    }

                });
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        delete();

                    }

                });
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();

                    }

                });


            }

        });
    }
    public void putText(String dialogPass){
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES. HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(dialogPass);
            Toast.makeText(getApplicationContext(), "Password Copied", Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = ClipData.newPlainText("simple text",dialogPass);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getApplicationContext(), "Password Copied", Toast.LENGTH_SHORT).show();
        }
    }
    private void delete() {
        int pos = accountList.getCheckedItemPosition();
        if (pos > -1) {
            adapter.remove(accountnames.get(pos));

            pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            spEditor = pref.edit();


            for (int i = pos; i < pref.getAll().size() - 1; i++) {

                int prefCount = (pref.getAll().size() - 1) / 2;


                String newActName = pref.getString("AcctName[" + (i + 1) + "]", "");
                Log.i("acctName", String.format("%s", newActName));
                String PassActName = pref.getString("AcctPass[" + (i + 1) + "]", "");
                if (newActName != "" && PassActName != "") {
                    spEditor.remove("AcctName[" + (i + 1) + "]");
                    spEditor.remove("AcctPass[" + (i + 1) + "]");
                    spEditor.putString("AcctName[" + i + "]", newActName);
                    Log.i("acctName", String.format("%s", newActName));
                    spEditor.putString("AcctPass[" + i + "]", PassActName);
                    spEditor.apply();
                } else if (i == 0 || i == prefCount - 1) {
                    spEditor.remove("AcctName[" + i + "]");
                    spEditor.remove("AcctPass[" + i + "]");

                    spEditor.apply();
                } else {
                    spEditor.remove("AcctPass[" + (i + 1) + "]");
                    spEditor.remove("AcctName[" + (i + 1) + "]");

                }

            }

            spEditor.commit();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Account Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No account to Delete ", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(content.this, content.class);
        intent.putExtra("user", MyPREFERENCES);
        startActivity(intent);

    }
}
