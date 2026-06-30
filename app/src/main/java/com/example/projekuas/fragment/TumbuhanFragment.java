package com.example.projekuas.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekuas.R;
import com.example.projekuas.activity.DetailActivity;
import com.example.projekuas.adapter.EndemikAdapter;
import com.example.projekuas.database.EndemikEntity;
import com.example.projekuas.repository.EndemikRepository;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class TumbuhanFragment extends Fragment {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private ChipGroup chipGroup;

    private EndemikRepository repository;
    private EndemikAdapter adapter;

    private List<EndemikEntity> currentList = new ArrayList<>();

    private String currentRegion = "Semua";

    public TumbuhanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tumbuhan, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerTumbuhan);
        searchView = view.findViewById(R.id.searchView);
        chipGroup = view.findViewById(R.id.chipGroupTumbuhan);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        repository = new EndemikRepository(requireContext());

        currentList = repository.getTumbuhan();

        adapter = new EndemikAdapter(currentList, item -> {

            Intent intent = new Intent(getContext(), DetailActivity.class);

            intent.putExtra("id", item.id);

            startActivity(intent);

        });

        recyclerView.setAdapter(adapter);

        // ==========================
        // FILTER REGION
        // ==========================

        chipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {

            if (checkedIds.isEmpty()) return;

            int id = checkedIds.get(0);

            if (id == R.id.chipSemua) {

                currentRegion = "Semua";

            } else if (id == R.id.chipSumatra) {

                currentRegion = "Sumatera";

            } else if (id == R.id.chipJawa) {

                currentRegion = "Jawa";

            } else if (id == R.id.chipKalimantan) {

                currentRegion = "Kalimantan";

            } else if (id == R.id.chipSulawesi) {

                currentRegion = "Sulawesi";

            } else if (id == R.id.chipPapua) {

                currentRegion = "Papua";

            } else if (id == R.id.chipMaluku) {

                currentRegion = "Maluku";

            }

            loadRegion();

            filterSearch(searchView.getQuery().toString());

        });

        // ==========================
        // SEARCH
        // ==========================

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                filterSearch(query);

                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterSearch(newText);

                return true;

            }

        });

    }

    // ==========================
    // LOAD DATA BERDASARKAN REGION
    // ==========================

    private void loadRegion() {

        if (currentRegion.equals("Semua")) {

            currentList = repository.getTumbuhan();

        } else {

            currentList = repository.getByRegion("Tumbuhan", currentRegion);

        }

    }

    // ==========================
    // SEARCH
    // ==========================

    private void filterSearch(String keyword) {

        keyword = keyword.toLowerCase().trim();

        if (keyword.isEmpty()) {

            adapter.updateData(currentList);

            return;

        }

        List<EndemikEntity> hasil = new ArrayList<>();

        for (EndemikEntity item : currentList) {

            boolean cocokNama =
                    item.nama != null &&
                            item.nama.toLowerCase().contains(keyword);

            boolean cocokLatin =
                    item.nama_latin != null &&
                            item.nama_latin.toLowerCase().contains(keyword);

            boolean cocokFamili =
                    item.famili != null &&
                            item.famili.toLowerCase().contains(keyword);

            boolean cocokGenus =
                    item.genus != null &&
                            item.genus.toLowerCase().contains(keyword);

            if (cocokNama ||
                    cocokLatin ||
                    cocokFamili ||
                    cocokGenus) {

                hasil.add(item);

            }

        }

        adapter.updateData(hasil);

    }

}