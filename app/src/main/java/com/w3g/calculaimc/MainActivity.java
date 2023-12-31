package com.w3g.calculaimc;

import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;

    private IMC imc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        Button btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(v -> {
            String inputPeso = etPeso.getText().toString();
            String inputAltura = etAltura.getText().toString();

            if (!inputPeso.isEmpty() && !inputAltura.isEmpty()) {
                float peso = Float.parseFloat(inputPeso);
                float altura = Float.parseFloat(inputAltura);

                MainActivity.this.Calcular(peso, altura);
            } else {
                String msg = "Preencha todos os campos antes de calcular";
                String titulo = "Erro!";
                exibirAlerta(msg, titulo);
            }
        });
    }

    private void Calcular(float peso, float altura) {
        this.imc = new IMC(peso, altura);
        this.imc.CalculaIMC();
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(super.getCurrentFocus().getWindowToken(), 0);

        this.imc.classificar();
        this.mudarImagem((String) this.imc.getImg());
        this.exibirResultado();
       /* Toast.makeText(MainActivity.this, "Seu IMC é: "
                                +this.imc.getResultado(),
                        Toast.LENGTH_SHORT)
                        .show();*/


    }

    private void exibirResultado() {
        String msg = String.format("Seu IMC é %.2f e está classificado em %s",
                this.imc.getResultado(), this.imc.getClassificacao());
        exibirAlerta(msg, "\"Resultado do IMC\"");
    }

    private void exibirAlerta(String msg, String titulo) {
        AlertDialog.Builder janela = new AlertDialog.Builder(this);
        janela.setTitle(titulo);
        janela.setMessage(msg);
        janela.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                etAltura.setText("");
                etPeso.setText("");
            }
        });

        AlertDialog alertDialog = janela.create();
        alertDialog.show();
    }

    public void mudarImagem(String img) {

        ImageView qImageView = findViewById(R.id.imgPrincipal);
        switch (img) {
            case "pesonormal":
                qImageView.setImageResource(R.drawable.pesonormal);
                break;
            case "acimapeso":
                qImageView.setImageResource(R.drawable.acimapeso);
                break;
            case "obesidade1":
                qImageView.setImageResource(R.drawable.obesidade1);
                break;
            case "obesidade2":
                qImageView.setImageResource(R.drawable.obesidade2);
                break;
            case "obesidade3":
                qImageView.setImageResource(R.drawable.obesidade3);
                break;

        }
    }
}