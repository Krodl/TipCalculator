package com.teeniebyte.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance( );
    private EditText billEditText;
    private EditText tipEditText;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        tipCalc = new TipCalculator( 0.17f, 100.0f );
        setContentView( R.layout.activity_main );

        billEditText = ( EditText ) findViewById( R.id.amount_bill );


        TextChangeHandler tch = new TextChangeHandler( );
        billEditText.addTextChangedListener( tch );

    }
    public void calculate(View v ) {
        Log.w("MainActivity", "v = " + v);

        String billString = billEditText.getText().toString();

        TextView tipTextView =
                (TextView) findViewById(R.id.amount_tip);
        TextView totalTextView =
                (TextView) findViewById(R.id.amount_total);

        float billAmount = Float.parseFloat( billString );
        switch(v.getId()){
            case R.id.button1:
                tipTextView.setText(money.format(billAmount * .1));
                totalTextView.setText( money.format( (billAmount * .1) + billAmount ) );
                break;
            case R.id.button2:
                tipTextView.setText(money.format(billAmount * .15));
                totalTextView.setText( money.format( (billAmount * .15) + billAmount ) );
                break;
            case R.id.button3:
                tipTextView.setText(money.format(billAmount * .2));
                totalTextView.setText( money.format( (billAmount * .2) + billAmount ) );
                break;
            case R.id.button4:
                tipTextView.setText(money.format(billAmount * .25));
                totalTextView.setText( money.format( (billAmount * .25) + billAmount ) );
                break;
        }
    }

    private class TextChangeHandler implements TextWatcher {
        public void afterTextChanged( Editable e ) {
           // calculateTen( );
        }

        public void beforeTextChanged( CharSequence s, int start,
                                       int count, int after ) {
        }

        public void onTextChanged( CharSequence s, int start,
                                   int before, int after ) {
        }
    }
}
