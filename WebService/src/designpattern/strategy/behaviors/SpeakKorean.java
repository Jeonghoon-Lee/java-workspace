package designpattern.strategy.behaviors;

import designpattern.strategy.behaviorInterfaces.SpeakBehavior;

public class SpeakKorean implements SpeakBehavior {
    @Override
    public void speak() {
        System.out.println("안녕!!");
    }
}
