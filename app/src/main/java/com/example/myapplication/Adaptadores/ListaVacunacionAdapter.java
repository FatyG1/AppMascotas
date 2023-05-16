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
import com.example.myapplication.NuevaVacunacion;
import com.example.myapplication.R;
import com.example.myapplication.vacunacion;

import java.util.ArrayList;

public class ListaVacunacionAdapter extends RecyclerView.Adapter<ListaVacunacionAdapter.vacunacionViewHolder> {
   ArrayList<vacunacion> listaVacunacion;
   public ListaVacunacionAdapter(ArrayList<vacunacion> listaVacunacion){
       this.listaVacunacion = listaVacunacion;
   }


    @NonNull
    @Override
    public ListaVacunacionAdapter.vacunacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_vacunacion, null, false);

        return new ListaVacunacionAdapter.vacunacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaVacunacionAdapter.vacunacionViewHolder holder, int position) {
        holder.tvNombre.setText(listaVacunacion.get(position).getNombreMascota());
        holder.tvNombreVac.setText(listaVacunacion.get(position).getNombreVac());
        holder.tvFrecuenciaVac.setText(listaVacunacion.get(position).getFrecuenciaVac());
        holder.tvFechaVac.setText(listaVacunacion.get(position).getFechaVac());
        holder.tvFechaProxVac.setText(listaVacunacion.get(position).getFechaProxVac());
    }

   @Override
    public int getItemCount() {
        return listaVacunacion.size();
    }

    public class vacunacionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNombreVac, tvFrecuenciaVac, tvFechaVac, tvFechaProxVac;
        public vacunacionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNombreVac= itemView.findViewById(R.id.tvNombreVac);
            tvFrecuenciaVac = itemView.findViewById(R.id.tvFrecuenciaVac);
            tvFechaVac = itemView.findViewById(R.id.tvFechaVac);
            tvFechaProxVac = itemView.findViewById(R.id.tvFechaProxVac);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, NuevaVacunacion.class);
                    intent.putExtra("NOMBREMASCOTA", listaVacunacion.get(getAdapterPosition()).getNombreMascota());
                    intent.putExtra("NOMBREVAC", listaVacunacion.get(getAdapterPosition()).getNombreVac());
                    context.startActivity(intent);
                }
            });
        }
    }
}
