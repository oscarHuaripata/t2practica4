package com.example.t3_1_lista_contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.t3_1_lista_contactos.Adapters.ContactoAdapter;
import com.example.t3_1_lista_contactos.Clases.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       List<Contacto> contactos = GetContactos();

        RecyclerView rv = findViewById(R.id.rvPalabras);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ContactoAdapter adapter = new ContactoAdapter(contactos);
        rv.setAdapter(adapter);
    }

    public List<Contacto> GetContactos(){
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("oscar huaripata", "925732097"));
        contactos.add(new Contacto("Pedro Pablo", "999999948"));
        contactos.add(new Contacto("Jesus Montalvo", "98563258"));
        contactos.add(new Contacto("Maria Rodriguez", "98563258"));
        contactos.add(new Contacto("Jose Casas", "98563258"));
        contactos.add(new Contacto("Goku Diaz", "98563258"));
        contactos.add(new Contacto("Naruto Uzumaki", "98563258"));
        contactos.add(new Contacto("Erick Perez", "98563258"));
        contactos.add(new Contacto("Sofia Castro", "98563258"));
        contactos.add(new Contacto("Pedro Castillo", "98563258"));

        return contactos;
    }
}