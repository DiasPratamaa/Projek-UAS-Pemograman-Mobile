package com.example.projekuas.model;

import com.google.gson.annotations.SerializedName;

public class endemik {

    @SerializedName("id")
    private String id;

    @SerializedName("tipe")
    private String tipe;

    @SerializedName("nama")
    private String nama;

    @SerializedName("nama_latin")
    private String namaLatin;

    @SerializedName("famili")
    private String famili;

    @SerializedName("genus")
    private String genus;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("asal")
    private String asal;

    @SerializedName("sebaran")
    private String sebaran;

    @SerializedName("foto")
    private String foto;

    @SerializedName("sumber_foto")
    private String sumberFoto;

    @SerializedName("vidio")
    private String vidio;

    @SerializedName("sumber_vidio")
    private String sumberVidio;

    @SerializedName("status")
    private String status;

    public endemik() {
    }

    public String getId() {
        return id;
    }

    public String getTipe() {
        return tipe;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaLatin() {
        return namaLatin;
    }

    public String getFamili() {
        return famili;
    }

    public String getGenus() {
        return genus;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getAsal() {
        return asal;
    }

    public String getSebaran() {
        return sebaran;
    }

    public String getFoto() {
        return foto;
    }

    public String getSumberFoto() {
        return sumberFoto;
    }

    public String getVidio() {
        return vidio;
    }

    public String getSumberVidio() {
        return sumberVidio;
    }

    public String getStatus() {
        return status;
    }

}