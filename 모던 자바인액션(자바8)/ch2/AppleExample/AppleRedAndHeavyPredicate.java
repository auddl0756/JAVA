package Java8.ch2.AppleExample;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple a) {
        return a.getColor()==Color.RED && a.getWeight()>150;
    }
}
