package com.chenlm.test.jpa.geo;

import com.chenlm.jpa.geo.GeoEntityListener;
import com.chenlm.jpa.geo.Point;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(GeoEntityListener.class)
public class TestEntity implements Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private Double lon;
    private Double lat;
    private String geoCode;

}
