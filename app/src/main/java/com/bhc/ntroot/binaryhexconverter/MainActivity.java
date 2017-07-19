package com.bhc.ntroot.binaryhexconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dec;
        dec = (Button) findViewById(R.id.decButton);
        dec.setX(0);
        dec.setY(0);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDecimal();
            }
        });

        Button bin;
        bin = (Button) findViewById(R.id.binButton);
        bin.setX(0);
        bin.setY(0);
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBinary();
            }
        });

    }

    private void goToDecimal() {

        Intent intent = new Intent(this, Decimal.class);
        startActivity(intent);

    }

    private void goToBinary() {

        Intent intent = new Intent(this, Binary.class);
        startActivity(intent);

    }
}
