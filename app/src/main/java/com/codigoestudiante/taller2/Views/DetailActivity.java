package com.codigoestudiante.taller2.Views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codigoestudiante.taller2.Adapters.AdapterPhoto;
import com.codigoestudiante.taller2.Connection.HttpManager;
import com.codigoestudiante.taller2.Models.ModelPhoto;
import com.codigoestudiante.taller2.Parser.JsonPhoto;
import com.codigoestudiante.taller2.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button button;
    private RecyclerView recyclerView;
    List<ModelPhoto> modelPhotoList;
    private AdapterPhoto adapterPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = (ProgressBar) findViewById(R.id.id_pb_item_2);
        button = (Button) findViewById(R.id.id_btn_listcountries_2);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item_2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    // Metodo para validar la conexion a internet
    public Boolean isOnLine() {
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        // Validar el estado obtenido de la conexion
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    public void loadData2(View view) {
        if (isOnLine()) {
            TaskCountry2 taskCountry = new TaskCountry2();
            taskCountry.execute("https://jsonplaceholder.typicode.com/photos");
        } else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData() {
        //adapterCountry = new AdapterCountry(countryList, getApplicationContext());
        //recyclerView.setAdapter(adapterCountry);
        adapterPhoto = new AdapterPhoto(modelPhotoList, getApplicationContext());
        recyclerView.setAdapter(adapterPhoto);
    }

    public class TaskCountry2 extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                //countryList = JsonCountry.getData(s);
                modelPhotoList = JsonPhoto.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            processData();

            progressBar.setVisibility(View.GONE);
        }
    }


}
