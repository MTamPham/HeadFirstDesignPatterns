package headfirst.adapter.ducks;

public class DuckTestDrive {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();

        TurkeyAdapter adapter = new TurkeyAdapter(turkey);

    }
}
