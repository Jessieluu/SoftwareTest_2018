package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LatLongTest {
    LatLong latlong;
    LatLong new_latlong;
    LatLong add_latlong;

    @Before
    public void setUp() throws Exception {
        latlong = new LatLong(25.0438905,121.53485130000001);
        new_latlong = new LatLong(29.0438905,129.53485130000001);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getLat() throws Exception {
        double lat = latlong.getLat();
        assertEquals(25.0438905, lat,0);
    }

    @Test
    public void getLon() throws Exception {
        double lon = latlong.getLon();
        assertEquals(121.53485130000001, lon,0);
    }

    @Test
    public void add() throws Exception {
        add_latlong = latlong.add(4,8);
        assertEquals(new_latlong.getLat(),add_latlong.getLat(),0);
        assertEquals(new_latlong.getLon(),add_latlong.getLon(),0);
    }

}