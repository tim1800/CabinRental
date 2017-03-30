//Brandon Harris, Deng Pan

package com.cabinrental;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import static java.util.Calendar.DATE;

public class MainActivity extends AppCompatActivity {

    private TextView reservation;
    private String btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton btnCabin1 = (RadioButton) findViewById(R.id.btnCabin1) ;
        final RadioButton btnCabin2 = (RadioButton) findViewById(R.id.btnCabin2) ;



        reservation = (TextView) findViewById(R.id.txtDescription);
        Button button = (Button) findViewById(R.id.btnDate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                new DatePickerDialog(MainActivity.this, d, c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
                if (btnCabin1.isChecked()){
                    btn = "Small Cabin";
                } else if (btnCabin2.isChecked()) {
                    btn = "Large Cabin";
                }
            }
        });
    }

    Calendar c = Calendar.getInstance();
    Calendar c1 = Calendar.getInstance();
    //Calendar c1 = c;
    //c1.add(Calendar.DATE,3);
    DateFormat fmtDate = DateFormat.getDateInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            c1.set(Calendar.YEAR, year);
            c1.set(Calendar.MONTH, monthOfYear);
            c1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            c1.add(DATE, 3);

            reservation.setText("Your cabin reservation for " + btn + " is set for " + fmtDate.format(c.getTime()) + " to " + fmtDate.format(c1.getTime()) );
        }
    };

}
