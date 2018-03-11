package main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainTest {
    @Test
    public void getName() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        assertEquals("lastochka", test.getName());
    }

    @Test
    public void getEndStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        assertEquals("Moscow", test.getEndStation());
    }

    @Test
    public void getDepartureTime() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        assertEquals(480, test.getDepartureTime());
    }

    @Test
    public void getIntStations() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        test.addIntStation("Kirishi");
        ArrayList<String> value = new ArrayList<>();
        value.add("Kirishi");
        assertEquals(value, test.getIntStations());
    }

    @Test
    public void addIntStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        test.addIntStation("Kirishi");
        ArrayList<String> value = new ArrayList<>();
        value.add("Kirishi");
        assertEquals(value, test.getIntStations());
    }

    @Test
    public void removeIntStation() throws Exception {
        Train test = new Train("lastochka", "Moscow", "8:00");
        test.addIntStation("Kirishi");
        test.addIntStation("SPB");
        test.removeIntStation("SPB");
        ArrayList<String> value = new ArrayList<>();
        value.add("Kirishi");
        assertEquals(value, test.getIntStations());
    }

}