package com.github.davidmoten.geo;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base32Test {


    @Test
    public void encodeBase32() throws Exception {
        String encode = Base32.encodeBase32(75324, 4);
        assertNotNull(encode);
        assertEquals("29jw", encode);
    }

    @Test
    public void decodeBase32() throws Exception {
        long decode = Base32.decodeBase32("29jw");
        assertNotNull(decode);
        assertEquals(75324, decode);
    }

    @Test
    public void getCharIndex() throws Exception{
        int index = Base32.getCharIndex('3');
        assertNotNull(index);
        assertEquals(3,index);
    }
}