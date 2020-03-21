package com.example.listepatisserie;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView  recyclerView;
    ArrayList mExampleList;

    String sMacaron[], sDescription[];
    int images[] = {R.drawable.macaron_chocolat,R.drawable.macaron_framboise,R.drawable.macaron_citron,R.drawable.macaron_pistache,R.drawable.macaron_orange,
                    R.drawable.macaron_passion,R.drawable.macaron_cafe,R.drawable.macaron_foie_gras,R.drawable.macaron_myrtille,R.drawable.macaron_vanille,
                    R.drawable.macarena};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.recyclerView);

        sMacaron = getResources().getStringArray(R.array.macarons);
        sDescription = getResources().getStringArray(R.array.descriptions);

        adapterListe MonAdapteur = new adapterListe(this, sMacaron, sDescription, images);

        recyclerView.setAdapter(MonAdapteur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
