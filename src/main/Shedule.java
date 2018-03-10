package main;

import java.util.ArrayList;

public class Shedule {
    public ArrayList<Train> names;
    public String findTrain(String endStation, String currentTime,String currentStation){
        String x = "";
        Train p = new Train ("test" , endStation , currentTime );
        for(Train t: names){
            if(t.getEndStation().equals(endStation) && t.getDepartureTime() > p.getDepartureTime() &&
                    t.getIntStations().contains(currentStation))
                x = t.getName();
        }
        return x;
    }
    public void removeTrain(String name){
        for( Train t: names){
            if (t.getName().equals(name)){
                names.remove(t);
                break;
            }
        }
    }
    public void addNewTrain(Train t) {
        names.add(t);
    }
    public Shedule(){
        this.names = new ArrayList<>();
    }
}
