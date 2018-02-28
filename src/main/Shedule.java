package main;

import java.util.ArrayList;

public class Shedule {
    public ArrayList<Train> names;
    public void findTrain(String endStation, int currentTime,String currentStation){
        for(Train t: names){
            if(t.getEndStation().equals(endStation) && t.getDepartureTime() < currentTime &&
                    t.getIntStations().contains(currentStation))
                System.out.println(t);
        }
    }
    public void removeTrain(String name){
        for( Train t: names){
            if (t.getName().equals(name)) names.remove(t);
        }
    }
    public void addNewTrain(String name , String endStation , int departureTime , ArrayList<String> intStations) {
        Train t = new Train(name , endStation , departureTime , intStations);
        names.add(t);
    }
    public class Train{
        private String name;
        private String endStation;
        private int departureTime;
        private ArrayList<String> intStations;
        public String getName(){
            return name;
        }
        public String getEndStation(){
            return endStation;
        }
        public int getDepartureTime(){
            return departureTime;
        }
        public ArrayList<String> getIntStations(){
            return intStations;
        }
        public void addIntStation(String intStation){
            intStations.add(intStation);
        }
        public void removeIntStation(String intStation){
            for (String t : intStations){
                if (t.equals(intStation)) intStations.remove(t);
            }
        }
        public Train(String name , String endStation , int departureTime , ArrayList intStations){
            this.name = name;
            this.endStation = endStation;
            this.departureTime = departureTime;
            this.intStations = intStations;
        }
    }
    public Shedule(ArrayList<Train> names){
        this.names = names;
    }
}
