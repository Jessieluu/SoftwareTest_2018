package com.github.davidmoten.geo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CoverageTest {
    @Test
    public void getHashes() throws Exception {
        Set<String> coverage = new HashSet<String>(100);
        coverage.add("123");
        coverage.add("456");

        Coverage cov = new Coverage(coverage, 10);
        assertNotNull(cov);
        assertEquals(coverage, cov.getHashes());
    }

    @Test
    public void getRatio() throws Exception {
        Set<String> coverage = new HashSet<String>(100);
        coverage.add("12");
        coverage.add("34");

        Coverage cov = new Coverage(coverage, 10);
        double delta = 0.002;
        assertNotNull(cov);
        assertEquals(10.0, cov.getRatio(), delta);
    }

    @Test
    public void getHashLength() throws Exception {
        Set<String> coverage = new HashSet<String>(100);
        coverage.add("12");
        coverage.add("34");

        Coverage cov = new Coverage(coverage, 10);
        assertNotNull(cov);
        assertEquals(2, cov.getHashLength());
    }

}