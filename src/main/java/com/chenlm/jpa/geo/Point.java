package com.chenlm.jpa.geo;

public interface Point {

    void setLat(Double lat);
    Double getLat();
    void setLon(Double lon);
    Double getLon();
    void setGeoCode(String geoCode);
    String getGeoCode();
}

