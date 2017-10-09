package com.codigoestudiante.taller2.Models;

/**
 * Created by root on 4/10/17.
 */

public class ModelPhoto {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrayPhotos() {
        arrayPhotos = new String[10];
        arrayPhotos[0]="https://i.pinimg.com/originals/bb/7e/d4/bb7ed4855b6d0df8305e10247b726cbd.jpg";
        arrayPhotos[1]="https://k38.kn3.net/taringa/2/4/3/0/6/6/13/soyluuchoox/A1D.jpg?1843";
        arrayPhotos[2]="https://fossbytes.com/wp-content/uploads/2017/01/arch-linux.png";
        arrayPhotos[3]="https://i0.wp.com/opensourceforu.com/wp-content/uploads/2016/12/Ubuntu.jpg?resize=750%2C460";
        arrayPhotos[4]="https://webalia.com/uploads/contenidos_usrs/391576_electro_house_dance_20100913113111.jpg";
        arrayPhotos[5]="http://static2.refinery29.com/bin/entry/dfb/x/424377/electro.jpg";
        arrayPhotos[6]="https://pbs.twimg.com/media/CKSwB1nWcAASMLa.jpg:large";
        arrayPhotos[7]="http://www.noroeste.com.mx/files/tinymce/CuidarComida_(8)2.JPG";
        arrayPhotos[8]="https://professor-falken.com/wp-content/uploads/2016/11/Como-formatear-un-pendrive-o-memoria-USB-desde-el-Terminal-de-Linux-professor-falken.com_.jpg";
        arrayPhotos[9]="http://www.bluent.co.in/blog/images/002.jpg";
        int numero = (int) (Math.random() * 9);

        return arrayPhotos[numero];
    }


    private  String[] arrayPhotos;
    private String title,thumbnailUrl,foto;
    private int id;
}
