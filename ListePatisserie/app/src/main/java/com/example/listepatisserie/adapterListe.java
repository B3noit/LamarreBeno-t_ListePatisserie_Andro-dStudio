package com.example.listepatisserie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class adapterListe extends RecyclerView.Adapter<adapterListe.monViewHolder> {

    String donnée1[], donnée2[];
    int images[];
    Context context;

    public adapterListe(Context ct, String sMacaron[], String sDescription[], int img[]){
        context = ct;
        donnée1 = sMacaron;
        donnée2 = sDescription;
        images = img;

    }

    @NonNull
    @Override
    public monViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ligne_recycler, parent,false);
        return new monViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull monViewHolder holder, final int position) {
        holder.textTitre.setText(donnée1[position]);
        holder.textDescription.setText(donnée2[position]);
        holder.illustration.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("donnée1", donnée1[position]);
                intent.putExtra("donnée2", donnée2[position]);
                intent.putExtra("illustration", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return donnée1.length;
    }

    public class monViewHolder extends RecyclerView.ViewHolder{

        TextView textTitre, textDescription;
        ImageView illustration;
        ConstraintLayout mainLayout;

        public monViewHolder(@NonNull View itemView){
            super(itemView);
            textTitre = itemView.findViewById(R.id.Titre);
            textDescription = itemView.findViewById(R.id.Description);
            illustration = itemView.findViewById(R.id.illustration);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}
