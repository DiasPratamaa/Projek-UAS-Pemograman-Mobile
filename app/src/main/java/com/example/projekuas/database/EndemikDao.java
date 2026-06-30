package com.example.projekuas.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EndemikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EndemikEntity> list);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EndemikEntity item);

    @Update
    void update(EndemikEntity item);

    @Query("SELECT * FROM endemik")
    List<EndemikEntity> getAll();

    @Query("SELECT * FROM endemik WHERE tipe='Hewan'")
    List<EndemikEntity> getHewan();

    @Query("SELECT * FROM endemik WHERE tipe='Tumbuhan'")
    List<EndemikEntity> getTumbuhan();

    @Query("SELECT * FROM endemik WHERE favorite=1")
    List<EndemikEntity> getFavorite();

    @Query("SELECT COUNT(*) FROM endemik")
    int getCount();
    @Query("SELECT * FROM endemik WHERE id=:id")
    EndemikEntity getById(String id);
    @Query("UPDATE endemik SET favorite = :favorite WHERE id = :id")
    void updateFavorite(String id, boolean favorite);
    @Query("SELECT * FROM endemik WHERE tipe = :tipe AND asal LIKE '%' || :region || '%'")
    List<EndemikEntity> getByRegion(String tipe, String region);
    @Query("SELECT * FROM endemik WHERE tipe = :tipe")
    List<EndemikEntity> getByTipe(String tipe);

}