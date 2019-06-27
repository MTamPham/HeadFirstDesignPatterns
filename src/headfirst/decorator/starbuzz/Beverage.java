package headfirst.decorator.starbuzz;

public abstract class Beverage {
    protected static final int TALL = 12;
    protected static final int GANDE = 16;
    protected static final int VENTI = 24;

    protected String description = "Unknown Beverage";
    protected int size = TALL;

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();

    // when the scheme expands to have size
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
