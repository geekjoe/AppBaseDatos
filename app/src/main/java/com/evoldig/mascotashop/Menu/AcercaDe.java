package com.evoldig.mascotashop.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.evoldig.mascotashop.R;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //Función de Toolbar
        Toolbar miActionBar3 = (Toolbar) findViewById(R.id.miActionBarAcercade);
        miActionBar3.setTitle("");
        setSupportActionBar(miActionBar3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
