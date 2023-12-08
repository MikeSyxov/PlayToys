import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private int toyId;
    private String toyTitle;
    private int toyVictoryFrequency;

    public Toy(int toyId, String toyTitle, int toyVictoryFrequency) {
        this.toyId = toyId;
        this.toyTitle = toyTitle;
        this.toyVictoryFrequency = toyVictoryFrequency;
    }

}