package com.example.projekuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projekuas.util.ThemeHelper;
import com.example.projekuas.R;
import com.example.projekuas.adapter.EndemikAdapter;
import com.example.projekuas.database.EndemikEntity;
import com.example.projekuas.repository.EndemikRepository;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton btnBack;

    private EndemikRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recyclerView = findViewById(R.id.rvFavorite);
        btnBack = findViewById(R.id.btnBack);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repository = new EndemikRepository(this);

        List<EndemikEntity> list = repository.getFavorite();

        EndemikAdapter adapter =
                new EndemikAdapter(list, item -> {

                    Intent intent =
                            new Intent(
                                    FavoriteActivity.this,
                                    DetailActivity.class
                            );

                    intent.putExtra("id", item.id);

                    startActivity(intent);

                });

        recyclerView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

    }

    @Override
    protected void onResume() {
        ThemeHelper.applyTheme(this);
        super.onResume();

        List<EndemikEntity> list = repository.getFavorite();

        recyclerView.setAdapter(
                new EndemikAdapter(list, item -> {

                    Intent intent =
                            new Intent(
                                    FavoriteActivity.this,
                                    DetailActivity.class
                            );

                    intent.putExtra("id", item.id);

                    startActivity(intent);

                })
        );

    }

}