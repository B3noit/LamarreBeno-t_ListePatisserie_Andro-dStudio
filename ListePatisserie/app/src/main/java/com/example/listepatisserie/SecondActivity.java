package com.example.listepatisserie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    ImageView image;
    TextView textTitre,textDescription;

    String donnée1, donnée2;
    int illustration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image = findViewById(R.id.grosse_illustration);
        textTitre = findViewById(R.id.gros_titre);
        textDescription = findViewById(R.id.grosse_description);

        getDonnée();
        setDonnée();
    }

    private void getDonnée(){
        if(getIntent().hasExtra("illustration") &&  getIntent().hasExtra("donnée1")&&
        getIntent().hasExtra("donnée2")){

            donnée1 = getIntent().getStringExtra("donnée1");
            donnée2 = getIntent().getStringExtra("donnée2");
            illustration = getIntent().getIntExtra("illustration",1);

        }else {
            Toast.makeText(this,"Pas de donnée trouvé.",Toast.LENGTH_SHORT).show();
        }
    }

    private void setDonnée(){
        textTitre.setText(donnée1);
        textDescription.setText(donnée2);
        image.setImageResource(illustration);
    }


}
