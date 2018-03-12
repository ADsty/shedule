package main;

import java.util.ArrayList;

import java.time.LocalTime;

import java.util.Iterator;

public class Shedule {
    public ArrayList<Train> names;

    /**
     * @param endStation  is the name of the station you need to reach
     * @param currentTime is the time in which you make a request
     * @return the nearest train
     * The method looks for trains with the same name and compares the time of their departure.
     * If there are two trains with the same departure time, the program will display the train that was added earlier.
     * @throws IllegalArgumentException when the data is entered incorrectly or there is no such train in the timetable
     */
    public ArrayList<Train> findTrain(String endStation, LocalTime currentTime) {
        ArrayList<Train> out = new ArrayList<>();
        if (!endStation.matches("\\w+")) throw new IllegalArgumentException("Incorrect data entered");
        Train x = new Train("forComparison", endStation, LocalTime.of(23, 59, 59, 0));
        Train p = new Train("forComparison", endStation, currentTime);
        for (Train t : names) {
            if (t.getEndStation().equals(endStation) &&
                    t.getDepartureTime().getHour() * 60 + t.getDepartureTime().getMinute() >
                            p.getDepartureTime().getHour() + p.getDepartureTime().getMinute()) {
                if (t.getDepartureTime().getMinute() < x.getDepartureTime().getMinute()) x = t;
            }
        }
        if (!x.getName().equals("forComparison")) out.add(x);
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
