public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams,
            int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * decreases inventory values of ounces, sugar, cream, (and cups), based on
     * coffee sold
     * 
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(this.nCups < 1 || this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams){
            System.out.println("Restocking...");
            this.restock(size, nSugarPackets, nCreams, nCreams);
            System.out.println("Restocked");
        }
            System.out.println("Selling Coffee");
            this.nCups -= 1;
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            System.out.println("Sold!");
        }

    /**
     * restocks cafe materials by adding the needed values for the order
     * bulk order method: 100 each
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int size, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += 100;
        this.nSugarPackets += 100;
        this.nCreams += 100;
        this.nCups += 100;
    }


    public static void main(String[] args) {
        Cafe c = new Cafe("Cafe Cafe", "12 Awesome Ave", 1, 10, 10, 10, 10);
        c.sellCoffee(12, 1, 1);
        // System.out.println("Ounces Left:" + c.nCoffeeOunces);
    }

}
