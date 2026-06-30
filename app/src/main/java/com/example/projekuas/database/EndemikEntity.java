package com.example.projekuas.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "endemik")
public class EndemikEntity {

    @PrimaryKey
    @NonNull
    public String id;

    @ColumnInfo(name = "favorite")
    public boolean favorite;
    public String tipe;

    public String nama;

    public String nama_latin;

    public String famili;

    public String genus;

    public String deskripsi;

    public String asal;

    public String sebaran;

    public String foto;

    public String sumber_foto;

    public String vidio;

    public String sumber_vidio;

    public String status;


}