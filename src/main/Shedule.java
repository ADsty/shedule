package main;

import java.util.ArrayList;

import java.time.LocalTime;

import java.util.Iterator;

public class Shedule {
    private ArrayList<Train> names;

    /**
     * @param endStation  is the name of the station you need to reach
     * @param currentTime is the time in which you make a request
     * @return the nearest train
     * The method looks for trains with the same name and compares the time of their departure.
     * If there are two trains with the same departure time, the program will display the train that was added earlier.
     * @throws IllegalArgumentException when the data is entered incorrectly
     */
    public ArrayList<Train> findTrain(String endStation, LocalTime currentTime) {
        ArrayList<Train> out = new ArrayList<>();
        if (!endStation.matches("\\w+")) throw new IllegalArgumentException("Incorrect data entered");
        for (Train t : names) {
            if (t.getEndStation().equals(endStation) && t.getDepartureTime().isAfter(currentTime)) {
                if (out.isEmpty()) out.add(t);
                else if (out.get(0).getDepartureTime().isAfter(t.getDepartureTime())){
                    out.clear();
                    out.add(t);
                }
            }
        }
        return out;
    }

    /**
     * @param name is name of the train that you want to delete
     * @throws IllegalArgumentException when the data is entered incorrectly
     *                                  The method looks for a trains with the same name and removes it
     */
    public void removeTrain(String name) {
        if (!name.matches("\\w+")) throw new IllegalArgumentException("The name of the train is incorrect");
        Iterator<Train> iterator = names.iterator();
        while (iterator.hasNext()) {
            Train train = iterator.next();
            if (train.getName().equals(name)) iterator.remove();
        }
    }

    /**
     * @param t is already created train that you want to add to the list
     *          The method add the train in a shedule
     */
    public void addNewTrain(Train t) {
        names.add(t);
    }

    /**
     * Creates a new shedule with empty list of trains
     */
    public Shedule() {
        this.names = new ArrayList<>();
    }
}
