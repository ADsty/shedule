package main;

import org.junit.Before;

import org.junit.Test;

import java.time.LocalTime;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SheduleTest {
    private Shedule t;
    private ArrayList<Train> forComparison;
    private Train testFirst;

    @Before
    public void creatingNewElements() {
        t = new Shedule();
        forComparison = new ArrayList<>();
        testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
    }

    @Test
    public void findTrain() {
        Train testThird = new Train("T600", "Moscow", LocalTime.of(7, 47, 0, 0));
        t.addNewTrain(testThird);
        forComparison.add(testThird);
        assertEquals(forComparison, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }

    @Test
    public void findWrongTrain() {
        assertEquals(forComparison, t.findTrain("Kirishi", LocalTime.of(7, 45, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataFindTrain() {
        t.findTrain("/*/*//=-=", LocalTime.of(7, 45, 0, 0));
    }

    @Test
    public void removeTrain() {
        t.removeTrain("sokol");
        assertEquals(forComparison, t.findTrain("NY", LocalTime.of(7, 45, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataRemoveTrain() {
        t.removeTrain("*/*/*//-=-=");
    }

    @Test
    public void addNewTrain() {
        testFirst.addIntStation("SPB");
        forComparison.add(testFirst);
        assertEquals(forComparison, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }
}