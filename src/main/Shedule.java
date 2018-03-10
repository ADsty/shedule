package main;

import java.util.ArrayList;

public class Shedule {
    public ArrayList<Train> names;
    /**
     * @param endStation is the name of the station you need to reach
     * @param currentTime is the time in which you make a request
     * @param currentStation is the nearest station to you
     * @return the nearest train
     */
    public Train findTrain(String endStation, String currentTime,String currentStation){
        Train x = new Train("for comparison" , endStation , "24:00" );
        Train p = new Train ("for comparison" , endStation , currentTime );
        for(Train t: names) {
            if (t.getEndStation().equals(endStation) && t.getDepartureTime() > p.getDepartureTime() &&
                    t.getIntStations().contains(currentStation)) {
                if(t.getDepartureTime() < x.getDepartureTime()) x = t;
            }
        }
        return x;
    }
    /**
     * @param name is name of the train that you want to delete
     */
    public void removeTrain(String name){
        for( Train t: names){
            if (t.getName().equals(name)){
                names.remove(t);
                break;
            }
        }
    }
    /**
     * @param t is already created train that you want to add to the list
     */
    public void addNewTrain(Train t) {
        names.add(t);
    }
    /**
     * Creates a schedule with a new list
     */
    public Shedule(){
        this.names = new ArrayList<>();
    }
}
