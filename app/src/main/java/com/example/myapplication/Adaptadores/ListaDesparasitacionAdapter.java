package com.example.myapplication.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NuevaDesparasitacion;
import com.example.myapplication.NuevaVacunacion;
import com.example.myapplication.R;
import com.example.myapplication.desparasitacion;

import java.util.ArrayList;

public class ListaDesparasitacionAdapter extends RecyclerView.Adapter<ListaDesparasitacionAdapter.desparasitacionViewHolder> {
   ArrayList<desparasitacion> listaDesparasitacion;
   public ListaDesparasitacionAdapter(ArrayList<desparasitacion> listaDesparasitacion){
       this.listaDesparasitacion = listaDesparasitacion;
   }


    @NonNull
    @Override
    public ListaDesparasitacionAdapter.desparasitacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_desparasitacion, null, false);

        return new ListaDesparasitacionAdapter.desparasitacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaDesparasitacionAdapter.desparasitacionViewHolder holder, int position) {
        holder.tvNombre.setText(listaDesparasitacion.get(position).getNombreMascota());
        holder.tvNombreDesp.setText(listaDesparasitacion.get(position).getNombreDesp());
        holder.tvTipoDesp .setText(listaDesparasitacion.get(position).getTipoDesp ());
        holder.tvDosisDesp .setText(listaDesparasitacion.get(position).getDosisDesp());
        holder.tvFrecuenciaDesp.setText(listaDesparasitacion.get(position).getFrecuenciaDesp());
        holder.tvFechaDesp.setText(listaDesparasitacion.get(position).getFechaDesp());
        holder.tvFechaProxDesp.setText(listaDesparasitacion.get(position).getFechaProxDesp());
    }

   @Override
    public int getItemCount() {
        return listaDesparasitacion.size();
    }

    public class desparasitacionViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNombreDesp, tvTipoDesp, tvFrecuenciaDesp,  tvFechaDesp, tvFechaProxDesp, tvDosisDesp;
        public desparasitacionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNombreDesp= itemView.findViewById(R.id.tvNombreDesp);
            tvTipoDesp = itemView.findViewById(R.id.tvTipoDesp);
            tvDosisDesp = itemView.findViewById(R.id.tvDosisDesp);
            tvFrecuenciaDesp = itemView.findViewById(R.id.tvFrecuenciaDesp);
            tvFechaDesp = itemView.findViewById(R.id.tvFechaDesp);
            tvFechaProxDesp = itemView.findViewById(R.id.tvFechaProxDesp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, NuevaDesparasitacion.class);
                    intent.putExtra("NOMBREMASCOTA", listaDesparasitacion.get(getAdapterPosition()).getNombreMascota());
                    intent.putExtra("NOMBREDESP", listaDesparasitacion.get(getAdapterPosition()).getNombreDesp());
                    context.startActivity(intent);
                }
            });
        }
    }
}
