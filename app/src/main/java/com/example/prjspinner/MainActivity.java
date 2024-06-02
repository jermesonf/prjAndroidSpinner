package com.example.prjspinner;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Spinner spn;
    EditText entSalario;
    TextView txtResposta;
    int aux = 0; //variavel auxiliar

    private static final String[] percentual = {"Escolha um item", "De 20%", "De 40%","De 45%","De 50%","De 70%","De 80%"};
    ArrayAdapter <String> percentualAdaptado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //construtor ↑

        spn = findViewById(R.id.spn);
        entSalario = findViewById(R.id.entSalario);
        txtResposta = findViewById(R.id.txtResposta);

        setTitle("Calcular aumento");

        percentualAdaptado = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, percentual);
        spn.setAdapter(percentualAdaptado);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int ItemPosicao, long l) {
                aux = ItemPosicao;
                posicao();

                if(aux != 0){//inicio da estrutura decisão
                    alerta(spn.getSelectedItem().toString());
                }//fim decisão

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });


    }

    public void posicao(){

        String txtSalario = entSalario.getText().toString();
        double total = 0;

        try{

            total = Double.parseDouble(txtSalario);

        }catch(Exception e){

            total = 1;


        }//fim catch


        switch(aux)
        {
            case 1:
                txtResposta.setText(String.format("%.2f", total * 1.20));
                break;
            case 2:
                txtResposta.setText(String.format("%.2f", total * 1.40));
                break;
            case 3:
                txtResposta.setText(String.format("%.2f", total * 1.45));
                break;
            case 4:
                txtResposta.setText(String.format("%.2f", total * 1.50));
                break;
            case 5:
                txtResposta.setText(String.format("%.2f", total * 1.70));
                break;
            case 6:
                txtResposta.setText(String.format("%.2f", total * 1.80));

        }

    }


    public void alerta(String texto){

        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);   //referenciar a classe no lugar do mainActivity
        dialogo.setTitle("Caixa de Opção");
        dialogo.setMessage("O aumento foi de " + texto);
        dialogo.setNeutralButton("Ok",null);
        dialogo.show();
    }

}//ultima chave