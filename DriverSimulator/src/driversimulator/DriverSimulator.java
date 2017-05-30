/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driversimulator;

import java.util.Random;
import java.util.Scanner;

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
        String n = "";
        int seed = 0;
        boolean goodSeed = true;
        Scanner reader = new Scanner(System.in);  // Reading from System.in       
        System.out.println("Please enter a seed.");
        while (goodSeed) {
            n = reader.next();
            if (n.length() < 10 && tryParseInt(n)) {
                seed = Integer.parseInt(n);
                goodSeed = false;
            }
            else{
                System.out.println("Please enter a seed that is a integer with less than 10 digits.");
            }
        }

        Random generator = new Random(seed);
        //double random = generator.nextDouble();
        System.out.println(generator.nextDouble());

        Location[] locations = new Location[4];

        locations[0] = new Location("Mayfair", 3, 1);
        locations[1] = new Location("Akina", 0, 2);
        locations[2] = new Location("Stortford Lodge", 1, 3);
        locations[3] = new Location("Mahora", 2, 0);

        for (int i = 1; i < 6; i++) {
            String name = "Driver " + i;

            Location startingPlace = locations[(int) (generator.nextDouble() * 4)];
            System.out.println(name + " has started in " + startingPlace.getName());
            Driver zoom = new Driver(name, startingPlace);
            while (zoom.inHastings() == true) {
                zoom.chooseDirection(generator.nextDouble(), generator.nextDouble(), locations);
                System.out.println(name + " is in " + zoom.locationName());

            }
        }

    }

    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

    public void chooseDirection(double random, double random2, Location[] locations) {
        if (random < 0.5) {
            this.location = locations[this.location.Left()];
            this.locationName = this.location.getName();
        } else {
            this.location = locations[this.location.Right()];
            this.locationName = this.location.getName();
        }
        if (random2 > 0.9) {
            this.inHastings = false;
            this.locationName = "Outside City";
        }
    }

    public String locationName() {
        return this.locationName;
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
