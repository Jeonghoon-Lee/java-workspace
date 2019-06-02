package designpattern.strategy.personModel;

import designpattern.strategy.abstractModel.Person;
import designpattern.strategy.behaviors.SpeakEnglish;

public class ModelPerson extends Person {
	public ModelPerson() {
		speakBehavior = new SpeakEnglish();
	}

	public void display() {
		System.out.println("I'm a person");
	}
}
