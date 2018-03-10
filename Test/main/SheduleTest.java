package main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SheduleTest {
    @Test
    public void findTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka" , "Moscow" ,"8:00");
        Train testSecond = new Train("sokol" , "NY" , "9:00");
        testFirst.addIntStation("SPB");
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        assertEquals(testFirst , t.findTrain("Moscow" , "7:45" , "SPB"));
    }

    @Test
    public void removeTrain() {
        Shedule t = new Shedule();
        Train testFirst = new Train("lastochka" , "Moscow" ,"8:00");
        Train testSecond = new Train("sokol" , "NY" , "9:00");
        testFirst.addIntStation("SPB");
        t.addNewTrain(testFirst);
        t.addNewTrain(testSecond);
        t.removeTrain("sokol");
        assertEquals(testFirst , t.findTrain("Moscow" , "7:45" , "SPB"));
    }
    @Test
    public void addNewTrain() {
        Shedule t = new Shedule();
        Train test = new Train("lastochka" , "Moscow" , "8:00");
        test.addIntStation("SPB");
        t.addNewTrain(test);
        assertEquals(test , t.findTrain("Moscow" , "7:45" , "SPB"));
    }
}