package com.example.atividadeimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    String mensagemCb;
    EditText edt_Altura, edt_Peso;
    CheckBox cb_Arroz, cb_salad, cb_Macarrao, cb_Peixe, cb_Carne;
    Button bt_CalcImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Peso = (EditText) findViewById(R.id.edt_Peso);
        edt_Altura = (EditText) findViewById(R.id.edt_Altura);

        cb_Arroz = (CheckBox) findViewById(R.id.cb_Arroz);
        cb_Carne = (CheckBox) findViewById(R.id.cb_Carne);
        cb_Peixe = (CheckBox) findViewById(R.id.cb_Peixe);
        cb_salad = (CheckBox) findViewById(R.id.cb_salad);
        cb_Macarrao = (CheckBox) findViewById(R.id.cb_Macarrao);

        bt_CalcImc = (Button) findViewById(R.id.bt_CalcImc);

        bt_CalcImc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                float peso = Float.parseFloat(edt_Peso.getText().toString());
                float altura = Float.parseFloat(edt_Altura.getText().toString());
                float imc ;
                String result;

                altura = ( altura / 100 );

                imc = peso / ( altura * altura );

                if(imc < 18.5){
                    result = "O seu IMC é: "+ imc +", Estás em estado de Peso abaixo do ideal"+ '\n' + mensagemCb;
                }else if (imc  < 25.0){
                    result = "O seu IMC é: "+ imc +", Estás em estado de Peso Ideal" + '\n'+ mensagemCb;
                }else if (imc < 30){
                    result = "O seu IMC é: "+ imc + ", Estás em estado de Sobrepeso" + '\n' +mensagemCb;
                }else if (imc < 35){
                    result = "O seu IMC é: "+ imc +", Estás em estado de Obeso (Garu I)\n"+"\nProcure o seu médico, ou um especialista";
                }else if (imc < 40){
                    result = "O seu IMC é: "+ imc +", Estás em estado de Obesidade Severa (Grau II)\n"+"\nProcure o seu médico, ou um especialista";
                }else{
                    result = "O seu IMC é: "+ imc +", Estás em estado de Obesidade Mórbida\n"+"\nProcure o seu médico, ou um especialista";
                }

                if ((cb_Macarrao).isChecked() && (cb_Arroz).isChecked()) {
                    //mensagemCb para retornar algo para a exibição da mensagem
                    mensagemCb = "Só consumir Macarrão e Arroz uma vez por semana";
                } else if (!(cb_Arroz).isChecked() && !(cb_Arroz).isChecked()) {
                    mensagemCb = "Vida Saudável";
                }else{
                    mensagemCb = "";
                }


                AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
                mensagem.setTitle("Calculo IMC");
                mensagem.setMessage( result );
                mensagem.setNegativeButton("Valeu", null);
                mensagem.show();
            }


        });


    }
}
