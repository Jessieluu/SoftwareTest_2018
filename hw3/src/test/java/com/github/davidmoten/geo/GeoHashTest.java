package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GeoHashTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void adjacentHashIsEmpty() throws Exception {
        GeoHash.adjacentHash("", Direction.TOP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adjacentHashIsNull() throws Exception {
        GeoHash.adjacentHash(null, Direction.TOP);
    }

    @Test
    public void adjacentHash() throws Exception {
        assertEquals("ioasdim", GeoHash.adjacentHash("ioasdik", Direction.RIGHT));
        assertEquals("wkngj31g", GeoHash.adjacentHash("wkngj345", Direction.LEFT));
    }

    @Test
    public void adjacentHash_TOP() throws Exception {
        assertEquals("ae99", GeoHash.adjacentHash("ae98", Direction.TOP));
    }

    @Test
    public void adjacentHash_BOTTOM() throws Exception {
        assertEquals("ae3x", GeoHash.adjacentHash("ae98", Direction.BOTTOM));
    }

    @Test
    public void adjacentHash_LEFT() throws Exception {
        assertEquals("ae92", GeoHash.adjacentHash("ae98", Direction.LEFT));
    }

    @Test
    public void adjacentHash_RIGHT() throws Exception {
        assertEquals("ae9b", GeoHash.adjacentHash("ae98", Direction.RIGHT));
    }

    @Test
    public void neighbours() throws Exception {
        List<String> neighbourslist = GeoHash.neighbours("ae98");
        assertEquals("ae92", neighbourslist.get(0));
        assertEquals("ae9b", neighbourslist.get(1));
        assertEquals("ae99", neighbourslist.get(2));
        assertEquals("ae3x", neighbourslist.get(3));
        assertEquals("ae93", neighbourslist.get(4));
        assertEquals("ae3r", neighbourslist.get(5));
        assertEquals("ae9c", neighbourslist.get(6));
        assertEquals("ae3z", neighbourslist.get(7));

    }

    @Test(expected = IllegalArgumentException.class)
    public void neighbours_Null() throws Exception {
        List<String> neighbourslist = GeoHash.neighbours(null);
        assertEquals("ae92", neighbourslist.get(0));
        assertEquals("ae9b", neighbourslist.get(1));
        assertEquals("ae99", neighbourslist.get(2));
        assertEquals("ae3x", neighbourslist.get(3));
        assertEquals("ae93", neighbourslist.get(4));
        assertEquals("ae3r", neighbourslist.get(5));
        assertEquals("ae9c", neighbourslist.get(6));
        assertEquals("ae3z", neighbourslist.get(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void neighbours_Empty() throws Exception {
        List<String> neighbourslist = GeoHash.neighbours("");
        assertEquals("ae92", neighbourslist.get(0));
        assertEquals("ae9b", neighbourslist.get(1));
        assertEquals("ae99", neighbourslist.get(2));
        assertEquals("ae3x", neighbourslist.get(3));
        assertEquals("ae93", neighbourslist.get(4));
        assertEquals("ae3r", neighbourslist.get(5));
        assertEquals("ae9c", neighbourslist.get(6));
        assertEquals("ae3z", neighbourslist.get(7));
    }


    @Test
    public void encodeHash() throws Exception {
        String encodehash = GeoHash.encodeHash(0, 180, 3);
        String encodehashMax = GeoHash.encodeHash(90, 180,3);
        String encodehashMin = GeoHash.encodeHash(-90, 180, 3);
        assertEquals("xbp", encodehash);
        assertEquals("zzz", encodehashMax);
        assertEquals("pbp", encodehashMin);
    }

    @Test
    public void fromLongToString() throws Exception {
    }

    @Test
    public void fromLongToString_NegativeMin() throws Exception {
        assertEquals("h", GeoHash.fromLongToString(-9223372036854775807L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromLongToString_HashIsZero() throws Exception {
        assertEquals("1234", GeoHash.fromLongToString(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void fromLongToString_PositiveMax() throws Exception {
        assertEquals("gzzzzzzzzzzz", GeoHash.fromLongToString(9223372036854775807L));
    }


    @Test
    public void encodeHashToLong() throws Exception {
        long encodehash = GeoHash.encodeHashToLong(0, 180, 3);
        long encodehashMax = GeoHash.encodeHashToLong(90, 180,3);
        long encodehashMin = GeoHash.encodeHashToLong(-90, 180, 3);
        assertEquals(-1537416322793603069L, encodehash);
        assertEquals(-562949953421309L, encodehashMax);
        assertEquals(-6149102341220990973L, encodehashMin);
    }

    @Test
    public void decodeHash() throws Exception {
        LatLong latLong = GeoHash.decodeHash("7zzzzzzzzzzzz");
        assertEquals(-2.0954757928848267E-8, latLong.getLat(), 1);
        assertEquals(-2.0954757928848267E-8, latLong.getLon(), 1);
    }

    @Test
    public void heightDegrees() throws Exception {
        double hd = GeoHash.heightDegrees(12);
        assertEquals(1.6763806343078613E-7, hd, 1);
    }

    @Test
    public void heightDegrees_overMaxDegree() throws Exception {
        double hd = GeoHash.heightDegrees(13);
        assertEquals(1.6763806343078613E-7, hd, 1);
    }

    @Test
    public void widthDegrees() throws Exception {
        double hd = GeoHash.widthDegrees(12);
        assertEquals(3.3527612686157227E-7, hd, 1);
    }

    @Test
    public void widthDegrees_overMaxDegree() throws Exception {
        double hd = GeoHash.widthDegrees(13);
        assertEquals(3.3527612686157227E-7, hd, 1);
    }

}