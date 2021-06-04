package br.com.example.appjogoandroidphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.example.appjogoandroidphone.controller.JogarController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            EditText etNumero = findViewById(R.id.etNumero);
            etNumero.setGravity(Gravity.CENTER);

            EditText etTentativa = findViewById(R.id.etTentativa);
            etTentativa.setGravity(Gravity.CENTER);
            etTentativa.setInputType(View.LAYER_TYPE_NONE);

            Button btnTentar = findViewById(R.id.btnTentar);

            int numeroGerado = (int) ((Math.random() * 100) + 1);

//            btnTentar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jogar(etNumero, etTentativa, numeroGerado);
//                }
//            });

//            View.OnClickListener acao = new JogarController();
//            btnTentar.setOnClickListener(acao);

            btnTentar.setOnClickListener(v -> jogar(etNumero, etTentativa, numeroGerado));
    }

    private void jogar(EditText etNumero, EditText etTentativa, int numeroGerado) {
        String num = etNumero.getText().toString();
        int numeroDigitado = Integer.parseInt(num);

        if (numeroDigitado > numeroGerado) {
            etTentativa.setText("O número é inferior a "+numeroDigitado);
        }
        if (numeroDigitado < numeroGerado) {
            etTentativa.setText("O número é superior a "+numeroDigitado);
        }
        if (numeroDigitado == numeroGerado) {
            vitoria(numeroGerado);
        }
        etNumero.setText("");
    }

    private void vitoria(int numeroGerado) {
        Bundle bundle = new Bundle();
        bundle.putInt("numero", numeroGerado);

        Intent intent = new Intent(this, RetornoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}