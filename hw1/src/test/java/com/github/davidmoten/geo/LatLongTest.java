package com.github.davidmoten.geo;

import org.junit.Test;

import static org.junit.Assert.*;

public class LatLongTest {

    @Test
    public void getLat() throws Exception {
        LatLong latlong = new LatLong(2.3, 3.7);
        double lat = latlong.getLat();
        double delta = 0.002;
        assertNotNull(lat);
        assertEquals(2.3, lat, delta);
    }

    @Test
    public void getLon() throws Exception {
        LatLong latlong = new LatLong(2.3, 3.7);
        double lon = latlong.getLon();
        double delta = 0.002;
        assertNotNull(lon);
        assertEquals(3.7, lon, delta);
    }

    @Test
    public void add() throws Exception {
        LatLong latlong = new LatLong(2.3, 3.7);
        LatLong latlong_new = latlong.add(0.5, 0.7);
        double lat = latlong_new.getLat();
        double lon = latlong_new.getLon();
        double delta = 0.002;
        assertNotNull(lat);
        assertNotNull(lon);
        assertEquals(2.8, lat, delta);
        assertEquals(4.4, lon, delta);
    }


}