package com.bhc.ntroot.binaryhexconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Decimal extends AppCompatActivity {

    private LinearLayout mainLayout;
    private EditText seqInputContainer;
    private TextView errorDisplay;
    private TextView testDisplay1;
    private TextView testDisplay2;
    private TextView testDisplay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);

        mainLayout = (LinearLayout)findViewById(R.id.linearLayoutBack);

        seqInputContainer = (EditText) findViewById(R.id.seqInput);
        seqInputContainer.setX(20);
        seqInputContainer.setY(150);

        errorDisplay = (TextView)findViewById(R.id.error);
        errorDisplay.setX(20);
        errorDisplay.setY(300);

        testDisplay1 = (TextView)findViewById(R.id.seqDisplay1);
        testDisplay1.setX(20);
        testDisplay1.setY(750);

        testDisplay2 = (TextView)findViewById(R.id.seqDisplay2);
        testDisplay2.setX(20);
        testDisplay2.setY(1050);

        testDisplay3 = (TextView)findViewById(R.id.seqDisplay3);
        testDisplay3.setX(20);
        testDisplay3.setY(1350);

        Button convert;
        convert = (Button) findViewById(R.id.button2);
        convert.setX(20);
        convert.setY(400);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkIfValid()) {
                    displayInput();
                    errorDisplay.setText("");
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        Button back;
        back = (Button) findViewById(R.id.backBin);
        back.setY(1500);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBack();
            }
        });
    }

    private void displayInput() {
        final TextView tit1;
        final TextView tit2;
        final TextView tit3;

        tit1 = (TextView)findViewById(R.id.title1);
        tit1.setX(20);
        tit1.setY(600);
        tit1.setTextSize(25);
        tit2 = (TextView)findViewById(R.id.title2);
        tit2.setX(20);
        tit2.setY(900);
        tit2.setTextSize(25);
        tit3 = (TextView)findViewById(R.id.title3);
        tit3.setX(20);
        tit3.setY(1200);
        tit3.setTextSize(25);

        tit1.setText(R.string.binary);
        tit2.setText(R.string.octal);
        tit3.setText(R.string.hexadecimal);


        //Conversions
        int tempInput = Integer.parseInt(seqInputContainer.getText().toString());

        String convertToBinary = Conversions.decimalToBinary(tempInput);
        testDisplay1.setText(convertToBinary);
        testDisplay1.setTextSize(15);

        String convertToOctal = Conversions.decimalToOctal(tempInput);
        testDisplay2.setText(convertToOctal);
        testDisplay2.setTextSize(15);

        String convertToHex = Conversions.decimalToHex(tempInput);
        testDisplay3.setText(convertToHex);
        testDisplay3.setTextSize(15);
    }

    private boolean checkIfValid() {
        try {
            long check = Long.parseLong(seqInputContainer.getText().toString());
            if (check > Integer.MAX_VALUE) {
                errorDisplay.setText(R.string.errorTooLarge);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            errorDisplay.setText(R.string.error);
            return false;
        }
    }

    private void goToBack() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
