package com.example.myapplication.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.miMascota;

import java.util.ArrayList;

public class ListaMascotaAdapter extends RecyclerView.Adapter<ListaMascotaAdapter.MascotaViewHolder> {
   ArrayList<miMascota> listaMascotas;
   public ListaMascotaAdapter (ArrayList<miMascota> listaMascotas){
       this.listaMascotas = listaMascotas;
   }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_mascotas, null, false);

        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        holder.tvNombre.setText(listaMascotas.get(position).getNombre());
        holder.tvChip.setText(listaMascotas.get(position).getChip());
        holder.tvEdad.setText(listaMascotas.get(position).getEdad());
        holder.tvRazaLm.setText(listaMascotas.get(position).getRaza());
        holder.tvSexo.setText(listaMascotas.get(position).getSexo());
        holder.tvEsterilizado.setText(listaMascotas.get(position).getEsterilizado());
    }

    @Override
    public int getItemCount() {
      return listaMascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {

       TextView tvNombre, tvChip, tvEdad, tvRazaLm, tvSexo, tvEsterilizado;
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvChip = itemView.findViewById(R.id.tvChip);
            tvEdad = itemView.findViewById(R.id.tvEdad);
            tvRazaLm = itemView.findViewById(R.id.tvRazaLm);
            tvSexo = itemView.findViewById(R.id.tvSexo);
            tvEsterilizado = itemView.findViewById(R.id.tvEsterilizado);

        }
    }
}
