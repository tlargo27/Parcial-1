package com.mc.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnConsultar;
    private EditText txtSueldo;
    private EditText txtMesSueldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConsultar=findViewById(R.id.btnCalcular);
        txtSueldo=findViewById(R.id.txtSueldo);
        txtMesSueldo=findViewById(R.id.txtMesSueldo);
        btnConsultar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() ==  R.id.btnCalcular ){

            int mes = Integer.parseInt(txtMesSueldo.getText().toString());
            int diasMes=0;

            if (mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
                diasMes = 31;
            }

            else if (mes==4||mes==6||mes==9||mes==11){
                diasMes = 30;
            }

            else if (mes==2){
                diasMes = 28;
            }

            else{
                Toast.makeText(this, "Verifique el mes ingresado", Toast.LENGTH_SHORT).show();
            }

            double salario = Double.parseDouble(txtSueldo.getText().toString());
            double prima = ((salario + 106454) * diasMes)/360;
            double cesantias = ((salario + 106454) * diasMes)/360;
            double vacaciones = (salario * diasMes) / 720;
            double salud = (salario * 0.125);
            double pension = (salario * 0.16);
            double salarioReal = (salario - pension ) - prima;
            Toast.makeText(this, "Su prima es: " + prima + ",sus cesantias son: "+ cesantias + ",sus vacaciones son: "+ vacaciones +
                    " Su salario neto: " + salarioReal +
                    " Su aporte a salud es: " + salud+
                    " Su aporte a pensión es: " + pension , Toast.LENGTH_SHORT).show();

        }

    }
}