package com.dnowakowski;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CastlesTest {

    private Castles castles;

    @BeforeAll
    void setUp() {
        castles = new Castles();
    }

    @AfterAll
    void tearDown() {
        castles = null;
    }

    @Test
    void testNullStretch() {
        int[] stretch = null;
        int result = castles.countCastles(stretch);
        assertEquals(0,result);
    }

    @Test
    void testEmptyStretch() {
        int[] stretch = {};
        int result = castles.countCastles(stretch);
        assertEquals(0,result);
    }

    @Test
    void testOneElementStretch() {
        int[] stretch = {1};
        int result = castles.countCastles(stretch);
        assertEquals(1,result);
    }

    @Test
    void testInclineOnly() {
        int[] stretch = {1,2,3,4,5};
        int result = castles.countCastles(stretch);
        assertEquals(1,result);
    }

    @Test
    void testDeclineOnly() {
        int[] stretch = {5,4,3,2,1};
        int result = castles.countCastles(stretch);
        assertEquals(1,result);
    }

    @Test
    void testFlatStretch() {
        int[] stretch = {1,1,1,1,1,1,1};
        int result = castles.countCastles(stretch);
        assertEquals(1,result);
    }

    @Test
    void testOnePeek() {
        int[] stretch = {1,2,3,2,1};
        int result = castles.countCastles(stretch);
        assertEquals(2,result);
    }

    @Test
    void testOnePeekWithFlatTop() {
        int[] stretch = {1,2,3,3,3,3,3,3,2,1};
        int result = castles.countCastles(stretch);
        assertEquals(2,result);
    }

    @Test
    void testOneValley() {
        int[] stretch = {5,4,3,5};
        int result = castles.countCastles(stretch);
        assertEquals(2,result);
    }

    @Test
    void testOneValleyWithFlatBottom() {
        int[] stretch = {5,4,3,3,3,3,5};
        int result = castles.countCastles(stretch);
        assertEquals(2,result);
    }

    @Test
    void testSeveralPeeksAndValleys() {
        int[] stretch = {1,5,2,7,3,4,0,2,1,10,1};  //       /\/\/\/\/\
        int result = castles.countCastles(stretch);
        assertEquals(10,result);
    }

    @Test
    void testNegativeValues() {
        int[] stretch = {1,-2,1,-10,0};
        int result = castles.countCastles(stretch);
        assertEquals(4,result);
    }

}