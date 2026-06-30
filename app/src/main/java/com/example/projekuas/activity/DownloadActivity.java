package com.example.projekuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projekuas.R;
import com.example.projekuas.api.ApiClient;
import com.example.projekuas.api.ApiService;
import com.example.projekuas.database.EndemikEntity;
import com.example.projekuas.model.endemik;
import com.example.projekuas.repository.EndemikRepository;

import java.util.ArrayList;
import java.util.List;
import com.example.projekuas.util.ThemeHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;import com.example.projekuas.util.ThemeHelper;

public class DownloadActivity extends AppCompatActivity {

    private EndemikRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        repository = new EndemikRepository(this);

        if(repository.getCount() > 0){

            openHome();

        }else{

            downloadData();

        }

    }

    private void downloadData(){

        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);

        apiService.getData().enqueue(new Callback<List<endemik>>() {

            @Override
            public void onResponse(Call<List<endemik>> call,
                                   Response<List<endemik>> response) {

                if(response.isSuccessful() && response.body()!=null){

                    List<EndemikEntity> entities =
                            new ArrayList<>();

                    for(endemik item : response.body()){

                        EndemikEntity entity =
                                new EndemikEntity();

                        entity.id = item.getId();
                        entity.tipe = item.getTipe();
                        entity.nama = item.getNama();
                        entity.nama_latin = item.getNamaLatin();
                        entity.famili = item.getFamili();
                        entity.genus = item.getGenus();
                        entity.deskripsi = item.getDeskripsi();
                        entity.asal = item.getAsal();
                        entity.sebaran = item.getSebaran();
                        entity.foto = item.getFoto();
                        entity.sumber_foto = item.getSumberFoto();
                        entity.vidio = item.getVidio();
                        entity.sumber_vidio = item.getSumberVidio();
                        entity.status = item.getStatus();

                        entity.favorite = false;

                        entities.add(entity);

                    }

                    repository.insertAll(entities);

                    Toast.makeText(
                            DownloadActivity.this,
                            "Data berhasil disimpan",
                            Toast.LENGTH_SHORT
                    ).show();

                    openHome();

                }else{

                    Toast.makeText(
                            DownloadActivity.this,
                            "Gagal mengambil data",
                            Toast.LENGTH_SHORT
                    ).show();

                }

            }

            @Override
            public void onFailure(Call<List<endemik>> call,
                                  Throwable t) {

                Toast.makeText(
                        DownloadActivity.this,
                        t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();

            }

        });

    }

    private void openHome(){

        Intent intent =
                new Intent(
                        DownloadActivity.this,
                        HomeActivity.class
                );

        startActivity(intent);

        finish();

    }

}