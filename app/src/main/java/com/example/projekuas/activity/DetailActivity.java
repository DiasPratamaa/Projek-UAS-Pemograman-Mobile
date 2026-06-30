package com.example.projekuas.activity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.projekuas.util.ThemeHelper;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.projekuas.R;
import com.example.projekuas.database.EndemikEntity;
import com.example.projekuas.repository.EndemikRepository;

public class DetailActivity extends AppCompatActivity {

    private ImageButton btnBack, btnFavorite;
    private ImageView imgFoto;

    private TextView txtJudul;
    private TextView txtLatin;
    private TextView txtFamili;
    private TextView txtGenus;
    private TextView txtAsal;
    private TextView txtSebaran;
    private TextView txtStatus;
    private TextView txtDeskripsi;

    private EndemikRepository repository;
    private EndemikEntity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // =====================
        // Inisialisasi View
        // =====================

        btnBack = findViewById(R.id.btnBack);
        btnFavorite = findViewById(R.id.btnFavorite);

        imgFoto = findViewById(R.id.imgFoto);

        txtJudul = findViewById(R.id.txtJudul);
        txtLatin = findViewById(R.id.txtLatin);
        txtFamili = findViewById(R.id.txtFamili);
        txtGenus = findViewById(R.id.txtGenus);
        txtAsal = findViewById(R.id.txtAsal);
        txtSebaran = findViewById(R.id.txtSebaran);
        txtStatus = findViewById(R.id.txtStatus);
        txtDeskripsi = findViewById(R.id.txtDeskripsi);

        // =====================
        // Repository
        // =====================

        repository = new EndemikRepository(this);

        String id = getIntent().getStringExtra("id");

        if (id == null) {
            finish();
            return;
        }

        data = repository.getById(id);

        if (data == null) {
            finish();
            return;
        }

        tampilkanData();

        // =====================
        // Tombol Back
        // =====================

        btnBack.setOnClickListener(v -> finish());

        // =====================
        // Tombol Favorite
        // =====================

        btnFavorite.setOnClickListener(v -> {

            data.favorite = !data.favorite;

            repository.updateFavorite(data.id, data.favorite);

            updateFavoriteIcon();

            if (data.favorite) {

                Toast.makeText(
                        DetailActivity.this,
                        "Ditambahkan ke Favorit",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        DetailActivity.this,
                        "Dihapus dari Favorit",
                        Toast.LENGTH_SHORT
                ).show();

            }

        });

    }

    private void tampilkanData() {

        txtJudul.setText(data.nama);
        txtLatin.setText("Nama Latin : " + data.nama_latin);
        txtFamili.setText("Famili : " + data.famili);
        txtGenus.setText("Genus : " + data.genus);
        txtAsal.setText("Asal : " + data.asal);
        txtSebaran.setText("Sebaran : " + data.sebaran);
        txtStatus.setText("Status : " + data.status);
        txtDeskripsi.setText(data.deskripsi);

        Glide.with(this)
                .load(data.foto)
                .into(imgFoto);

        updateFavoriteIcon();

    }

    private void updateFavoriteIcon() {

        if (data.favorite) {

            btnFavorite.setImageResource(R.drawable.ic_favorite);

        } else {

            btnFavorite.setImageResource(R.drawable.ic_favorite_border);

        }

    }

}