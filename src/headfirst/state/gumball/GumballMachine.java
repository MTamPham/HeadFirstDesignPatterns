package headfirst.state.gumball;

public class GumballMachine {
    // step 1: gather up states
    // step 2: create an instance variable to hold the current state, and define values for each of the states
    static final int SOLD_OUT = 0;// out of gumballs
    static final int NO_QUARTER = 1;
    static final int HAS_QUARTER = 2;
    static final int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    // step 3: gather up all the actions that can happen in the system
    // step 4: create methods that use conditional statement to determine what behavior is appropriate in each state
    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter");
                break;
            case SOLD_OUT:
                System.out.println("You can't insert a quarter, the machine is sold out");
                break;
            case SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
                break;
            case NO_QUARTER:
                state = HAS_QUARTER;
                System.out.println("You inserted a quarter");
                break;
        }
    }

    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("Quarter returned");
                state = NO_QUARTER;
                break;
            case SOLD_OUT:
                System.out.println("You can't reject, you haven't inserted a quarter yet");
                break;
            case SOLD:
                System.out.println("Sorry, you already turned the crank");
                break;
            case NO_QUARTER:
                System.out.println("You haven't inserted a quarter");
                break;
        }
    }

    public void turnCrank() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You turned...");
                state = SOLD;
                dispense();
                break;
            case SOLD_OUT:
                System.out.println("You turned but there are no gumballs");
                break;
            case SOLD:
                System.out.println("Turning twice doesn’t get you another gumball!");
                break;
            case NO_QUARTER:
                System.out.println("You turned but there’s no quarter");
                break;
        }
    }

    public void dispense() {
        switch (state) {
            case HAS_QUARTER:
            case SOLD_OUT:
                System.out.println("No gumball dispensed");
                break;
            case SOLD:
                System.out.println("A gumball comes rolling out the slot");
                count = count - 1;
                if (count == 0) {
                    System.out.println("Oops, out of gumballs!");
                    state = SOLD_OUT;
                } else {
                    state = NO_QUARTER;
                }
                break;
            case NO_QUARTER:
                System.out.println("You need to pay first");
                break;
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = NO_QUARTER;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (state == SOLD_OUT) {
            result.append("sold out");
        } else if (state == NO_QUARTER) {
            result.append("waiting for quarter");
        } else if (state == HAS_QUARTER) {
            result.append("waiting for turn of crank");
        } else if (state == SOLD) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }
}
