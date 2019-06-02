package designpattern.strategy.abstractModel;

import designpattern.strategy.behaviorInterfaces.SpeakBehavior;

public abstract class Person {

	public SpeakBehavior speakBehavior;

	public Person() {
	}

	public void setSpeakBehavior(SpeakBehavior sb) {
		speakBehavior = sb;
	}
	public void performSpeak() {
		speakBehavior.speak();
	}

	public abstract void display();
}
