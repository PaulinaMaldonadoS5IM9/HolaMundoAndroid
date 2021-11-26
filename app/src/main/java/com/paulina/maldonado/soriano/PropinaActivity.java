package com.paulina.maldonado.soriano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PropinaActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    private EditText editTextX;
    private EditText editTextY;
    private EditText editTextTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propina);
        editTextX = findViewById( R.id.editTextCantidadDinero );
        editTextY = findViewById( R.id.editTextPorcentaje);
        editTextTotal = findViewById( R.id.editTextPropina );
        editTextX.setOnFocusChangeListener( this );
        editTextY.setOnFocusChangeListener( this );
        editTextTotal.setEnabled( false );
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if( !hasFocus ) {
            realizaOperacion();
        }
    }

    private void realizaOperacion()
    {
        double total = 0;
        if( editTextX.getText().toString() != null )
        {
            if( isDouble( editTextX.getText().toString() ) )
            {
                total = getDouble( editTextX.getText().toString() );
            }
        }
        if( editTextY.getText().toString() != null )
        {
            if( isDouble( editTextY.getText().toString() ) )
            {
                total = ((total) * (getDouble( editTextY.getText().toString() ))) / 100;
            }
        }
        editTextTotal.setText(String.valueOf(total));
        editTextTotal.setEnabled( false );
    }

    private double getDouble(String entero)
    {
        try
        {
            return Double.parseDouble( entero );
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isDouble(String entero)
    {
        try
        {
            if( entero == null || entero.length() == 0)
            {
                return false;
            }
            Double.parseDouble( entero );
            return true;
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;

    }
}