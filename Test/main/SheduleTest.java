package main;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class SheduleTest {
    @Test
    public void findTrain() {
        Shedule t = new Shedule();
        ArrayList<Train> forComparison = new ArrayList<>();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        forComparison.add(testFirst);
        assertEquals(forComparison, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }

    @Test
    public void findWrongTrain() {
        Shedule t = new Shedule();
        ArrayList<Train> forComparison = new ArrayList<>();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        assertEquals(forComparison, t.findTrain("Kirishi", LocalTime.of(7, 45, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataFindTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.findTrain("/*/*//=-=", LocalTime.of(7, 45, 0, 0));
    }

    @Test
    public void removeTrain() {
        Shedule t = new Shedule();
        ArrayList<Train> forComparison = new ArrayList<>();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        t.removeTrain("sokol");
        forComparison.add(testFirst);
        assertEquals(forComparison, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataRemoveTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.removeTrain("*/*/*//-=-=");
    }

    @Test
    public void addNewTrain() {
        Shedule t = new Shedule();
        ArrayList<Train> forComparison = new ArrayList<>();
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("SPB");
        t.addNewTrain(test);
        forComparison.add(test);
        assertEquals(forComparison, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }
}