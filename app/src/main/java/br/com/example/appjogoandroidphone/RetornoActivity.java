package br.com.example.appjogoandroidphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RetornoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorno);

        EditText etResultado = findViewById(R.id.etResultado);
        etResultado.setGravity(Gravity.CENTER);
        etResultado.setInputType(View.LAYER_TYPE_NONE);
        etResultado.setTextSize(14);

        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intentMain = getIntent();
        int numeroGerado = numeroGerado(intentMain);

        etResultado.setText("Acertou o no. "+numeroGerado);
        btnVoltar.setOnClickListener(v -> voltar());

    }

    private int numeroGerado(Intent intentMain) {
        Bundle bundleMain = intentMain.getExtras();
        int numeroGerado = bundleMain.getInt("numero");

        return numeroGerado;
    }

    private void voltar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}