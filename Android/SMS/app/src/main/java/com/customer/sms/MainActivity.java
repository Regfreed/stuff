package com.customer.sms;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEL_PREFIX = "tel:";
    EditText etBroj;
    EditText etPoruka;
    TextView tvPoslanaPoruka;
    TextView tvPrimljenaPoruka;
    Button btnPosalji;
    Button btnPokazi;
    ProgressDialog progres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();

        btnPosalji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBroj.getText().length() != 0 && (etPoruka.getText().length() !=0 && etPoruka.getText().length() <=160)){
                    progres = new ProgressDialog(MainActivity.this);
                    progres.setMessage("");
                    progres.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progres.show();
                    Progres sp = new Progres(progres, true);
                    sp.start();

                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(etBroj.getText().toString(), null, etPoruka.getText().toString(), null, null);


                    tvPoslanaPoruka.setText(etPoruka.getText().toString());

                }
           }
        });

        btnPokazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ActionBar acBar = getSupportActionBar();
                    if(acBar.isShowing()){
                        acBar.hide();
                    }else{
                        acBar.show();
                    }
                }
        });
    }

    private void initWidgets() {
        etBroj = (EditText)findViewById(R.id.etBroj);
        etPoruka= (EditText)findViewById(R.id.etPoruka);
        btnPosalji = (Button)findViewById(R.id.btnPosalji);
        btnPokazi=(Button)findViewById(R.id.btnPrikazi);
        tvPoslanaPoruka = (TextView)findViewById(R.id.tvPoslanaPoruka);
        tvPrimljenaPoruka = (TextView)findViewById(R.id.tvPrimljenaPoruka);
    }


}