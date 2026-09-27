package com.example.vectorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Vector vector;
    private EditText inputValues;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vector = new Vector();
        inputValues = findViewById(R.id.inputValues);
        output = findViewById(R.id.output);

        Button btnCargar = findViewById(R.id.btnCargar);
        Button btnMostrar = findViewById(R.id.btnMostrar);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnInsertar = findViewById(R.id.btnInsertar);
        Button btnObtener = findViewById(R.id.btnObtener);
        Button btnCantidad = findViewById(R.id.btnCantidad);
        Button btnInvertir = findViewById(R.id.btnInvertir);
        Button btnRotar = findViewById(R.id.btnRotar);
        Button btnBusquedaSec = findViewById(R.id.btnBusquedaSec);
        Button btnBusquedaBin = findViewById(R.id.btnBusquedaBin);
        Button btnOrdenarIns = findViewById(R.id.btnOrdenarIns);
        Button btnEliminarRep = findViewById(R.id.btnEliminarRep);
        Button btnOrdenarFrec = findViewById(R.id.btnOrdenarFrec);

        btnCargar.setOnClickListener(v -> {
            String text = inputValues.getText().toString().trim();
            if (text.isEmpty()) {
                output.setText("Ingrese números separados por comas en el campo de entrada.");
                return;
            }
            String[] parts = text.split(",");
            int[] arr = new int[parts.length];
            try {
                for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i].trim());
                vector.cargar(arr);
                output.setText("Vector cargado: " + vector.comoString());
            } catch (NumberFormatException ex) {
                output.setText("Formato inválido. Use números separados por comas.");
            }
        });

        btnMostrar.setOnClickListener(v -> output.setText("Vector: " + vector.comoString()));

        btnAdicionar.setOnClickListener(v -> {
            String text = inputValues.getText().toString().trim();
            if (text.isEmpty()) { output.setText("Ingrese un número para adicionar."); return; }
            try {
                int val = Integer.parseInt(text);
                vector.adicionar(val);
                output.setText("Adicionado. Vector: " + vector.comoString());
            } catch (NumberFormatException ex) { output.setText("Número inválido."); }
        });

        btnInsertar.setOnClickListener(v -> {
            String text = inputValues.getText().toString().trim();
            if (!text.contains(":")) { output.setText("Formato: indice:valor"); return; }
            String[] p = text.split(":");
            try {
                int idx = Integer.parseInt(p[0].trim());
                int val = Integer.parseInt(p[1].trim());
                boolean ok = vector.insertar(idx, val);
                output.setText(ok ? "Insertado. Vector: " + vector.comoString() : "Índice fuera de rango.");
            } catch (Exception ex) { output.setText("Formato inválido. Use indice:valor"); }
        });

        btnObtener.setOnClickListener(v -> {
            String text = inputValues.getText().toString().trim();
            try {
                int idx = Integer.parseInt(text);
                Integer val = vector.obtener(idx);
                output.setText(val == null ? "Índice fuera de rango." : "Valor: " + val);
            } catch (Exception ex) { output.setText("Ingrese un índice válido."); }
        });

        btnCantidad.setOnClickListener(v -> output.setText("Cantidad: " + vector.cantidad()));

        btnInvertir.setOnClickListener(v -> { vector.invertir(); output.setText("Invertido: " + vector.comoString()); });

        btnRotar.setOnClickListener(v -> {
            String text = inputValues.getText().toString().trim();
            try {
                int k = Integer.parseInt(text);
                vector.rotar(k);
                output.setText("Rotado: " + vector.comoString());
            } catch (Exception ex) { output.setText("Ingrese número de posiciones para rotar."); }
        });

        btnBusquedaSec.setOnClickListener(v -> {
            try {
                int val = Integer.parseInt(inputValues.getText().toString().trim());
                int idx = vector.busquedaSecuencial(val);
                output.setText(idx >= 0 ? "Encontrado en índice " + idx : "No encontrado");
            } catch (Exception ex) { output.setText("Ingrese número a buscar."); }
        });

        btnBusquedaBin.setOnClickListener(v -> {
            try {
                int val = Integer.parseInt(inputValues.getText().toString().trim());
                int idx = vector.busquedaBinaria(val);
                output.setText(idx >= 0 ? "Encontrado en índice " + idx : "No encontrado (asegúrese que el vector esté ordenado)");
            } catch (Exception ex) { output.setText("Ingrese número a buscar."); }
        });

        btnOrdenarIns.setOnClickListener(v -> { vector.ordenarInsercion(); output.setText("Ordenado (insercion): " + vector.comoString()); });

        btnEliminarRep.setOnClickListener(v -> { vector.eliminarRep(); output.setText("Eliminados repetidos: " + vector.comoString()); });

        btnOrdenarFrec.setOnClickListener(v -> { vector.ordenarFrec(); output.setText("Ordenado por frecuencia: " + vector.comoString()); });
    }
}
