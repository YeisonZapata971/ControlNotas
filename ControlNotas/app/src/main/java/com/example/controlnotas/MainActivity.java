package com.example.controlnotas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4,et5;
    Button b1;
    TextView tvPerdieron,tvResultado;
    CheckBox cb1;

    RadioButton rbN,rbY;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        b1 = findViewById(R.id.b1);
        tvPerdieron = findViewById(R.id.tvPerdieron);
        tvResultado = findViewById(R.id.tvResultado);
        cb1 = findViewById(R.id.cb1);
        rbN = findViewById(R.id.rbN);
        rbY = findViewById(R.id.rbY);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                calcularNotaDefinitiva();
            }
             });
        }

        private void calcularNotaDefinitiva() {
            // Obtener las notas ingresadas por el usuario
            double numEstudiantes = Double.parseDouble(et1.getText().toString());
            double nota1 = Double.parseDouble(et2.getText().toString());
            double nota2 = Double.parseDouble(et3.getText().toString());
            double nota3 = Double.parseDouble(et4.getText().toString());
            double nota4 = Double.parseDouble(et5.getText().toString());

            // Validar que las notas estén en el rango de 1 a 5
            if (nota1 < 0 || nota1 > 5 || nota2 < 0 || nota2 > 5 || nota3 < 0 || nota3 > 5 || nota4 < 0 || nota4 > 5) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 5", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calcular la nota definitiva
            double notaDefinitiva = (nota1 * 0.20) + (nota2 * 0.30) + (nota3 * 0.15) + (nota4 * 0.35);

            // Mostrar la nota definitiva en el TextView
            tvResultado.setText("Nota Definitiva: " + notaDefinitiva);

            // Contar cuántos estudiantes perdieron (nota definitiva < 3.0)
            int estudiantesPerdieron = (notaDefinitiva < 3.0) ? 1 : 0;
            tvPerdieron.setText("Estudiantes que perdieron: " + estudiantesPerdieron);



        }





    }
