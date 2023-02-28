package com.example.ferrytickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    double p1 = 34;
    double p2 = 40;
    int numberOfTickets;
    String choice;
    double total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText myEditText = findViewById(R.id.editTextFerry);
        Spinner destination = findViewById(R.id.spinner);
        Button cost = findViewById(R.id.btnCalc);
        TextView txt = findViewById(R.id.textViewCost);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    numberOfTickets = Integer.parseInt(myEditText.getText().toString());
                }catch (NumberFormatException e)
                {
                    txt.setText("please enter a value");
                    return;
                }
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                choice = destination.getSelectedItem().toString();
                if(destination.getSelectedItemPosition()==0)

                    total=p1*numberOfTickets;

                else
                    total = p2*numberOfTickets;

                txt.setText(currency.format(total));

            }
        });
    }
}