package com.example.calcular.calculadora;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Decalaracion de la instancia para los Botones del 0 al 9, suma, resta, multiplicacion, division, punto decimal, borrar numeros
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSuma, btnResta, btnDiv, btnMult, btnPunto, btnIgual, btnLimpiarTodo, btnBorrarUno;
    double num1=0, num2=0, Resp=0;
    boolean punto=true;
    TextView pantallaOper, pantallaRespuesta;
    String Operador="", GuardaCadenaOper="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Declaraciones();
    }

    private void Declaraciones() {
        pantallaOper = (TextView)findViewById(R.id.pantallaOperacion);
        pantallaRespuesta = (TextView)findViewById(R.id.pantallaRespT);

      /*0*/  btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"0");
            }
        });

      /*1*/  btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"1");
            }
        });

      /*2*/  btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"2");
            }
        });

      /*3*/  btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"3");
            }
        });

      /*4*/  btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"4");
            }
        });

      /*5*/  btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"5");

            }
        });

      /*6*/  btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"6");
            }
        });

      /*7*/  btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"7");
            }
        });

      /*8*/  btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"8");
            }
        });

      /*9*/  btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaRespuesta.setText(pantallaRespuesta.getText()+"9");
            }
        });



        /*Creacion del Punto Decimal*/
        btnPunto = (Button)findViewById(R.id.btncoma);
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(punto==true){
                    pantallaRespuesta.setText(pantallaRespuesta.getText()+".");
                    punto=false;
                }else {
                    String Validarpunto = String.valueOf(pantallaRespuesta.getText());
                    if(Validarpunto.indexOf(".")==-1){
                        punto = true;
                    }
                }
            }
        });
        //Llamado a los metodos de las Operaciones
        Suma();
        Resta();
        Multiplica();
        Divide();
        Igual();
        LimpiaTodo();
        LimpiaUno();
    }



    private void Divide() {
        btnDiv = (Button)findViewById(R.id.btnDivide);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    num1 = Double.parseDouble(pantallaRespuesta.getText().toString());
                    Operador = "/";
                    GuardaCadenaOper = String.valueOf(num1)+" "+Operador+" ";
                    pantallaOper.setText(GuardaCadenaOper.toString());
                    pantallaRespuesta.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplication(),"Ingrese Valores faltantes para Operacion División",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void Multiplica() {
        btnMult = (Button)findViewById(R.id.btnMultiplica);
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Double.parseDouble(pantallaRespuesta.getText().toString());
                    Operador = "*";
                    GuardaCadenaOper = String.valueOf(num1)+" "+Operador+" ";
                    pantallaOper.setText(GuardaCadenaOper.toString());
                    pantallaRespuesta.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplication(),"Ingrese Valores faltantes para Operacion Multiplicacion",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void Resta() {
        btnResta = (Button)findViewById(R.id.btnResta);
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    num1 = Double.parseDouble(pantallaRespuesta.getText().toString());
                    Operador = "-";
                    GuardaCadenaOper = String.valueOf(num1)+" "+Operador+" ";
                    pantallaOper.setText(GuardaCadenaOper.toString());
                    pantallaRespuesta.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplication(),"Ingrese Valores faltantes para Operacion Resta",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void Suma(){
        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    num1 = Double.parseDouble(pantallaRespuesta.getText().toString());
                    Operador="+";
                    GuardaCadenaOper = String.valueOf(num1)+" "+Operador+" ";
                    pantallaOper.setText(GuardaCadenaOper.toString());
                    pantallaRespuesta.setText("");
                } catch (Exception e){
                    Toast.makeText(getApplication(),"Ingrese Valores faltantes para Operacion Suma",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Igual() {
        btnIgual = (Button)findViewById(R.id.btnigual);
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    switch (Operador){
                        case "+":

                            num2 = Double.parseDouble(pantallaRespuesta.getText().toString());
                            if(String.valueOf(num2)==null){
                                Toast.makeText(getApplication(),"Ingrese un segundo Valor",Toast.LENGTH_SHORT).show();
                            }else {
                                Resp = num1 + num2;
                                GuardaCadenaOper = GuardaCadenaOper + String.valueOf(num2);
                                pantallaOper.setText(GuardaCadenaOper);
                                pantallaRespuesta.setText(String.valueOf(Resp));
                            }
                            break;
                        case "/":
                            if(String.valueOf(num2)==null){
                                Toast.makeText(getApplication(),"Ingrese un segundo Valor",Toast.LENGTH_SHORT).show();
                            }else {
                                num2 = Double.parseDouble(pantallaRespuesta.getText().toString());
                                GuardaCadenaOper = GuardaCadenaOper + String.valueOf(num2);
                                pantallaOper.setText(GuardaCadenaOper);
                                if (num2 == 0) {
                                    Toast.makeText(getApplication(), "Error, Favor volver a formular Operación", Toast.LENGTH_SHORT).show();
                                } else {
                                    Resp = num1 / num2;
                                }
                                pantallaRespuesta.setText(String.valueOf(Resp));
                            }
                            break;

                        case "*":
                            if(String.valueOf(num2)==null){
                                Toast.makeText(getApplication(),"Ingrese un segundo Valor",Toast.LENGTH_SHORT).show();
                            }else {
                                num2 = Double.parseDouble(pantallaRespuesta.getText().toString());
                                Resp = num1 * num2;
                                GuardaCadenaOper = GuardaCadenaOper + String.valueOf(num2);
                                pantallaOper.setText(GuardaCadenaOper);
                                pantallaRespuesta.setText(String.valueOf(Resp));
                            }
                            break;

                        case "-":
                            if(String.valueOf(num2)==null){
                                Toast.makeText(getApplication(),"Ingrese un segundo Valor",Toast.LENGTH_SHORT).show();
                            }else {
                                num2 = Double.parseDouble(pantallaRespuesta.getText().toString());
                                Resp = num1 - num2;
                                GuardaCadenaOper = GuardaCadenaOper + String.valueOf(num2);
                                pantallaOper.setText(GuardaCadenaOper);
                                pantallaRespuesta.setText(String.valueOf(Resp));
                            }
                            break;
                    }
                } catch (Exception e){
                    Toast.makeText(getApplication(),"Ingrese Valor Faltante",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void LimpiaUno(){
        btnBorrarUno = (Button)findViewById(R.id.btnborrauno);
        btnBorrarUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = String.valueOf(pantallaRespuesta.getText().toString());
                int i = cadena.length();
                if(i>=1) {
                    cadena = cadena.substring(0, i - 1);
                    pantallaRespuesta.setText(cadena.toString());
                }
            }
        });
    }

    private void LimpiaTodo(){
        btnLimpiarTodo = (Button)findViewById(R.id.btnBorraTodo);
        btnLimpiarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = 0;
                num2 = 0;
                Resp = 0;
                pantallaRespuesta.setText("");
                pantallaOper.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout relative = (RelativeLayout)findViewById(R.id.relative);
        switch (item.getItemId()){
/**********************************************************/
            case R.id.menu_acerca_de:                 //Ejecuta el .class de acercaDE
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent i = new Intent(this, acercaDE.class);
                startActivity(i);
                return true;
            /***************************************************************/

        }

        return super.onOptionsItemSelected(item);
    }
}
