package Java8.ch2.AppleExample;

public class AppleColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple a) {
        return a.getColor()==Color.GREEN;
    }
}
