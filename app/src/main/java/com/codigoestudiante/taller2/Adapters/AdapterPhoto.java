package com.codigoestudiante.taller2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codigoestudiante.taller2.CountriesActivity;
import com.codigoestudiante.taller2.Models.ModelPhoto;
import com.codigoestudiante.taller2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/10/17.
 */

public class AdapterPhoto extends RecyclerView.Adapter<AdapterPhoto.ViewHolder> {


    List<ModelPhoto> modelPhotoList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdapterPhoto(List<ModelPhoto> photoList, Context context) {
        this.modelPhotoList = photoList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fotos_cv, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


     Picasso.with(context).load(modelPhotoList.get(position).getArrayPhotos()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes
        //Picasso.with(context).load(modelPhotoList.get(position).getFoto()).into((holder.foto));

        holder.title.setText("Titulo: "+modelPhotoList.get(position).getTitle());
        holder.title.setTextSize(16);
        holder.thumbnailUrl.setText("Link: "+modelPhotoList.get(position).getThumbnailUrl());
        holder.thumbnailUrl.setTextSize(12);
        holder.id.setText(modelPhotoList.get(position).getId()+" Me gusta");
        holder.id.setTextSize(10);


    }

    @Override
    public int getItemCount() {
        return modelPhotoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, thumbnailUrl,id;

        ImageView foto;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            foto=(ImageView)item.findViewById(R.id.id_img_item_cardview);
            title = (TextView) item.findViewById(R.id.id_tv_item_cv_user);
            thumbnailUrl = (TextView) item.findViewById(R.id.id_tv_item_cv_des);
            id=(TextView)item.findViewById(R.id.id_tv_item_cv_count);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();
            Intent intent = new Intent(context, CountriesActivity.class);
            contextItem.startActivity(intent);
        }
    }


}
