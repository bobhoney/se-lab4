package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        boolean result = ship.fireTorpedo(FiringMode.ALL);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_Alternating() {
        ship.fireTorpedo(FiringMode.SINGLE);
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_PrimaryEmpty() {
        GT4500 emptyPrimary = new GT4500(0, 0, 10, 0);
        boolean result = emptyPrimary.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_SecondaryEmpty() {
        GT4500 emptySecondary = new GT4500(10, 0, 0, 0);
        emptySecondary.fireTorpedo(FiringMode.SINGLE);
        boolean result = emptySecondary.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_Single_BothEmpty() {
        GT4500 bothEmpty = new GT4500(0, 0, 0, 0);
        boolean result = bothEmpty.fireTorpedo(FiringMode.SINGLE);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_All_PrimaryEmpty() {
        GT4500 emptyPrimary = new GT4500(0, 0, 10, 0);
        boolean result = emptyPrimary.fireTorpedo(FiringMode.ALL);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_SecondaryEmpty() {
        GT4500 emptySecondary = new GT4500(10, 0, 0, 0);
        boolean result = emptySecondary.fireTorpedo(FiringMode.ALL);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_BothEmpty() {
        GT4500 bothEmpty = new GT4500(0, 0, 0, 0);
        boolean result = bothEmpty.fireTorpedo(FiringMode.ALL);
        assertEquals(false, result);
    }

    @Test
    void fireLaser_ReturnsFalse() {
        boolean result = ship.fireLaser(FiringMode.SINGLE);
        assertEquals(false, result);
    }
}