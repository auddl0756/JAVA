package Java8.ch2.AppleExample;

public class Apple {

    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }
}
