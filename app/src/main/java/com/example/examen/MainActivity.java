package com.example.examen;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.PersonaAdapter;
import models.Persona;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclepersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclepersona = findViewById(R.id.recyclepersona);
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Andres","8714004753", "fue hace una vez en un parque", Color.parseColor("#0000FF"),"37.7749, -122.4149"));
        personas.add(new Persona("Erick", "8715678943", "en un hospital", Color.parseColor("#673AB7"),"38.7749, -122.4149" ));
        personas.add(new Persona("Cristian", "8717896610", "viaje de negocios", Color.parseColor("#CDDC39"),"39.7749, -122.4149" ));
        personas.add(new Persona("Gael", "8712456734", "excompa del kinder", Color.parseColor("#4CAF50"),"40.7749, -122.4149" ));
        personas.add(new Persona("Cesar", "8711456890", "de la universidad", Color.parseColor("#009688"), "41.7749, -122.4149"));

        PersonaAdapter adapterPersona = new PersonaAdapter(personas);
        recyclepersona.setHasFixedSize(true);
        recyclepersona.setAdapter(adapterPersona);
        recyclepersona.setLayoutManager(new LinearLayoutManager(getApplicationContext())); recyclepersona = findViewById(R.id.recyclepersona);



    }

}

