package main;

import java.util.ArrayList;

public class Train{
    private String name;
    private String endStation;
    private String departureTime;
    private ArrayList<String> intStations;
    public String getName(){
        return name;
    }
    public String getEndStation(){
        return endStation;
    }
    public int getDepartureTime(){
        int time = 0;
        String[] parts = departureTime.split(":");
        for(String part : parts){
            int number = Integer.parseInt(part);
            time = time * 60 + number ;
        }
        return time;
    }
    public ArrayList<String> getIntStations(){
        return intStations;
    }
    public void addIntStation(String intStation){
        intStations.add(intStation);
    }
    public void removeIntStation(String intStation){
        for (String t : intStations){
            if (t.equals(intStation)){
                intStations.remove(t);
                break;
            }
        }
    }
    public Train(String name , String endStation , String departureTime){
        this.name = name;
        this.endStation = endStation;
        this.departureTime = departureTime;
        this.intStations = new ArrayList<>();
    }
}