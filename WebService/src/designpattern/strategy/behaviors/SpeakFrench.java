package designpattern.strategy.behaviors;

import designpattern.strategy.behaviorInterfaces.SpeakBehavior;

public class SpeakFrench implements SpeakBehavior {
    @Override
    public void speak() {
        System.out.println("Bon jour!!");
    }
}
