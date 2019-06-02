package designpattern.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();

        firstInstance.add("James");
        firstInstance.add("Jackson");

        System.out.println("---- using firstInstance variable");
        firstInstance.printList();

        // to test singleton, get second instance ...
        Singleton secondInstance = Singleton.getInstance();
        secondInstance.add("Kelly");
        secondInstance.add("Corry");
        secondInstance.remove("James");

        System.out.println("---- using secondInstance variable");
        secondInstance.printList();

        // compare two instance
        System.out.println("---- Compare 2 instances");
        System.out.println(firstInstance == secondInstance);
    }
}
