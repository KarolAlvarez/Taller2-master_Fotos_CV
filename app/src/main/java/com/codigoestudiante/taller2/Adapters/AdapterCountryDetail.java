package com.codigoestudiante.taller2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codigoestudiante.taller2.Models.CountryDetail;
import com.codigoestudiante.taller2.R;
import com.codigoestudiante.taller2.Views.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by software on 28/09/2017.
 */

public class AdapterCountryDetail extends RecyclerView.Adapter<AdapterCountryDetail.ViewHolder> {

    List<CountryDetail> countryList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdapterCountryDetail(List<CountryDetail> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        holder.textViewSubregion.setText(countryList.get(position).getSubregion());
        holder.textViewLanguages.setText(countryList.get(position).getLanguages());
        holder.textViewArea.setText(Integer.toString(countryList.get(position).getArea()));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewSubregion;
        TextView textViewLanguages;
        TextView textViewArea;
        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewSubregion = (TextView) item.findViewById(R.id.id_tv_item_region);
            textViewLanguages = (TextView) item.findViewById(R.id.id_tv_item_languages);
            textViewArea = (TextView) item.findViewById(R.id.id_tv_item_area);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            contextItem.startActivity(intent);
        }
    }

}
