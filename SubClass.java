/**
 * Created by ddoshi on 2/18/18.
 */
public class SubClass extends Super {
    // overrides printMethod in Superclass
    public void printMethod() {
        System.out.println("Printed in Subclass");
        super.printMethod();
    }
    public static void main(String[] args) {

        SubClass s = new SubClass();
        s.printMethod();

    }
}
