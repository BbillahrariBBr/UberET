package com.example.bakibillah.uberet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSIgnIn;
    Button buttonReg;

    //press CTRL+O

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //before setContent view
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                        .setDefaultFontPath("fonts/Arkhip_font.ttp")
                                        .setFontAttrId(R.attr.font)
                                        .build());
        setContentView(R.layout.activity_main);

        setUpUI();
        buttonReg.setOnClickListener(MainActivity.this);
    }



    public  void setUpUI(){
        buttonSIgnIn = (Button)findViewById(R.id.buttonSIgnIn);
        buttonReg = (Button)findViewById(R.id.buttonReg);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.buttonReg){
            showRegisterDialog();
            //startActivity(new Intent(MainActivity.this,TestActivity.class));
        }
    }

    private void showRegisterDialog() {
        final AlertDialog.Builder regDialog = new AlertDialog.Builder(this);
        regDialog.setTitle("REGISTER ");
        regDialog.setMessage("Please use email to register");

        LayoutInflater regInflater = LayoutInflater.from(this);
        View registration_layout =  regInflater.inflate(R.layout.registration_layout,null);
        MaterialEditText emailMet = registration_layout.findViewById(R.id.emailMet);
        MaterialEditText passMet = registration_layout.findViewById(R.id.passMet);
        MaterialEditText nameMet = registration_layout.findViewById(R.id.nameMet);
        MaterialEditText phoneMet = registration_layout.findViewById(R.id.phoneMet);

        regDialog.setView(registration_layout);
        //set Button

        regDialog.setPositiveButton("REGISTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        regDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        regDialog.show();



    }
    public void  setupRegUI(){

    }
}
