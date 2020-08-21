package com.chenlm.jpa.geo;

import ch.hsr.geohash.GeoHash;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GeoEntityListener {

    @PrePersist
    @PreUpdate
    public void setGeoCode(Object point) {
        if (point instanceof Point) {
            ((Point) point).setGeoCode(
                    GeoHash.withCharacterPrecision(((Point) point).getLat(), ((Point) point).getLon(), 10)
                            .toBase32()
            );
        }
    }
}
