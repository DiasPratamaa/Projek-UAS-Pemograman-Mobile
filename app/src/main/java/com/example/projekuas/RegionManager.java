package com.example.projekuas.util;

public class RegionManager {

    private static String currentRegion = "Semua";

    public static void setRegion(String region){
        currentRegion = region;
    }

    public static String getRegion(){
        return currentRegion;
    }

}