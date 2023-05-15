package com.example.myapplication.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NuevaAlimentacion;
import com.example.myapplication.NuevaMascota;
import com.example.myapplication.R;
import com.example.myapplication.alimentacion;
import com.example.myapplication.miMascota;

import java.util.ArrayList;

public class ListaAlimentacionAdapter extends RecyclerView.Adapter<ListaAlimentacionAdapter.alimentacionViewHolder> {
   ArrayList<alimentacion> listaAlimentacion;
   public ListaAlimentacionAdapter(ArrayList<alimentacion> listaAlimentacion){
       this.listaAlimentacion = listaAlimentacion;
   }


    @NonNull
    @Override
    public ListaAlimentacionAdapter.alimentacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_alimentacion, null, false);

        return new ListaAlimentacionAdapter.alimentacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAlimentacionAdapter.alimentacionViewHolder holder, int position) {
        holder.tvNombre.setText(listaAlimentacion.get(position).getNombreMascota());
        holder.tvNombreAl.setText(listaAlimentacion.get(position).getNombreAlimen());
        holder.tvTipoAl.setText(listaAlimentacion.get(position).getTipoAlimen());
        holder.tvCantidadAl.setText(listaAlimentacion.get(position).getCantidadAlimen());
        holder.tvTomasAl.setText(listaAlimentacion.get(position).getTomasAlimen());
    }

   @Override
    public int getItemCount() {
        return listaAlimentacion.size();
    }

    public class alimentacionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNombreAl, tvTipoAl, tvCantidadAl, tvTomasAl;
        public alimentacionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNombreAl= itemView.findViewById(R.id.tvNombreAl);
            tvTipoAl = itemView.findViewById(R.id.tvTipoAl);
            tvCantidadAl = itemView.findViewById(R.id.tvCantidadAl);
            tvTomasAl = itemView.findViewById(R.id.tvTomasAl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, NuevaAlimentacion.class);
                    intent.putExtra("NOMBREMASCOTA", listaAlimentacion.get(getAdapterPosition()).getNombreMascota());
                    intent.putExtra("NOMBREALIMEN", listaAlimentacion.get(getAdapterPosition()).getNombreAlimen());
                    context.startActivity(intent);
                }
            });
        }
        }
    }

