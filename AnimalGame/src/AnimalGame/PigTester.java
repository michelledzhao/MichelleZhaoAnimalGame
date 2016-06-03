package AnimalGame;


import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class PigTester
{
    public static void main( String args[] )
    {
        MovingThing test = new Pig();
        System.out.println("Pig 1 " + test);

        Pig test2 = new Pig(50,75);
        System.out.println("Pig 2 " + test2);

       Pig test3 = new Pig();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Pig 3 " + test2);
    }
}
