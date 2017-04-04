/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driversim;

/**
 *
 * @author taitjc1
 */
public class DriverSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Location[] locations = new Location[4];
        locations[0] = new Location("Mayfair",3,1);
        locations[1] = new Location("Akina",0,2);
        locations[2] = new Location("Stortford Lodge",1,3);
        locations[3] = new Location("Mahora",2,0);

    }

}

class Driver {

    String location = "";
    String name = "";
    public void driver(String _name, String startLoc){
        this.name = _name;
        this.location = startLoc;
    }

    public String chooseDirection(double random) {
        if (random < 0.5) {
            return "left";
        } else {
            return "right";
        }
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
}
