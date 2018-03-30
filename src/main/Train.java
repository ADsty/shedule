package main;

import java.util.ArrayList;

import java.time.LocalTime;

public class Train {
    private String name;
    private String endStation;
    private LocalTime departureTime;
    private ArrayList<String> intStations;

    /**
     * @return the name of this train
     */
    public String getName() {
        return name;
    }

    /**
     * @return the end station of this train
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * @return the departure time of this train
     */
    public LocalTime getDepartureTime() {
        return departureTime;
    }

    /**
     * @return the list of intermediate stations of this train
     */
    public ArrayList<String> getIntStations() {
        return intStations;
    }

    /**
     * @param intStation is the name of the station you want to add
     * @throws IllegalArgumentException when the data is entered incorrectly or already exists such a station
     */
    public void addIntStation(String intStation) {
        if (!intStation.matches("\\w+")) throw new IllegalArgumentException("Station name is invalid");
        if (!intStations.contains(intStation)) intStations.add(intStation);
        else throw new IllegalArgumentException("A station with this name already exists");
    }

    /**
     * @param intStation is the name of the station you want to add
     * @throws IllegalArgumentException when there is no such station
     */
    public void removeIntStation(String intStation) {
        if (!intStations.contains(intStation)) throw new IllegalArgumentException("There is no such station");
        for (String t : intStations) {
            if (t.equals(intStation)) {
                intStations.remove(t) ;
                break;
            }
        }
    }

    /**
     * @param name          is the name of the train
     * @param endStation    is the station to which the train is going
     * @param departureTime is the time when the train departs from the initial station
     * @throws IllegalArgumentException when the data is entered incorrectly
     *                                  Creates a new empty list of intermediate stations
     */
    public Train(String name, String endStation, LocalTime departureTime) {
        if (!name.matches("\\w+") || !endStation.matches("\\w+"))
            throw new IllegalArgumentException("Incorrect data entered");
        this.name = name;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.intStations = new ArrayList<>();
    }
}