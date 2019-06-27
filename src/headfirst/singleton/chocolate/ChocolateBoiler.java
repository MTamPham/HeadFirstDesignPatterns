package headfirst.singleton.chocolate;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }


    // this method leads to problem when we add multi-thread to application
    // it could create different instances
    /*
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new ChocolateBoiler();
        }
        System.out.println("Returning instance of Chocolate Boiler");
        return uniqueInstance;
    }
    */
    // so, there are several ways to improve that method
    // method 1: synchronize the getInstance() method
    // but synchronization is expensive, it leads to overhead and performance reduction
    public synchronized static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new ChocolateBoiler();
        }
        System.out.println("Returning instance of Chocolate Boiler");
        return uniqueInstance;
    }
    // method 2: use eager instantiation
    // but it could be less obvious to a developer familiar with the standard pattern
    //private static ChocolateBoiler uniqueInstance = new ChocolateBoiler();
    //public static ChocolateBoiler getInstance() {
    //    return uniqueInstance;
    //}
    // method 3: double-checked locking
    // but it is overkill when no performance concerns, and we would have to ensure that we are running JVM version 1.5 or higher
    /*
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateBoiler.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateBoiler();
                }
            }
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }
    */

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with a milk/chocolate mixture
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
