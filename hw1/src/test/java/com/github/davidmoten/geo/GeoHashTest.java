package com.github.davidmoten.geo;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeoHashTest {
    @Test
    public void right() throws Exception {
        String right = GeoHash.right("12");
        assertNotNull(right);
        assertEquals("18", right);
    }

    @Test
    public void left() throws Exception {
        String left = GeoHash.left("13");
        assertNotNull(left);
        assertEquals("11", left);
    }

    @Test
    public void top() throws Exception {
        String top = GeoHash.top("15");
        assertNotNull(top);
        assertEquals("1h", top);
    }

    @Test
    public void bottom() throws Exception {
        String bottom = GeoHash.bottom("20");
        assertNotNull(bottom);
        assertEquals("0p", bottom);
    }

    @Test
    public void encodeHash() throws Exception {
        String encode = GeoHash.encodeHash(10,20);
        assertNotNull(encode);
        assertEquals("s3y0zh7w1z0g", encode);
    }

    @Test
    public void decodeHash() throws Exception {
        LatLong decode = GeoHash.decodeHash("abc");
        double delta = 0.002;
        assertNotNull(decode);
        assertEquals(49.921875, decode.getLat(), delta);
        assertEquals(170.859375, decode.getLon(), delta);

    }

}