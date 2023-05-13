package com.example.myapplication.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.desparasitacion;
import com.example.myapplication.tratamiento;

import java.util.ArrayList;

public class ListaTratamientoAdapter extends RecyclerView.Adapter<ListaTratamientoAdapter.tratamientoViewHolder> {
   ArrayList<tratamiento> listaTratamiento;
   public ListaTratamientoAdapter(ArrayList<tratamiento> listaTratamiento){
       this.listaTratamiento = listaTratamiento;
   }


    @NonNull
    @Override
    public ListaTratamientoAdapter.tratamientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_tratamiento, null, false);

        return new ListaTratamientoAdapter.tratamientoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaTratamientoAdapter.tratamientoViewHolder holder, int position) {
        holder.tvNombre.setText(listaTratamiento.get(position).getNombreMascota());
        holder.tvNombreTto.setText(listaTratamiento.get(position).getNombreTto());
        holder.tvUsoTto.setText(listaTratamiento.get(position).getUsoTto());
        holder.tvFrecuenciaTto.setText(listaTratamiento.get(position).getFrecuenciaTto());
        holder.tvDosisTto.setText(listaTratamiento.get(position).getDosisTto());
        holder.tvDuracionTto.setText(listaTratamiento.get(position).getDuracionTto());
    }

   @Override
    public int getItemCount() {
        return listaTratamiento.size();
    }

    public class tratamientoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNombreTto, tvUsoTto, tvDosisTto,  tvFrecuenciaTto, tvDuracionTto;
        public tratamientoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNombreTto= itemView.findViewById(R.id.tvNombreTto);
            tvUsoTto = itemView.findViewById(R.id.tvUsoTto);
            tvFrecuenciaTto = itemView.findViewById(R.id.tvFrecuenciaTto);
            tvDosisTto = itemView.findViewById(R.id.tvDosisTto);
            tvDuracionTto = itemView.findViewById(R.id.tvDuracionTto);
        }
    }
}
