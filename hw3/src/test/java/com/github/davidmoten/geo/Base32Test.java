package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Base32Test {

    public static final long MAX_LONG_DECODE = 9223372036854775807L ;
    public static final long MIN_LONG_DECODE = -9223372036854775807L ;
    public static final String MAX_LONG_ENCODE = "7zzzzzzzzzzzz" ;
    public static final String MIN_LONG_ENCODE = "-7zzzzzzzzzzzz" ;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encodeBase32() throws Exception {
        String encode_max = Base32.encodeBase32(MAX_LONG_DECODE);
        String encode_min = Base32.encodeBase32(MIN_LONG_DECODE);
        assertEquals(MAX_LONG_ENCODE, encode_max);
        assertEquals(MIN_LONG_ENCODE, encode_min);
    }

    @Test
    public void encodeBase32hasLength() throws Exception {
        String encode_max = Base32.encodeBase32(MAX_LONG_DECODE, 12);
        String encode_min = Base32.encodeBase32(MIN_LONG_DECODE, 13);
        String encode_neg = Base32.encodeBase32(-31, 13);

        assertEquals(MAX_LONG_ENCODE, encode_max);
        assertEquals(MIN_LONG_ENCODE, encode_min);
        assertEquals("-000000000000z", encode_neg);
    }

    @Test
    public void decodeBase32() throws Exception {
        long decode_max = Base32.decodeBase32(MAX_LONG_ENCODE);
        long decode_min = Base32.decodeBase32(MIN_LONG_ENCODE);
        long decode_null = Base32.decodeBase32("");
        assertEquals(MAX_LONG_DECODE, decode_max);
        assertEquals(MIN_LONG_DECODE, decode_min);
        assertEquals(0,decode_null);
    }

    @Test
    public void getCharIndex() throws Exception {
        int index_max = Base32.getCharIndex('z');
        int index_min = Base32.getCharIndex('0');
        assertEquals(31, index_max);
        assertEquals(0, index_min);
    }

    @Test
    public void padLeftWithZerosToLength() throws Exception {
        String padWord = Base32.padLeftWithZerosToLength("a",2);
        String padMax = Base32.padLeftWithZerosToLength(MAX_LONG_ENCODE,3);
        String padMin = Base32.padLeftWithZerosToLength(MIN_LONG_ENCODE,3);
        assertEquals("0a", padWord);
        assertEquals("7zzzzzzzzzzzz", padMax);
        assertEquals("-7zzzzzzzzzzzz", padMin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void decodeBase32Exception() throws Exception {
        long decodeException = Base32.decodeBase32(" ");
    }

}