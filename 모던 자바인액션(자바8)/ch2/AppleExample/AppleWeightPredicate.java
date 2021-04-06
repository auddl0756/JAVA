package Java8.ch2.AppleExample;

public class AppleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple a) {
        return a.getWeight()>150;
    }
}
