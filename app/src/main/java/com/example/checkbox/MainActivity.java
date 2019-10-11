package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox opcionMostrar;
    private EditText campoContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcionMostrar = (CheckBox)findViewById(R.id.opcion_mostrar);
        campoContrasena = (EditText)findViewById(R.id.campo_contrasena);

        opcionMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarContrasena(v);
            }
        });

        opcionMostrar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(opcionMostrar.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Control chqueo TRUE", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Control chqueo FALSE", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void mostrarContrasena(View v)
    {
        int cursor = campoContrasena.getSelectionEnd();

        if(opcionMostrar.isChecked())
        {
            campoContrasena.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        else
        {
            campoContrasena.setInputType(InputType.TYPE_CLASS_TEXT
                    |InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }

        campoContrasena.setSelection(cursor);
    }
}
