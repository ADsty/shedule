package main;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;


public class SheduleTest {
    @Test
    public void findTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        assertEquals(testFirst, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notFindTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.findTrain("SPB", LocalTime.of(7, 45, 0, 0));
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
        Train testFirst = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        Train testSecond = new Train("sokol", "NY", LocalTime.of(9, 0, 0, 0));
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        t.removeTrain("sokol");
        assertEquals(testFirst, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
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
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("SPB");
        t.addNewTrain(test);
        assertEquals(test, t.findTrain("Moscow", LocalTime.of(7, 45, 0, 0)));
    }
}