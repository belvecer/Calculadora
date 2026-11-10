package com.belen.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textResultado;
    TextView caja2;
    int valorAnterior; //lo cambio a int porq estoy pasandle un parse int para convertirlo en string y le estaba psando un float

    boolean pulsadoSumar;
    boolean sumaActiva;
    boolean restaActiva;
    boolean pulsadoRestar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        textResultado = findViewById(R.id.texto);
        textResultado.setText("0");
        textResultado.setTextSize(120);

        caja2=findViewById(R.id.texto2);

        valorAnterior = 0;
        pulsadoSumar = false;
        sumaActiva=false;


    }

    //Hacer una segunda caja de texto


    public void sumar(View boton){
        caja2.setText(textResultado.getText()  + " + ");
        valorAnterior = Integer.parseInt(textResultado.getText().toString());
        pulsadoSumar = true;
    }

    public void restar(View boton){
        caja2.setText(textResultado.getText()  + " - ");
        valorAnterior = Integer.parseInt(textResultado.getText().toString());
        pulsadoRestar = true;
    }

    public void reset (View boton) { //variable
        Button btn_reset = (Button) boton;
        textResultado.setText("0");
        caja2.setText("");
        valorAnterior=0;

        pulsadoSumar = false;
        sumaActiva = false;

        pulsadoRestar=false;
        restaActiva=false;
    }
    //el malo:
    /*public void resutado (View boton){ //pnerle el onclick en el layaout para que este bien
        caja2.setText(caja2.getText().toString() + textResultado.getText().toString() + " = "); //concatenar para subir la suma arriba
        textResultado.setText(valorAnterior + Integer.parseInt( textResultado.getText().toString()) );
    }
    */

    //el bueno:
    public void resultado (View boton) {
        caja2.setText(caja2.getText().toString() + textResultado.getText().toString() + " = ");  //recupera el texto anterior y le concatena el numero q esta y le añade el igual

        if(sumaActiva){
            textResultado.setText(Integer.toString(valorAnterior + Integer.parseInt(textResultado.getText().toString())) );
            sumaActiva=false;
        }

        if(restaActiva){
            textResultado.setText(Integer.toString(valorAnterior - Integer.parseInt(textResultado.getText().toString())) );
            restaActiva=false;
        }

    }

    public void numero (View boton) {
        Button btn_numero = (Button) boton;
        if(pulsadoSumar==true){
            textResultado.setText("");
            pulsadoSumar=false;
            sumaActiva=true;
        }

        if(pulsadoRestar==true){
            textResultado.setText("");
            pulsadoRestar=false;
            restaActiva=true;
        }

        if (textResultado.getText().equals("0")) {
            textResultado.setText("");
        }



        //if length es mayor que x, que no lo añada
        if(textResultado.getText().length() >= 6)
        {}else{
        textResultado.setText(textResultado.getText() + btn_numero.getText().toString());
        }
    }
}


















