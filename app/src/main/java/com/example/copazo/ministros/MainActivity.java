package com.example.copazo.ministros;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.example.copazo.ministros.Model.Adapter.ListadoPersonasAdapter;
import com.example.copazo.ministros.Model.Direccion;
import com.example.copazo.ministros.Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> listaPersonas= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeContenido();
    }

    private void listarPersonas(){
        try {

            String[] nombre= {
                    "Graciela",
                    "Clementina",
                    "Ana Gomez",
                    "Rosa",
                    "Elena",
                    "Corina",
                    "Elena Espinoza",
                    "Ana Maria",
                    "Maria Naviera",
                    "Jorge Trujillo",
                    "Familia Peña",
                    "Maria Elgueta",
                    "Irma Galvez",
                    "Luzmenia",
                    "Elena Flores",
                    "Cecilia"};
            String[] direccion= {
                    "Santa Teresita #2542",
                    "Santa Teresita #2524",
                    "Apostol Juan #2676",
                    "Santa Teresita #2842",
                    "Av. Mexico #3048",
                    "San Adolfo #3096",
                    "Santa Teresita #2852",
                    "Santa Luisa #2661",
                    "Av. Troncal San Francisco #2140, Casa 17",
                    "Salesianos #01985",
                    "Santisima Trinidad #1974",
                    "Buen Pastor #2818",
                    "Buen Pastor #2818",
                    "Santa Luisa #2669",
                    "Santa Teresita #2694",
                    "Cerro Pan de Azucar",};
            String[] fono= {"+56942062885"};
            String[] lng= {"-70.5676911"};
            String[] lat= {"-33.5796719"};

            for(int i=0 ; i < nombre.length ; i++){
                Persona p1= new Persona(nombre[i], new Direccion(direccion[i], lng[0], lat[0]),fono[0]);
                listaPersonas.add(p1);
            }


        }catch (Exception e){

        }
    }


    private void homeContenido(){
        listarPersonas();

        ListadoPersonasAdapter adapter = new ListadoPersonasAdapter(getApplicationContext(), listaPersonas);
        GridView grid_personas = findViewById(R.id.grid_personas);
        grid_personas.setAdapter(adapter);
    }

}
