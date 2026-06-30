package com.example.projekuas.repository;

import android.content.Context;

import com.example.projekuas.database.AppDatabase;
import com.example.projekuas.database.EndemikDao;
import com.example.projekuas.database.EndemikEntity;

import java.util.List;

public class EndemikRepository {

    private final EndemikDao dao;

    public EndemikRepository(Context context){

        dao = AppDatabase
                .getDatabase(context)
                .endemikDao();

    }

    public void insertAll(List<EndemikEntity> list){

        dao.insertAll(list);

    }

    public void update(EndemikEntity item){

        dao.update(item);

    }

    public List<EndemikEntity> getAll(){

        return dao.getAll();

    }

    public List<EndemikEntity> getHewan(){

        return dao.getHewan();

    }

    public List<EndemikEntity> getTumbuhan(){

        return dao.getTumbuhan();

    }

    public List<EndemikEntity> getFavorite(){

        return dao.getFavorite();

    }

    public int getCount(){

        return dao.getCount();

    }

    public EndemikEntity getById(String id){

        return dao.getById(id);

    }

    public void updateFavorite(String id, boolean favorite) {
        dao.updateFavorite(id, favorite);
    }
    public List<EndemikEntity> getByRegion(String tipe, String region){

        return dao.getByRegion(tipe, region);

    }

    public List<EndemikEntity> getByTipe(String tipe){

        return dao.getByTipe(tipe);

    }



}