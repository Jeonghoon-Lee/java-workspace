package designpattern.strategy.behaviors;

import designpattern.strategy.behaviorInterfaces.SpeakBehavior;

public class SpeakEnglish implements SpeakBehavior {
	@Override
	public void speak() {
		System.out.println("Hello!!");
	}
}
