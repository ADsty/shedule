package main;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainTest {
    @Test
    public void getName() throws Exception {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        assertEquals("lastochka", test.getName());
    }

    @Test
    public void getEndStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        assertEquals("Moscow", test.getEndStation());
    }

    @Test
    public void getDepartureTime() throws Exception {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        assertEquals(LocalTime.of(8, 0, 0, 0), test.getDepartureTime());
    }


    @Test
    public void addIntStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("Kirishi");
        test.addIntStation("NY");
        ArrayList<String> value = new ArrayList<>();
        value.add("Kirishi");
        value.add("NY");
        assertEquals(value, test.getIntStations());
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataAddIntStation() {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sameStations() {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("Kirishi");
        test.addIntStation("Kirishi");
    }

    @Test
    public void removeIntStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("Kirishi");
        test.addIntStation("SPB");
        test.removeIntStation("SPB");
        ArrayList<String> value = new ArrayList<>();
        value.add("Kirishi");
        assertEquals(value, test.getIntStations());
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataRemoveIntStation() {
        Train test = new Train("lastochka", "Moscow", LocalTime.of(8, 0, 0, 0));
        test.addIntStation("Kirishi");
        test.addIntStation("SPB");
        test.removeIntStation("*/*-**-/-*-*-*");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongDataTrain() {
        Train t = new Train("=*/-=*--*-*", "/*-*/", LocalTime.of(8, 0, 0, 0));
    }
}