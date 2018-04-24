package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoverageLongsTest {
    CoverageLongs cl;
    long[] hash = {1234};
    long[] newHash;

    @Before
    public void setUp() throws Exception {
        cl = new CoverageLongs(hash, 1, 2);
        newHash = cl.getHashes();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getHashes() throws Exception {
        assertArrayEquals(newHash, hash);
    }

    @Test
    public void getRatio() throws Exception {
        assertEquals(cl.getRatio(), 2, 1);
    }

    @Test
    public void getHashLength() throws Exception {
        assertEquals(cl.getHashLength(), 2);
    }

    @Test
    public void getCount() throws Exception {
        assertEquals(cl.getCount(), 1);
    }

}