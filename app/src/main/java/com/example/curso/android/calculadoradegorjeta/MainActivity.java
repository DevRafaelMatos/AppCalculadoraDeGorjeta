package com.example.curso.android.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarProgresso;
    private TextView textProgresso;
    private TextInputEditText textValorDigitado;
    private TextView textTotal;
    private TextView textGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarProgresso = findViewById(R.id.seekBarPorcentagem);
        textProgresso = findViewById(R.id.textPorcentagem);
        textValorDigitado = findViewById(R.id.textValorDigitado);
        textTotal = findViewById(R.id.textResultadoTotal);
        textGorjeta = findViewById(R.id.textGorjeta);

        seekBarProgresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                String valorRecuperado = textValorDigitado.getText().toString();
                textProgresso.setText(i + "%");

                if(valorRecuperado == null || valorRecuperado.equals("")){



                }else {

                    Double valorDigitado = Double.parseDouble(valorRecuperado);
                    double valorGorjeta = (valorDigitado * i) / 100;
                    double valorTotal = valorDigitado + valorGorjeta;

                    textGorjeta.setText("R$ " + Math.round(valorGorjeta));

                    textTotal.setText("R$ " + Math.round(valorTotal));
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
