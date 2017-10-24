package com.codigoestudiante.taller2.Parser;

import com.codigoestudiante.taller2.Models.ModelPhoto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/10/17.
 */
public class JsonPhoto {

    public static List<ModelPhoto> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<ModelPhoto> modelPhotoList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);
            ModelPhoto modelPhoto = new ModelPhoto();
            modelPhoto.setTitle(item.getString("title"));
            modelPhoto.setThumbnailUrl(item.getString("thumbnailUrl"));
            modelPhoto.setFoto(item.getString("url"));
            modelPhoto.setId(item.getInt("id"));
            modelPhotoList.add(modelPhoto);
        }
        return modelPhotoList;
    }

}
