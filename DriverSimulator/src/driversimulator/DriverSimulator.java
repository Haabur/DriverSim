/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driversimulator;

/**
 *
 * @author taitjc1
 */
public class DriverSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Location[] locations = new Location[4];
        locations[0] = new Location("Mayfair", 3, 1);
        locations[1] = new Location("Akina", 0, 2);
        locations[2] = new Location("Stortford Lodge", 1, 3);
        locations[3] = new Location("Mahora", 2, 0);

        for (int i = 1; i < 6; i++) {
            String name = "Driver " + i;
            Location startingPlace = locations[0];//need to randomize
            Driver zoom = new Driver(name, startingPlace);
            while (zoom.inHastings() == true) {
                zoom.chooseDirection(randomNumber, locations);

            }
        }
    }

}

class Driver {

    String locationName = "";
    String name = "";
    Location location = null;
    boolean inHastings = true;
    

    public Driver(String _name, Location startLoc) {
        this.location = startLoc;
        this.name = _name;
        this.locationName = startLoc.getName();

    }

    public void chooseDirection(double random, Location[] locations) {
        if (random < 0.5) {
            this.location = locations[this.location.Left()];
        } else {
            this.location = locations[this.location.Right()];
        }
    }

    public boolean inHastings() {
        return this.inHastings;
    }
}

class Location {

    String name = "";
    int pointerLeft = 0;
    int pointerRight = 0;

    public Location(String _name, int left, int right) {
        this.name = _name;
        this.pointerLeft = left;
        this.pointerRight = right;
    }

    public String getName() {
        return this.name;
    }

    public int Left() {
        return this.pointerLeft;
    }

    public int Right() {
        return this.pointerRight;
    }
}