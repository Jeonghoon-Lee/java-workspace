package designpattern.strategy;

import designpattern.strategy.behaviors.SpeakFrench;
import designpattern.strategy.behaviors.SpeakKorean;
import designpattern.strategy.personModel.ModelPerson;
import designpattern.strategy.abstractModel.Person;

public class PersonSimulator {
    public static void main(String[] args) {
        Person person = new ModelPerson();
        System.out.println("\n--- Model Person created ---");

        // default behavior is speaking english
        person.performSpeak();

        person.speakBehavior = new SpeakFrench();
        person.performSpeak();

        person.speakBehavior = new SpeakKorean();
        person.performSpeak();
    }
}
