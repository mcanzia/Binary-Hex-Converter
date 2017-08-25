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
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDecimal();
            }
        });

        Button bin;
        bin = (Button) findViewById(R.id.binButton);
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBinary();
            }
        });

        Button oct;
        oct = (Button) findViewById(R.id.octButton);
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOctal();
            }
        });

        Button hex;
        hex = (Button) findViewById(R.id.hexButton);
        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHex();
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

    private void goToOctal() {

        Intent intent = new Intent(this, Octal.class);
        startActivity(intent);

    }

    private void goToHex() {

        Intent intent = new Intent(this, Hex.class);
        startActivity(intent);

    }
}
