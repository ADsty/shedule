package main;

import java.util.ArrayList;

public class Train {
    private String name;
    private String endStation;
    private String departureTime;
    private ArrayList<String> intStations;
    /**
     * TODO: Add to all methods catching of exceptions
     */
    public String getName() {
        return name;
    }

    public String getEndStation() {
        return endStation;
    }

    /**
     * @return departure time of the selected train in a minutes
     * Time must be written in the form XX:XX
     */
    public int getDepartureTime() {
        int time = 0;
        String[] parts = departureTime.split(":");
        for (String part : parts) {
            int number = Integer.parseInt(part);
            time = time * 60 + number;
        }
        return time;
    }

    public ArrayList<String> getIntStations() {
        return intStations;
    }

    /**
     * @param intStation is the name of the station you want to add
     */
    public void addIntStation(String intStation) {
        intStations.add(intStation);
    }

    public void removeIntStation(String intStation) {
        for (String t : intStations) {
            if (t.equals(intStation)) {
                intStations.remove(t);
                break;
            }
        }
    }

    /**
     * @param name          is the name of the train
     * @param endStation    is the station to which the train is going
     * @param departureTime is the time when the train departs from the initial station
     *                      Creates a new empty list of intermediate stations
     */
    public Train(String name, String endStation, String departureTime) {
        this.name = name;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.intStations = new ArrayList<>();
    }
}